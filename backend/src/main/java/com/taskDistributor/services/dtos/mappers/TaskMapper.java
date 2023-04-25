package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.Task;
import com.taskDistributor.services.dtos.TaskDto;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {

  Task toModel(TaskDto taskDto);

  TaskDto toDto(Task task);

  List<TaskDto> toTaskDtos(List<Task> tasks);

  List<Task> toTaskModels(List<TaskDto> taskDtos);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Task updateTaskFromTaskDto(
      TaskDto taskDto, @MappingTarget Task task);
}
