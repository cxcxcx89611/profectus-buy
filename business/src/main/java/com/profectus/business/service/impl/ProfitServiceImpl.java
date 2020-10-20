package com.profectus.business.service.impl;

import com.profectus.business.controller.CategoryController;
import com.profectus.business.dao.ProductRepository;
import com.profectus.business.dao.PurchasedRepository;
import com.profectus.business.dao.SoldRepository;
import com.profectus.business.dto.ProfitSearchDto;
import com.profectus.business.exception.BusinessException;
import com.profectus.business.exception.BusinessExceptionCode;
import com.profectus.business.service.ProfitService;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProfitServiceImpl implements ProfitService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

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
    public String profit(ProfitSearchDto profitSearchDto) {
        String categroyString = profitSearchDto.getCategoryList();
        String productString = profitSearchDto.getProductList();
        Integer priceFrom = profitSearchDto.getPriceFrom();
        Integer priceTo = profitSearchDto.getPriceTo();
        String profit;
        //if category list is not null,  get all the products of this category
        if (!StringUtils.isEmpty(categroyString)) {
            String[] categorys = categroyString.split("\\s+");
            List<String> categoryNameList = Arrays.asList(categorys);
            List<Integer> productIdList = productRepository.findIdByCategoryNames(categoryNameList);
            if (productIdList.size() == 0) {
                throw new BusinessException(BusinessExceptionCode.NO_SUCH_CATEGORY_ERROR);
            }
            profit = getProfit(productIdList, profitSearchDto.getSearchFromDate(),
                    profitSearchDto.getSearchToDate(), profitSearchDto.getPriceFrom(), profitSearchDto.getPriceTo());
        } else {
            //if category list is null,  take all the product input filed value
            if (!StringUtils.isEmpty(productString)) {
                String[] products = productString.split("\\s+");
                List<String> productNameList = Arrays.asList(products);
                List<Integer> productIdList = productRepository.findIdByProductNames(productNameList);
                if (productIdList.size() == 0) {
                    throw new BusinessException(BusinessExceptionCode.NO_SUCH_PRODUCTS_ERROR);
                } else if (productIdList.size() != products.length) {
                    throw new BusinessException(BusinessExceptionCode.NO_PARTIAL_PRODUCT_ERROR);
                }
                profit = getProfit(productIdList, profitSearchDto.getSearchFromDate(),
                        profitSearchDto.getSearchToDate(), profitSearchDto.getPriceFrom(), profitSearchDto.getPriceTo());
            } else {
                // No input product list, will calculate all product profit
                profit = getProfit(null, profitSearchDto.getSearchFromDate(),
                        profitSearchDto.getSearchToDate(), profitSearchDto.getPriceFrom(), profitSearchDto.getPriceTo());
            }
        }
        return profit;
    }

    public String getProfit(List<Integer> productIdList, LocalDate searchFromDate,
                            LocalDate searchToDate, Integer priceFrom, Integer priceTo) {
        List<Object[]> productUnitPriceList = purchasedRepository.calculateUnitPurchasedPriceByConditions(productIdList, searchToDate, priceFrom, priceTo);
        List<Object[]> productTotalSoldQuantiyList = soldRepository.calculateTotalSoldPriceQuantityByConditions(productIdList,
                searchFromDate, searchToDate);
        Float profit = new Float(0.00);
        for (Object[] a : productUnitPriceList) {
            for (Object[] b : productTotalSoldQuantiyList) {
                if (a[0] == b[0]) {
                    Float productUnitPurPrice = Float.valueOf(a[1].toString());
                    Float productTotalSoldPrice = Float.valueOf(b[1].toString());
                    Float productTotalSoldQuantity = Float.valueOf(b[2].toString());
                    Float productProfit = productTotalSoldPrice - productTotalSoldQuantity * productUnitPurPrice;
                    profit = profit + productProfit;
                    LOG.info("product name :" + a[0] +
                            " product unit price: " + productUnitPurPrice +
                            " product total sold price" + productTotalSoldPrice +
                            " product total sold quantity" + productTotalSoldQuantity +
                            " product profit " + productProfit);
                }
            }
        }
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(profit);
    }
}
