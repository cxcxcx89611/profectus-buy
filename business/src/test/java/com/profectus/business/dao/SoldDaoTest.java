package com.profectus.business.dao;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SoldDaoTest {


    @Autowired
    private SoldRepository soldRepository;


    /*
     * test case 1: test insert one new sold
     * expect value: 1
     */
    @Test
    @Transactional
    public void testInsertSoldWithProduct() {
        int a = soldRepository.insertSoldWithProduct(200, 500, LocalDate.parse("2020-06-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 3);
        assertEquals(1, a);
    }

    @Test
    public void testCalculateTotalSoldPriceQuantityByDateConditions(){
        List<Integer> productIdList = new ArrayList<>();
        productIdList.add(1);
        productIdList.add(2);
        productIdList.add(3);
        List<Object[]> list = soldRepository.calculateTotalSoldPriceQuantityByConditions(productIdList,LocalDate.parse("2020-06-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                , LocalDate.parse("2020-06-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        List<Object[]> expectList = new ArrayList<>();
        Object [] expectArray1 = {1,540.0, 180};
        Object [] expectArray2 = {2,300.0, 75};
        expectList.add(expectArray1);
        expectList.add(expectArray2);
        assertEquals(expectList.size(), list.size());
        assertEquals(expectList.get(0)[0].toString(), list.get(0)[0].toString());
        assertEquals(expectList.get(0)[1].toString(), list.get(0)[1].toString());
        assertEquals(expectList.get(0)[2].toString(), list.get(0)[2].toString());
        assertEquals(expectList.get(1)[0].toString(), list.get(1)[0].toString());
        assertEquals(expectList.get(1)[1].toString(), list.get(1)[1].toString());
        assertEquals(expectList.get(1)[2].toString(), list.get(1)[2].toString());
    }
}