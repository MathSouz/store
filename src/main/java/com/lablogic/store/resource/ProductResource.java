package com.lablogic.store.resource;

import com.lablogic.store.model.Product;
import com.lablogic.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource
{
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @GetMapping("/product")
    public List<Product> getOne(@RequestParam("code") String code)
    {
        List<Product> products = productRepository.findByCode(code);
        return products;
    }

    @PostMapping("/product")
    public Product insert(@RequestBody Product product)
    {
        product.setName(product.getName().toUpperCase());
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    public void delete(@RequestParam("id") long id)
    {
        productRepository.delete(productRepository.findById(id));
    }

    @PutMapping("/product")
    public Product update(@RequestBody Product product)
    {
        return productRepository.save(product);
    }
}
