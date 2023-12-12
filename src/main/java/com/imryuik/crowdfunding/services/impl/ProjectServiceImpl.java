package com.imryuik.crowdfunding.services.impl;

import com.imryuik.crowdfunding.data.ProjectRepository;
import com.imryuik.crowdfunding.data.TagRepository;
import com.imryuik.crowdfunding.dto.ProjectDTO;
import com.imryuik.crowdfunding.entity.Project;
import com.imryuik.crowdfunding.entity.Tag;
import com.imryuik.crowdfunding.mapper.ProjectMapper;
import com.imryuik.crowdfunding.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;
    private final ProjectMapper proj_mapper = ProjectMapper.INSTANCE;

    public ProjectServiceImpl(ProjectRepository projectRepository, TagRepository tagRepository) {
        this.projectRepository = projectRepository;
        this.tagRepository = tagRepository;
    }
    @Override
    public List<ProjectDTO> getProjectsByTag(String tagDto_name) {
        Tag tag = tagRepository.findByIdentifier(tagDto_name);
        System.out.println(tag.getName());
        List<Project> projects = new ArrayList<>(projectRepository.findAll());
//                projectRepository.findtags(tag.getId());
        System.out.println(projects.get(0).getActualFund());
        return projects.stream()
                .map(proj_mapper::projectToProjectDTO)
                .collect(Collectors.toList());
    }

    public List<ProjectDTO> getProjects() {
        List<Project> projects = (List<Project>) projectRepository.findAll();

        return projects.stream()
                .map(proj_mapper::projectToProjectDTO)
                .collect(Collectors.toList());
    }
}
