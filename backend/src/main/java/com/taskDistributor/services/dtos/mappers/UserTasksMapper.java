package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.UserTasks;
import com.taskDistributor.services.dtos.UserTasksDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserTasksMapper {

  UserTasks toModel(UserTasksDto userTasksDto);

  UserTasksDto toDto(UserTasks userTasks);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  UserTasks updateUserTasksFromUserTasksDto(
      UserTasksDto userTasksDto,
      @MappingTarget UserTasks userTasks);
}
