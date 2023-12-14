package com.pracone.controller;

import com.pracone.dto.ProjectRequestDTO;
import com.pracone.entities.Project;
import com.pracone.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/addProject")
    public ResponseEntity<?> addProject(@RequestBody @Valid ProjectRequestDTO request) {

        System.out.println(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addProject(request));
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(projectService.deleteProject(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getProjectsByName(@PathVariable String name) {

        List<Project> projectList = projectService.getProjectByName(name);

        if (projectList.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("NO DATA FOUND!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(projectList);
    }
}
