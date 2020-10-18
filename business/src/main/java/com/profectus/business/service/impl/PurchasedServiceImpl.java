package com.profectus.business.service.impl;

import com.profectus.business.dao.PurchasedRepository;
import com.profectus.business.dto.PurchasedDto;

import com.profectus.business.model.Purchased;
import com.profectus.business.service.PurchasedService;
import com.profectus.business.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchasedServiceImpl implements PurchasedService {

    private final PurchasedRepository purchasedRepository;

    @Autowired
    public PurchasedServiceImpl(PurchasedRepository purchasedRepository) {
        this.purchasedRepository = purchasedRepository;
    }


    @Override
    public List<PurchasedDto> getPurchasedList() {
        List<Purchased> purchasedList = purchasedRepository.findAll();
        return CopyUtil.copyList(purchasedList, PurchasedDto.class);
    }


    @Transactional
    @Override
    public void save(PurchasedDto purchasedDto) {
        Purchased purchased = new Purchased();
        purchased.setPurchasedDate(purchasedDto.getPurchasedDate());
        purchased.setPurchasedPrice(purchasedDto.getPurchasedPrice());
        purchased.setPurchasedQuantity(purchasedDto.getPurchasedQuantity());
        purchasedRepository.insertPurchasedWithProduct(purchasedDto.getPurchasedQuantity(),
                purchasedDto.getPurchasedPrice(),
                purchasedDto.getPurchasedDate(),
                purchasedDto.getProduct().getId());

    }
}
