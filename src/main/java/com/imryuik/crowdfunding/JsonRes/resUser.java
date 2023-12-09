package com.imryuik.crowdfunding.JsonRes;

import lombok.Data;

@Data
public class resUser {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone_number;
}
