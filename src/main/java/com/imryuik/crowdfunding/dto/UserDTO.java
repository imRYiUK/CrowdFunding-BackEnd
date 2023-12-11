package com.imryuik.crowdfunding.dto;

import com.imryuik.crowdfunding.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {
    private Long id;

    private String name;
    private String surname;
    private String phone_number;

    private String username;

    private String email;

    private String password;

}
