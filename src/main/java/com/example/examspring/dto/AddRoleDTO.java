package com.example.examspring.dto;

import com.example.examspring.entity.Role;
import com.example.examspring.entity.enums.PermissionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddRoleDTO {
    private String name;
    private String role;
    private List<Role> permissionEnums;

}
