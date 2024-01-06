package com.imryuik.crowdfunding.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
//@RequiredArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private FundType fundType;
    private Double actualFund;
    private Double fundTarget;
    private Date fundStart;
    private Date fundEnd;
    private Date createdAt;
    @ManyToOne
    private User creator;

    private Boolean isActive;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "PROJECT_TAG",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags = new ArrayList<>();

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Project() {
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
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

    public FundType getFundType() {
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

    public User getCreator() {
        return this.creator;
    }

    public Category getCategory() {
        return this.category;
    }

    public List<Tag> getTags() {
        return this.tags;
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

    public void setFundType(FundType fundType) {
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

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Double getActualFund() {
        return actualFund;
    }

    public void setActualFund(Double actualFund) {
        this.actualFund = actualFund;
    }
}
