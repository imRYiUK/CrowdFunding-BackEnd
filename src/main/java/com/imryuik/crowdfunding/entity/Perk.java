package com.imryuik.crowdfunding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Perk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "rewards_list", joinColumns = @JoinColumn(name = "perk_id"))
    @Column(name = "reward")
    private List<String> rewards = new ArrayList<>();
    private Date estimatedDelivery;

    public void addReward(String reward) {
        this.rewards.add(reward);
    }
}
