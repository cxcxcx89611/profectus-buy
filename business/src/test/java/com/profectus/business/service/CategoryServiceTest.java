package com.profectus.business.service;


import com.profectus.business.dto.CategoryDto;
import com.profectus.business.model.Category;
import com.profectus.business.model.Product;
import com.profectus.business.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {


    @Autowired
    private CategoryServiceImpl categoryService;


    /*
     * test case 1: test get category list,  given test data size:2
     */
    @Test
    public void getCategoryListTest() {
        List<CategoryDto> categoryList = categoryService.getCategoryList();
        assertEquals(2, categoryList.size());
    }


}