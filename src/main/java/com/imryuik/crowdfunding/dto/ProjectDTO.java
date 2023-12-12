package com.imryuik.crowdfunding.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String fundType;
    private Double fundTarget;
    private Double actualFund;
    private Date fundStart;
    private Date fundEnd;
    private Date createdAt;
    private UserGDTO creator;
    private List<TagDTO> tags = new ArrayList<>();
    private CategoryDTO category;

    public ProjectDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFundType() {
        return this.fundType;
    }

    public Double getFundTarget() {
        return this.fundTarget;
    }

    public Date getFundStart() {
        return this.fundStart;
    }

    public Date getFundEnd() {
        return this.fundEnd;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public UserGDTO getCreator() {
        return this.creator;
    }

    public List<TagDTO> getTags() {
        return this.tags;
    }

    public CategoryDTO getCategory() {
        return this.category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public void setFundTarget(Double fundTarget) {
        this.fundTarget = fundTarget;
    }

    public void setFundStart(Date fundStart) {
        this.fundStart = fundStart;
    }

    public void setFundEnd(Date fundEnd) {
        this.fundEnd = fundEnd;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreator(UserGDTO creator) {
        this.creator = creator;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Double getActualFund() {
        return actualFund;
    }

    public void setActualFund(Double actualFund) {
        this.actualFund = actualFund;
    }
}
