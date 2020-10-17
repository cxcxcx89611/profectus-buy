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
import java.util.Map;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, Integer> {

    @Modifying
    @Query(value = "insert into purchased(purchased_quantity,purchased_price,purchased_date,product_id) values(?1,?2, ?3, ?4)",nativeQuery = true)
    int insertPurchasedWithProduct(int purchased_quantity, int purchased_price, LocalDate purchased_date, int product_id);

    @Query(value = "select p.product_id, truncate((sum(p.purchased_price)/sum(p.purchased_quantity)),10) from purchased p where  " +
            " ( p.product_id in (?1) or ?1 IS NULL)" +
            " and ( p.purchased_date <= ?2 or ?2 IS NULL)" +
            " and ( p.purchased_price >= ?3 or ?3 IS NULL)" +
            " and ( p.purchased_price <= ?4 or ?4 IS NULL) group by p.product_id",nativeQuery = true)
    List<Object[]> calculateUnitPurchasedPriceByConditions(List<Integer> productIdList, LocalDate purchasedToDate, Integer purchasedFromPrice, Integer purchasedToPrice);

}


