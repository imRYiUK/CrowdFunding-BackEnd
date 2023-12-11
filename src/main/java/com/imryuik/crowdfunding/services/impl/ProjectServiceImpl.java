package com.imryuik.crowdfunding.services.impl;

import com.imryuik.crowdfunding.data.ProjectRepository;
import com.imryuik.crowdfunding.dto.ProjectDTO;
import com.imryuik.crowdfunding.entity.Project;
import com.imryuik.crowdfunding.mapper.MapStructMapper;
import com.imryuik.crowdfunding.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final MapStructMapper mapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, MapStructMapper mapper) {
        this.projectRepository = projectRepository;
        this.mapper = mapper;
    }
    @Override
    public List<ProjectDTO> getProjectsByCategory(Long categoryDto_id) {
        List<Project> projects =  projectRepository.findByCategory_Id(categoryDto_id);

        return projects.stream()
                .map(mapper::projectToProjectDTO)
                .collect(Collectors.toList());
    }
}
