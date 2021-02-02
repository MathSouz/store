package com.lablogic.store.repository;

import com.lablogic.store.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product findById(long id);

    @Query(value = "SELECT * FROM products WHERE code=?", nativeQuery = true)
    Product findByCode(String code);
}
