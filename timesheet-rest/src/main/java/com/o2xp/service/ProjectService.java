package com.o2xp.service;

import com.o2xp.model.Project;
import com.o2xp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public Project update(Long id, Project newData) {
        Optional<Project> optionalProject = this.projectRepository.findById(id);

        return optionalProject
                .map(project -> {
                    if (newData.hasName())
                        project.setName(newData.getName());
                    if (newData.hasDescription())
                        project.setDescription(newData.getDescription());
                    if (newData.hasContract())
                        project.setContract(newData.getContract());
                    if (newData.hasStartingDt())
                        project.setStartingDt(newData.getStartingDt());
                    if (newData.hasEndingDt())
                        project.setEndingDt(newData.getEndingDt());
                    project.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                    return this.projectRepository.save(project);
                })
                .orElse( null);
    }

    @Override
    public void delete(Long id) {
        this.projectRepository.deleteById(id);
    }
}
