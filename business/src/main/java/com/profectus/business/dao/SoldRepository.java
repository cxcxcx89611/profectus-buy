package com.profectus.business.dao;

import com.profectus.business.model.Sold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Repository
public interface SoldRepository extends JpaRepository<Sold, Integer> {

    @Modifying
    @Query(value = "insert into sold(sold_quantity,sold_price,sold_date,product_id) values(?1,?2, ?3, ?4)",nativeQuery = true)
    int insertSoldWithProduct(int sold_quantity, int sold_price, LocalDate sold_date, int product_id);

    @Query(value = "select sum(sold_price) from sold s WHERE (s.product_id in (?1) or ?1 IS NULL)",nativeQuery = true)
    int calculateSoldWithCategory(List<Integer> productIdList);


    @Query(value = "select sum(s.sold_price), sum(sold_quantity) from sold s where  " +
            " ( s.product_id in (?1) or ?1 IS NULL)" +
            " and ( s.sold_date >= ?2 or ?2 IS NULL)" +
            " and ( s.sold_date <= ?3 or ?3 IS NULL)" +
            " and ( s.sold_price >= ?4 or ?4 IS NULL)" +
            " and ( s.sold_price <= ?5 or ?5 IS NULL)",nativeQuery = true)
    List<Object[]> calculateTotalSoldPriceQuantityByConditions(List<Integer> productIdList, LocalDate purchasedFromDate, LocalDate purchasedToDate, Integer purchasedFromPrice, Integer purchasedToPrice);

}
