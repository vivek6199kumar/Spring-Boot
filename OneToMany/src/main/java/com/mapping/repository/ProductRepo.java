package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Product;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer> {

}
