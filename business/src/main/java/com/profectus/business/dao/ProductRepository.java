package com.profectus.business.dao;

import com.profectus.business.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product WHERE product_name in(?1)",nativeQuery = true)
    List<Integer> findIdByProductNames(List<String> productNameList);

    @Query(value = "select a.ID from product a, category b WHERE a.category_id = b.id and b.category_name in(?1)",nativeQuery = true)
    List<Integer> findIdByCategoryNames(List<String> categoryNameList);

}
