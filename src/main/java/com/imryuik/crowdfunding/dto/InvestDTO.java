package com.imryuik.crowdfunding.dto;

public class InvestDTO {
    private Long id;
    private ProjectDTO project;
    private UserDTO backer;
    private PerkDTO perk;

    public InvestDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public ProjectDTO getProject() {
        return this.project;
    }

    public UserDTO getBacker() {
        return this.backer;
    }

    public PerkDTO getPerk() {
        return this.perk;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public void setBacker(UserDTO backer) {
        this.backer = backer;
    }

    public void setPerk(PerkDTO perk) {
        this.perk = perk;
    }
}
