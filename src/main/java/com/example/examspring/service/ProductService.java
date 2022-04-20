package com.example.examspring.service;

import com.example.examspring.dto.ApiResponse;
import com.example.examspring.dto.ProductDTO;
import com.example.examspring.entity.Product;
import com.example.examspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ApiResponse getAll() {
        List<Product> all = productRepository.findAll();
        return new ApiResponse("Mana", true, all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            return new ApiResponse("Mana", true, byId.get());
        }
        return new ApiResponse("ERROR", false);
    }

    public ApiResponse add(ProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setInfo(productDto.getInfo());
        Product save = productRepository.save(product);
        return new ApiResponse("ADDED", true, save);
    }

    public ApiResponse edit(Integer id, ProductDTO productDto) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setInfo(productDto.getInfo());
            Product save = productRepository.save(product);
            return new ApiResponse("EDITED", true, save);
        }
        return new ApiResponse("ERROR", false);
    }

    public ApiResponse delete(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            productRepository.deleteById(id);
            return new ApiResponse("DALETED", true);
        }
        return new ApiResponse("ERROR", false);
    }
}