package com.profectus.business.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoTest {


    @Autowired
    private ProductRepository productRepository;


    /*
     * test case 1: test get product id list by given null product name
     * expect value: 0
     */
    @Test
    public void testFindIdByNullProductNames() {
        List<String> productNameList = null;
        List<Integer> resultList = productRepository.findIdByProductNames(productNameList);
        assertEquals(0, resultList.size());
    }

    /*
     * test case 2: test get product id list by given product name
     * expect value: [1,3]
     */
    @Test
    public void testFindIdByProductNames() {
        String[] productNames = "Milk Cheese".split("\\s+");
        List<String> productNameList = Arrays.asList(productNames);
        List<Integer> resultList = productRepository.findIdByProductNames(productNameList);
        List<Integer> expectList = new ArrayList<Integer>();
        expectList.add(1);
        expectList.add(3);
        assertEquals(expectList, resultList);
    }

    /*
     * test case 2: test get product id list by given category name
     * expect value: [1,3]
     */
    @Test
    public void findIdByCategoryNames() {
        String[] productNames = "Dairy".split("\\s+");
        List<String> categoryNameList = Arrays.asList(productNames);
        List<Integer> resultList = productRepository.findIdByCategoryNames(categoryNameList);
        List<Integer> expectList = new ArrayList<Integer>();
        expectList.add(1);
        expectList.add(2);
        expectList.add(3);
        assertEquals(expectList, resultList);
    }

    /*
     * test case 2: test get product id list by non exist category name
     * expect value: []
     */
    @Test
    public void findIdByNonExistCategoryNames() {
        String[] productNames = "Tool".split("\\s+");
        List<String> categoryNameList = Arrays.asList(productNames);
        List<Integer> resultList = productRepository.findIdByCategoryNames(categoryNameList);
        List<Integer> expectList = new ArrayList<Integer>();
        assertEquals(expectList, resultList);
    }

}