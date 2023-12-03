package com.imryuik.crowdfunding.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date createdAt;

    @ManyToOne
    private User creator;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinColumn(referencedColumnName = "id")
    private List<Tag> tags = new ArrayList<>();

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
}
