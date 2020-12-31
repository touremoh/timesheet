package com.o2xp.mapper;

import com.o2xp.dto.ProjectDTO;
import com.o2xp.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDTO toDTO(Project project);
    Project toModel(ProjectDTO projectDTO);
}
