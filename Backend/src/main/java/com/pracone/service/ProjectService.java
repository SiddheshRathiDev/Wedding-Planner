package com.pracone.service;

import com.pracone.dto.ProjectRequestDTO;
import com.pracone.entities.Project;
import com.pracone.repo.ProjectRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String addProject(ProjectRequestDTO request) {

        Project project = modelMapper.map(request, Project.class);

        project.setMinHeadCount(10);

        projectRepo.save(project);

        return "Project added to database!";
    }

    public String deleteProject(Long id) {

        projectRepo.deleteById(id);

        return "Project deleted from database!";
    }

    public List<Project> getProjectByName(String name) {

        return projectRepo.getProjectsByName(name);
    }

}
