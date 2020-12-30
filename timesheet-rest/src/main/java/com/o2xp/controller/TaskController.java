package com.o2xp.controller;

import com.o2xp.model.Task;
import com.o2xp.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @Operation(summary = "Task finding service", description = "Finding all tasks")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the list of all tasks",
            content = { @Content(schema = @Schema(anyOf = { Task.class })) }
    )
    @ApiResponse(
            responseCode = "404",
            description = "No task was found",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> findAll() {
       List<Task> tasks = this.service.findAll();

        if (tasks.size() > 0) {
            log.info("Tasks found ["+tasks.size()+"]");
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
        log.warn("No task was found");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Task finding service", description = "Finding a task by its ID")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the task that was found",
            content = { @Content(schema = @Schema(anyOf = { Task.class })) }
    )
    @ApiResponse(
            responseCode = "404",
            description = "No task was found by its ID",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Optional<Task> task = this.service.findById(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        }
        log.warn("No task with ID ["+id+"]was found");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Task creation service", description = "Creating a new task")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the task that was created",
            content = { @Content(schema = @Schema(anyOf = { Task.class })) }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
        return new ResponseEntity<>(this.service.save(task), HttpStatus.CREATED);
    }

}
