package com.profectus.business.dao;

import com.profectus.business.model.Sold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface SoldRepository extends JpaRepository<Sold, Integer> {

    @Modifying
    @Query(value = "insert into sold(sold_quantity,sold_price,sold_date,product_id) values(?1,?2, ?3, ?4)",nativeQuery = true)
    int insertSoldWithProduct(int sold_quantity, int sold_price, LocalDate sold_date, int product_id);
}
