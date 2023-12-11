package com.imryuik.crowdfunding.dto;

import com.imryuik.crowdfunding.entity.Category;
import com.imryuik.crowdfunding.entity.FundType;
import com.imryuik.crowdfunding.entity.Tag;
import com.imryuik.crowdfunding.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String fundType;
    private Double fundTarget;
    private Date fundStart;
    private Date fundEnd;
    private Date createdAt;
    private UserDTO creator;
    private List<TagDTO> tags = new ArrayList<>();
    private CategoryDTO category;
}
