package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.Team;
import com.taskDistributor.services.dtos.TeamDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TeamMapper {

  Team toModel(TeamDto teamDto);

  TeamDto toDto(Team team);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Team updateTeamFromTeamDto(
      TeamDto teamDto, @MappingTarget Team team);
}
