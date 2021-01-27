package com.lablogic.store.resource;

import com.lablogic.store.model.Product;
import com.lablogic.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource
{
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getOne(@PathVariable("id") long id)
    {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product insert(@RequestBody Product product)
    {
        product.setName(product.getName().toUpperCase());
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    public void delete(@RequestBody Product product)
    {
        productRepository.delete(product);
    }

    @PutMapping("/product")
    public Product update(@RequestBody Product product)
    {
        return productRepository.save(product);
    }
}
