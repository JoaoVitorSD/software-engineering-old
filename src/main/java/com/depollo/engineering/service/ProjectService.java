package com.depollo.engineering.service;

import com.depollo.engineering.dto.ProjectRequest;
import com.depollo.engineering.dto.ProjectResponse;
import com.depollo.engineering.entity.ProjectEntity;
import com.depollo.engineering.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public ProjectResponse create(ProjectRequest request) {

        ProjectEntity entity = new ProjectEntity();
        entity.setName(request.name());
        entity.setValue(request.value());
        entity.setDescription(request.description());
        entity = repository.save(entity);

        ProjectResponse response = new ProjectResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setValue(entity.getValue());
        response.setDescription(entity.getDescription());
        return response;
    }

    public ProjectResponse update(ProjectRequest request) {
        ProjectEntity entity = new ProjectEntity();
        entity.setId(request.id());
        entity.setName(request.name());
        entity.setValue(request.value());
        entity.setDescription(request.description());
        entity = repository.save(entity);

        ProjectResponse response = new ProjectResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setValue(entity.getValue());
        response.setDescription(entity.getDescription());
        return response;
    }

    public void delete(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    public ProjectResponse get(String id) {
        Optional<ProjectEntity> optionalProjectEntity = repository.findById(UUID.fromString(id));
        if (optionalProjectEntity.isEmpty()) {
            return null;
        }
        ProjectEntity entity = optionalProjectEntity.get();
        ProjectResponse response = new ProjectResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setValue(entity.getValue());
        response.setDescription(entity.getDescription());
        return response;
    }
}
