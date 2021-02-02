package com.lablogic.store.resource;

import com.lablogic.store.StoreApplication;
import com.lablogic.store.Token;
import com.lablogic.store.model.Product;
import com.lablogic.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductResource
{
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAll(@RequestHeader Map<String, String> headers)
    {
        String auth = headers.get("authorization");

        if(Token.verifyTokenAsHeader(auth))
        {
            return productRepository.findAll();
        }

        else
        {
            return new ArrayList<>();
        }
    }

    @GetMapping("/product")
    public Product getOne(@RequestHeader Map<String, String> headers, @RequestParam("code") String code)
    {
        String auth = headers.get("authorization");

        if(Token.verifyTokenAsHeader(auth))
        {
            return productRepository.findByCode(code);
        }

        else
        {
            return null;
        }
    }

    @PostMapping("/product")
    public Product insert(@RequestHeader Map<String, String> headers, @RequestBody Product product)
    {
        String auth = headers.get("authorization");

        if(Token.verifyTokenAsHeader(auth))
        {
            product.setName(product.getName().toUpperCase());
            return productRepository.save(product);
        }

        else
        {
            return null;
        }
    }

    @DeleteMapping("/product")
    public void delete(@RequestHeader Map<String, String> headers, @RequestParam("code") String code)
    {
        String auth = headers.get("authorization");

        if(Token.verifyTokenAsHeader(auth))
        {
            productRepository.delete(productRepository.findByCode(code));
        }
    }

    @PutMapping("/product")
    public Product update(@RequestHeader Map<String, String> headers, @RequestBody Product product)
    {
        String auth = headers.get("authorization");

        if(Token.verifyTokenAsHeader(auth))
        {
            return productRepository.save(product);
        }

        else
        {
            return null;
        }
    }
}
