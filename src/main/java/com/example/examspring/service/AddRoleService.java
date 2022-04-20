package com.example.examspring.service;

import com.example.examspring.dto.AddRoleDTO;
import com.example.examspring.dto.ApiResponse;
import com.example.examspring.entity.AddRole;
import com.example.examspring.repository.AddRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AddRoleService {
    @Autowired
    AddRoleRepository addRoleRepository;

    public ApiResponse add(AddRoleDTO addRoleDTO) {
        AddRole addRole = new AddRole();
        addRole.setName(addRoleDTO.getName());
        addRole.setRole(addRoleDTO.getRole());
        addRole.setPermissionEnums(addRoleDTO.getPermissionEnums());
        AddRole save = addRoleRepository.save(addRole);
        return new ApiResponse("ADDED", true, save);
    }
}
