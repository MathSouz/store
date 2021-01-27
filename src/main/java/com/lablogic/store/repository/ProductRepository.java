package com.lablogic.store.repository;

import com.lablogic.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product findById(long id);
}
