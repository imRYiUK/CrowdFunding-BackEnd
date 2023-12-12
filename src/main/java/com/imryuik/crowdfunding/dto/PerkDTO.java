package com.imryuik.crowdfunding.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PerkDTO {
    private Long id;
    private List<String> rewards = new ArrayList<>();
    private Date estimatedDelivery;
    private ProjectDTO project;

    public PerkDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public List<String> getRewards() {
        return this.rewards;
    }

    public Date getEstimatedDelivery() {
        return this.estimatedDelivery;
    }

    public ProjectDTO getProject() {
        return this.project;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }
}
