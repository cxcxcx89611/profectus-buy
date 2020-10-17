package com.profectus.business.service.impl;

import com.profectus.business.dao.ProductRepository;
import com.profectus.business.dao.PurchasedRepository;
import com.profectus.business.dao.SoldRepository;
import com.profectus.business.dto.ProfitSearchDto;
import com.profectus.business.service.ProfitService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProfitServiceImpl implements ProfitService {

    private final PurchasedRepository purchasedRepository;

    private final SoldRepository soldRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ProfitServiceImpl(PurchasedRepository purchasedRepository, SoldRepository soldRepository,
                             ProductRepository productRepository) {
        this.purchasedRepository = purchasedRepository;
        this.soldRepository = soldRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String search(ProfitSearchDto profitSearchDto) {

        String categroyString = profitSearchDto.getCategoryList();
        String productString = profitSearchDto.getProductList();
        String profit;
        //if category list is not null,  get all the products of this category
        if (!StringUtils.isEmpty(categroyString)) {
            String[] categorys = categroyString.split("\\s+");
            List<String> categoryNameList = Arrays.asList(categorys);
            List<Integer> productIdList = productRepository.findIdByCategoryNames(categoryNameList);
            profit = getProfit(productIdList, profitSearchDto.getSearchFromDate(),
                    profitSearchDto.getSearchToDate(), profitSearchDto.getPriceFrom(), profitSearchDto.getPriceTo());
        } else {
            //if category list is null,  take all the product input filed value
            if (!StringUtils.isEmpty(productString)) {
                String[] products = productString.split("\\s+");
                List<String> productNameList = Arrays.asList(products);
                List<Integer> productIdList = productRepository.findIdByProductNames(productNameList);
                profit = getProfit(productIdList, profitSearchDto.getSearchFromDate(),
                        profitSearchDto.getSearchToDate(), profitSearchDto.getPriceFrom(), profitSearchDto.getPriceTo());
            } else {
                // No input product list
                profit = getProfit(null, profitSearchDto.getSearchFromDate(),
                        profitSearchDto.getSearchToDate(), profitSearchDto.getPriceFrom(), profitSearchDto.getPriceTo());
            }
        }
        return profit;
    }

    public String getProfit( List<Integer> productIdList, LocalDate searchFromDate,
                            LocalDate searchToDate, Integer priceFrom, Integer priceTo) {
        Float unitPurchasedPrice = purchasedRepository.calculateUnitPurchasedPriceByConditions(productIdList,
                searchFromDate, searchToDate, priceFrom, priceTo);
        List<Object[]> resultList = soldRepository.calculateTotalSoldPriceQuantityByConditions(productIdList,
                searchFromDate, searchToDate, priceFrom, priceTo);
        Float soldTotalPrice = Float.valueOf(resultList.get(0)[0].toString()) ;
        System.out.println("unitPurchasedPrice:" + unitPurchasedPrice);
        System.out.println("soldTotalPrice:" + soldTotalPrice);
        Integer soldTotalQuantity = Integer.valueOf(resultList.get(0)[1].toString());
        System.out.println("soldTotalQuantity:" + soldTotalQuantity);
        Float profit = Float.valueOf(soldTotalPrice - unitPurchasedPrice*soldTotalQuantity);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(profit);
    }
}
