package com.profectus.business.service.impl;

import com.profectus.business.dao.ProductRepository;
import com.profectus.business.dto.ProductDto;
import com.profectus.business.model.Product;
import com.profectus.business.service.ProductService;
import com.profectus.business.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    

    @Override
    public List<ProductDto> getProductList() {
        List<Product> productList = productRepository.findAll();
        return CopyUtil.copyList(productList, ProductDto.class);
    }
}
