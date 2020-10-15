package com.profectus.business.dao;

import com.profectus.business.model.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, Integer> {

    @Modifying
    @Query(value = "insert into purchased(purchased_quantity,purchased_price,purchased_date,product_id) values(?1,?2, ?3, ?4)",nativeQuery = true)
    int insertPurchasedWithProduct(int purchased_quantity, int purchased_price, LocalDate purchased_date, int product_id);
}

