package com.hillel.ua.graphql.dto;

import com.hillel.ua.graphql.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    private String name;
    private Integer employeeId;
}
