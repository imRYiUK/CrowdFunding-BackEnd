package com.imryuik.crowdfunding.dto;

import lombok.Data;

@Data
public class UserGetDTO {
    private Long id;
    private String name;
    private String surname;
    private String phone_number;
    private String username;
    private String email;
}
