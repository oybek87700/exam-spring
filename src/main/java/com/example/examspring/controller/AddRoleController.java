package com.example.examspring.controller;

import com.example.examspring.dto.AddRoleDTO;
import com.example.examspring.dto.ApiResponse;
import com.example.examspring.service.AddRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/addrole")
public class AddRoleController {
    @Autowired
    AddRoleService addRoleService;

    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody AddRoleDTO addRoleDTO) {
        ApiResponse add = addRoleService.add(addRoleDTO);
        return ResponseEntity.status(add.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(add);
    }

}
