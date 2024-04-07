package com.depollo.engineering.controller;

import com.depollo.engineering.dto.ProjectRequest;
import com.depollo.engineering.dto.ProjectResponse;
import com.depollo.engineering.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/project")
@RestController
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectRequest request){
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ProjectResponse> update(@RequestBody ProjectRequest request){
        return new ResponseEntity<>(service.update(request), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProjectResponse> get(@PathVariable String id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }


}
