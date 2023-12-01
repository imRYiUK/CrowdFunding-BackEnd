package com.imryuik.crowdfunding.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
//@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private FundType fundType;
    private Double fundTarget;
    private Date fundStart;
    private Date fundEnd;

    @ElementCollection
    @CollectionTable(name = "tags_list", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tags")
    private List<String> tags = new ArrayList<>();
    private Date createdAt;

    @ManyToOne
    private Creator creator;

    public void addTags(String tag) {
        this.tags.add(tag);
    }
}
