package com.imryuik.crowdfunding.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Perk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "rewards_list", joinColumns = @JoinColumn(name = "perk_id"))
    @Column(name = "reward")
    private List<String> rewards = new ArrayList<>();

    private Date estimatedDelivery;

    @ManyToOne
    private Project project;

    public Perk() {
    }

    public void addReward(String reward) {
        this.rewards.add(reward);
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

    public Project getProject() {
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

    public void setProject(Project project) {
        this.project = project;
    }

}
