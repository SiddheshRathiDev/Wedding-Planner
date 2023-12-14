package com.pracone.repo;

import com.pracone.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> getProjectsByName(String name);
}
