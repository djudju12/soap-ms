package com.jonathan.products.soap.productssoap.repository;

import com.jonathan.products.soap.productssoap.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {
}
