package com.imryuik.crowdfunding.dto;

import com.imryuik.crowdfunding.entity.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class PerkDTO {
    private Long id;
    private List<String> rewards = new ArrayList<>();
    private Date estimatedDelivery;
    private ProjectDTO project;
}
