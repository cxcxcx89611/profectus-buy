package com.profectus.business.controller;

import com.profectus.business.dto.ProductDto;
import com.profectus.business.dto.ResponseDto;
import com.profectus.business.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseDto all() {
        ResponseDto responseDto = new ResponseDto();
        List<ProductDto> productDtoList = productService.getProductList();
        responseDto.setContent(productDtoList);
        return responseDto;
    }
}
