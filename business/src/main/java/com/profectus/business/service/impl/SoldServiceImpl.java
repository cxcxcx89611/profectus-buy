package com.profectus.business.service.impl;

import com.profectus.business.dao.SoldRepository;
import com.profectus.business.dto.SoldDto;
import com.profectus.business.model.Sold;
import com.profectus.business.service.SoldService;
import com.profectus.business.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SoldServiceImpl implements SoldService {
    private final SoldRepository soldRepository;

    @Autowired
    public SoldServiceImpl(SoldRepository soldRepository) {
        this.soldRepository = soldRepository;
    }


    @Override
    public List<SoldDto> getSoldList() {
        List<Sold> soldList = soldRepository.findAll();
        return CopyUtil.copyList(soldList, SoldDto.class);
    }

    @Transactional
    public void save(SoldDto soldDto) {
        Sold sold = new Sold();
        sold.setSoldDate(soldDto.getSoldDate());
        sold.setSoldPrice(soldDto.getSoldPrice());
        sold.setSoldQuantity(soldDto.getSoldQuantity());
        soldRepository.insertSoldWithProduct(soldDto.getSoldQuantity(),
                soldDto.getSoldPrice(),
                soldDto.getSoldDate(),
                soldDto.getProduct().getId());

    }
}