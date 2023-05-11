package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.UserTeam;
import com.taskDistributor.services.dtos.UserTeamDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserTeamMapper {

  UserTeam toModel(UserTeamDto userTeamDto);

  UserTeamDto toDto(UserTeam userTeam);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  UserTeam updateUserTeamsFromUserTeamsDto(
      UserTeamDto userTeamDto, @MappingTarget UserTeam userTeam);
}
