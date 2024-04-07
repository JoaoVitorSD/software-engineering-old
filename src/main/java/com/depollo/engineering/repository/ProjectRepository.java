package com.depollo.engineering.repository;

import com.depollo.engineering.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
}
