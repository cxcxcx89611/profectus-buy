package com.profectus.business.service;


import com.profectus.business.dto.PurchasedDto;
import com.profectus.business.model.Category;
import com.profectus.business.model.Product;
import com.profectus.business.model.Purchased;
import com.profectus.business.service.impl.PurchasedServiceImpl;
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
public class PurchasedServiceTest {


    @Autowired
    private PurchasedServiceImpl purchasedService;


    /*
     * test case 1: test get purchased list, given test data size:6
     */
    @Test
    public void getPurchasedListTest() {
        List<PurchasedDto> purchasedList = purchasedService.getPurchasedList();
        assertEquals(6, purchasedList.size());
    }

    /*
     * test case 2: test save one purchased dto object
     */
    @Test
    public void savePurchasedTest() {
        LocalDate date = LocalDate.now();
        PurchasedDto purchasedDto = new PurchasedDto(7,new Product(1,"Milk",new Category(1,"Dairy")),
                "Milk",1,100,500, LocalDate.now());
        purchasedService.save(purchasedDto);
        List<PurchasedDto> purchasedList = purchasedService.getPurchasedList();
        PurchasedDto purchasedDtoActual = purchasedList.get(purchasedList.size()-1);
        assertEquals(purchasedDto.toString(), purchasedDtoActual.toString());
    }

    /*
     * test case 3: test save one null purchased dto object, expect null exception
     */
    @Test(expected = NullPointerException.class)
    public void saveExceptionPurchasedTest() {
        LocalDate date = LocalDate.now();
        PurchasedDto purchasedDto = new PurchasedDto();
        purchasedService.save(purchasedDto);
        List<PurchasedDto> purchasedList = purchasedService.getPurchasedList();
        PurchasedDto purchasedDtoActual = purchasedList.get(purchasedList.size()-1);
        assertEquals(purchasedDto.toString(), purchasedDtoActual.toString());
    }

}