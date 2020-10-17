package com.profectus.business.service;


import com.profectus.business.dto.SoldDto;
import com.profectus.business.model.Category;
import com.profectus.business.model.Product;
import com.profectus.business.service.impl.SoldServiceImpl;
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
public class SoldServiceTest {


    @Autowired
    private SoldServiceImpl soldService;


    /*
     * test case 1: test get sold list,  given test data size:6
     */
    @Test
    public void getSoldListTest() {
        List<SoldDto> soldList = soldService.getSoldList();
        assertEquals(6, soldList.size());
    }
    
    /*
     * test case 2: test save one sold dto object
     */
    @Test
    public void saveSoldTest() {
        LocalDate date = LocalDate.now();
        SoldDto soldDto = new SoldDto(7,new Product(1,"Milk",new Category(1,"Dairy")),
                100, 500 ,LocalDate.now(),"Milk",1);
        soldService.save(soldDto);
        List<SoldDto> soldList = soldService.getSoldList();
        SoldDto soldDtoActual = soldList.get(soldList.size()-1);
        assertEquals(soldDto.toString(), soldDtoActual.toString());
    }

    /*
     * test case 3: test save one null sold dto object, expect null exception
     */
    @Test(expected = NullPointerException.class)
    public void saveExceptionSoldTest() {
        LocalDate date = LocalDate.now();
        SoldDto soldDto = new SoldDto();
        soldService.save(soldDto);
        List<SoldDto> soldList = soldService.getSoldList();
        SoldDto soldDtoActual = soldList.get(soldList.size()-1);
        assertEquals(soldDto.toString(), soldDtoActual.toString());
    }

}