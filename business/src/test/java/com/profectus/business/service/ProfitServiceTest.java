package com.profectus.business.service;


import com.profectus.business.dto.ProfitSearchDto;
import com.profectus.business.service.impl.ProfitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static org.junit.Assert.assertEquals;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfitServiceTest {


    @Autowired
    private ProfitServiceImpl profitService;

    /*
     * test case 1.1: :  calculate profit of all products belongs to Dairy category
     * based on test data.sql,  expect value is 298.89
     */
    @Test
    public void getProfitTestWithCategory() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto(null, "Dairy",null, null, null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "365";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 1.2: :  calculate profit of all products belongs to non exist Category
     * based on test data.sql,  expect value is No such categories : Tool at DB!
     */
    @Test
    public void getProfitTestWithNonExistCategory() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto(null, "Tool",null, null, null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "No such categories : Tool at DB!";
        assertEquals(profitExpect, profitAcutal);
    }
    /*
     * test case 2.1 :  calculate profit by both Category and Product list,
     * if category not null, the product list will be ignored.
     * based on test data.sql,  expect value is 365
     */
    @Test
    public void testProfitTestWithCategoryAndProductList() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto("Bananas Apples Oranges", "Dairy",null, null, null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "365";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 2.2: :  calculate profit of product list: Bananas Apples Oranges
     * based on test data.sql,  expect value is 281.67
     */
    @Test
    public void testProfitTestWithProductList() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto("Bananas Apples Oranges", null,null, null, null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "281.67";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 2.3: :  calculate profit of non existing product list: Pear
     * based on test data.sql,  expect value is our searched product list has no product existing at DB!
     */
    @Test
    public void testProfitTestWithNonExistProductList() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto("Pear", null,null, null, null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "Your searched product list has no product existing at DB!";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 2.4: :  calculate profit of partial non existing product list: Pear Banana
     * based on test data.sql,  expect value is Your searched product list contains product which not existing in System, please check!
     */
    @Test
    public void testProfitTestWithPartialNonExistProductList() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto("Pear Bananas", null,null, null, null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "Your searched product list contains product which not existing in System, please check!";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 2.5:  calculate profit of product list within time range 2020-06-03 ~ 2020-06-30
     * based on test data.sql,  expect value is 165
     */
    @Test
    public void testProfitTestWithProductListAndDate() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto("Milk Cream Cheese" ,null,LocalDate.parse("2020-06-01",DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2020-06-30",DateTimeFormatter.ofPattern("yyyy-MM-dd")), null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "165";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 3.1:  calculate profit of product list within time range 2020-06-03 ~ 2020-07-31
     * based on test data.sql,  expect value is 306.67
     */
    @Test
    public void testProfitTestWithNullProductListAndDate() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto(null ,null,LocalDate.parse("2020-06-01",DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2020-07-31",DateTimeFormatter.ofPattern("yyyy-MM-dd")), null, null);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "306.67";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 3.2:  calculate profit of product list within time range 2020-06-03 ~ 2020-07-31, purchased price range 0 ~ 500
     * based on test data.sql,  expect value is 306.67
     */
    @Test
    public void testProfitTestWithNullProductListAndDateAndPurPrice() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto(null ,null,LocalDate.parse("2020-06-01",DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse("2020-07-31",DateTimeFormatter.ofPattern("yyyy-MM-dd")), 0, 500);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "306.67";
        assertEquals(profitExpect, profitAcutal);
    }

    /*
     * test case 3.3:  calculate profit of product list within purchased price range 0 ~ 500
     * based on test data.sql,  expect value is 446.67
     */
    @Test
    public void testProfitTestWithNullProductListAndPurPrice() {
        LocalDate date = LocalDate.now();
        ProfitSearchDto profitDto = new ProfitSearchDto(null ,null,null, null, 0, 500);
        String profitAcutal = profitService.profit(profitDto);
        String profitExpect = "446.67";
        assertEquals(profitExpect, profitAcutal);
    }


}