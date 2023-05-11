package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.ActionLog;
import com.taskDistributor.services.dtos.ActionLogDto;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ActionLogMapper {

  ActionLog toModel(ActionLogDto actionLogDto);

  ActionLogDto toDto(ActionLog actionLog);

  List<ActionLog> toActionLogsModels(List<ActionLogDto> actionLogDtos);

  List<ActionLogDto> toActionLogsDtos(List<ActionLog> actionLogs);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ActionLog updateActionLogsFromActionLogsDto(
      ActionLogDto actionLogDto,
      @MappingTarget ActionLog actionLog);
}
