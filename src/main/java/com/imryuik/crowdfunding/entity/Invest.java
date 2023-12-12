package com.imryuik.crowdfunding.entity;

import jakarta.persistence.*;

@Entity
public class Invest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User backer;

    @ManyToOne
    private Perk perk;

    public Invest() {
    }

    public Long getId() {
        return this.id;
    }

    public Project getProject() {
        return this.project;
    }

    public User getBacker() {
        return this.backer;
    }

    public Perk getPerk() {
        return this.perk;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setBacker(User backer) {
        this.backer = backer;
    }

    public void setPerk(Perk perk) {
        this.perk = perk;
    }

}
