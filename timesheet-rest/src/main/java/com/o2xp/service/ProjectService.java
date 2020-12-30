package com.o2xp.service;

import com.o2xp.model.Project;
import com.o2xp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService implements TimesheetService<Project>{

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return this.projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public Project update(Long id, Project o) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.projectRepository.deleteById(id);
    }
}
