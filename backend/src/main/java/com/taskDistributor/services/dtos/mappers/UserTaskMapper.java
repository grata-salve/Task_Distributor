package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.UserTask;
import com.taskDistributor.services.dtos.UserTaskDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserTaskMapper {

  UserTask toModel(UserTaskDto userTaskDto);

  UserTaskDto toDto(UserTask userTask);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  UserTask updateUserTasksFromUserTasksDto(
      UserTaskDto userTaskDto,
      @MappingTarget UserTask userTask);
}
