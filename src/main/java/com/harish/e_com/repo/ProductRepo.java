package com.harish.e_com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.e_com.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
