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

    @GetMapping("/{tag_name}")
    public List<ProjectDTO> getProjectsByCampaign(@PathVariable String tag_name) {
        System.out.println("NULL");
        return projectService.getProjectsByTag(tag_name);
    }
}
