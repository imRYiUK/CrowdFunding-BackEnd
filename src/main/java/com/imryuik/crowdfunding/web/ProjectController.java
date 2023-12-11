package com.imryuik.crowdfunding.web;

import com.imryuik.crowdfunding.dto.ProjectDTO;
import com.imryuik.crowdfunding.services.impl.ProjectServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/project", produces={"application/json", "text/xml"})
@CrossOrigin
public class ProjectController {
    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{category_id}")
    public List<ProjectDTO> getProjectsByCampaign(@PathVariable Long category_id) {
        System.out.println("NULL");
        return projectService.getProjectsByCategory(category_id);
    }
}
