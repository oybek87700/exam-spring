package com.example.examspring.controller;

import com.example.examspring.dto.ApiResponse;
import com.example.examspring.dto.ProductDTO;
import com.example.examspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse all = productService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse one = productService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(one);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','ADMIN2')")
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody ProductDTO productDTO) {
        ApiResponse add = productService.add(productDTO);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(add);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody ProductDTO productDTO) {

        ApiResponse edit = productService.edit(id, productDTO);
        return ResponseEntity.status(edit.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(edit);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = productService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(delete);
    }
}
