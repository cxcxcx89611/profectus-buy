package com.profectus.business.controller;

import com.profectus.business.dto.CategoryDto;
import com.profectus.business.dto.PurchasedDto;
import com.profectus.business.dto.ResponseDto;
import com.profectus.business.service.CategoryService;
import com.profectus.business.service.PurchasedService;
import com.profectus.business.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business/purchased")
public class PurchasedController {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final PurchasedService purchasedService;

    @Autowired
    public PurchasedController(PurchasedService purchasedService) {
        this.purchasedService = purchasedService;
    }


    @GetMapping("/all")
    public ResponseDto all() {
        ResponseDto responseDto = new ResponseDto();
        List<PurchasedDto> purchasedDtoList = purchasedService.getPurchasedList();
        responseDto.setContent(purchasedDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody PurchasedDto purchasedDto) {

        ValidatorUtil.require(purchasedDto.getPurchasedPrice(), "purchased price");
        ValidatorUtil.require(purchasedDto.getPurchasedQuantity(), "purchased quantity");

        ResponseDto responseDto = new ResponseDto();
        System.out.println("get DTO!" + purchasedDto);
        purchasedService.save(purchasedDto);
        responseDto.setContent(purchasedDto);
        return responseDto;
    }

}
