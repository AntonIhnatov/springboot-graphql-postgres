package com.hillel.ua.graphql.repository;

import com.hillel.ua.graphql.entities.Project;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends
        CrudRepository<Project, Integer>, JpaSpecificationExecutor<Project> {
}
