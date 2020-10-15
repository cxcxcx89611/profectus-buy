package com.profectus.business.controller;

import com.profectus.business.dto.SoldDto;
import com.profectus.business.dto.ResponseDto;
import com.profectus.business.service.SoldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business/sold")
public class SoldController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final SoldService soldService;

    @Autowired
    public SoldController(SoldService soldService) {
        this.soldService = soldService;
    }


    @GetMapping("/all")
    public ResponseDto all() {
        System.out.println("get the request from GUI!");
        ResponseDto responseDto = new ResponseDto();
        List<SoldDto> soldDtoList = soldService.getSoldList();
        responseDto.setContent(soldDtoList);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody SoldDto soldDto) {
        ResponseDto responseDto = new ResponseDto();
        System.out.println(soldDto);
        soldService.save(soldDto);
        responseDto.setContent(soldDto);
        return responseDto;
    }
}
