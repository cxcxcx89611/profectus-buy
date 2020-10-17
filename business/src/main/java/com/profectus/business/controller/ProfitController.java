package com.profectus.business.controller;

import com.profectus.business.dto.ProfitSearchDto;
import com.profectus.business.dto.ResponseDto;
import com.profectus.business.service.ProfitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/business/profit")
public class ProfitController {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final ProfitService profitService;

    @Autowired
    public ProfitController(ProfitService profitService) {
        this.profitService = profitService;
    }


    @PostMapping("/calculate")
    public ResponseDto calculate(@RequestBody ProfitSearchDto ProfitSearchDto) {
        ResponseDto responseDto = new ResponseDto();
        System.out.println("get DTO!" + ProfitSearchDto);
        String profitString = "$ " + profitService.profit(ProfitSearchDto);
        responseDto.setContent(profitString);
        return responseDto;
    }
}
