package com.hillel.ua.graphql.controller;


import com.hillel.ua.graphql.dto.DepartmentRequestDto;
import com.hillel.ua.graphql.dto.ProjectRequestDto;
import com.hillel.ua.graphql.entities.Department;
import com.hillel.ua.graphql.entities.Employee;
import com.hillel.ua.graphql.entities.Organization;
import com.hillel.ua.graphql.entities.Project;
import com.hillel.ua.graphql.repository.EmployeeRepository;
import com.hillel.ua.graphql.repository.ProjectRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class ProjectController {

    EmployeeRepository employeeRepository;
    ProjectRepository projectRepository;

    ProjectController(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @QueryMapping
    public Iterable<Project> projects() {
        return projectRepository.findAll();
    }

    @MutationMapping
    public Project newProject(@Argument ProjectRequestDto project) {
        Employee employee = employeeRepository.findById(project.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        return projectRepository.save(new Project(null, project.getName(), employee));
    }



}
