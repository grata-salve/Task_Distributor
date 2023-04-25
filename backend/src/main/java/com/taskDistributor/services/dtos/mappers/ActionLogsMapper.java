package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.ActionLogs;
import com.taskDistributor.models.Task;
import com.taskDistributor.services.dtos.ActionLogsDto;
import com.taskDistributor.services.dtos.TaskDto;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ActionLogsMapper {

  ActionLogs toModel(ActionLogsDto actionLogsDto);

  ActionLogsDto toDto(ActionLogs actionLogs);

  List<ActionLogs> toActionLogsModels(List<ActionLogsDto> actionLogsDtos);

  List<ActionLogsDto> toActionLogsDtos(List<ActionLogs> actionLogs);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ActionLogs updateActionLogsFromActionLogsDto(
      ActionLogsDto actionLogsDto,
      @MappingTarget ActionLogs actionLogs);
}
