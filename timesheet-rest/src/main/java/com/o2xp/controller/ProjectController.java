package com.o2xp.controller;

import com.o2xp.dto.ProjectDTO;
import com.o2xp.mapper.ProjectMapper;
import com.o2xp.model.Customer;
import com.o2xp.model.Project;
import com.o2xp.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    @Operation(summary = "Project creation service", description = "Creating new project")
    @ApiResponse(
            responseCode = "201",
            description = "Returns the project that was successfully created",
            content = { @Content(schema = @Schema(anyOf = { Project.class })) }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> addProject(@RequestBody ProjectDTO projectDTO) {
        Project savedProject = this.service.save(ProjectMapper.INSTANCE.toModel(projectDTO));
        return new ResponseEntity<>(ProjectMapper.INSTANCE.toDTO(savedProject), HttpStatus.CREATED);
    }
    @Operation(summary = "Project finding service", description = "Finding all projects")
    @ApiResponse(
            responseCode = "200",
            description = "Returns all projects",
            content = { @Content(schema = @Schema(anyOf = { Project.class })) }
    )
    @ApiResponse(
            responseCode = "404",
            description = "No project was found",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectDTO>> findAllProjects() {
        List<Project> projects = this.service.findAll();
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        projects.forEach(project -> projectDTOS.add(ProjectMapper.INSTANCE.toDTO(project)));
        return new ResponseEntity<>(projectDTOS, HttpStatus.OK);
    }

}
