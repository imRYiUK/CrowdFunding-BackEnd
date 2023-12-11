package com.imryuik.crowdfunding.dto;
import lombok.Data;

@Data
public class InvestDTO {
    private Long id;
    private ProjectDTO project;
    private UserDTO backer;
    private PerkDTO perk;
}
