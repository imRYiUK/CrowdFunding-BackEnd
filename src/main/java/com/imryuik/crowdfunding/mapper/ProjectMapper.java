package com.imryuik.crowdfunding.mapper;

import com.imryuik.crowdfunding.dto.ProjectDTO;
import com.imryuik.crowdfunding.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDTO projectToProjectDTO(Project project);
    Project projectDTOToProject(ProjectDTO projectDTO);
}
