package com.profectus.business.service;


import com.profectus.business.dto.ProductDto;
import com.profectus.business.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {


    @Autowired
    private ProductServiceImpl productService;


    /*
     * test case 1: test get product list,  given test data size:6
     */
    @Test
    public void getProductListTest() {
        List<ProductDto> productList = productService.getProductList();
        assertEquals(6, productList.size());
    }


}