package com.profectus.business.dao;

import com.profectus.business.model.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedRepository extends JpaRepository<Purchased, Integer> {
}
