package com.imryuik.crowdfunding.services;

import com.imryuik.crowdfunding.dto.CategoryDTO;
import com.imryuik.crowdfunding.dto.ProjectDTO;

import java.util.List;


public interface ProjectService {

    List<ProjectDTO> getProjectsByTag(String tagDto_name);
}
