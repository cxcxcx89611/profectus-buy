package com.profectus.business.dao;

import com.profectus.business.model.Sold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldRepository extends JpaRepository<Sold, Integer> {
}
