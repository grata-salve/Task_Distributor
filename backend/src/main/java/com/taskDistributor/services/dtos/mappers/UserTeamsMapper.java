package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.UserTeams;
import com.taskDistributor.services.dtos.UserTeamsDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserTeamsMapper {

  UserTeams toModel(UserTeamsDto userTeamsDto);

  UserTeamsDto toDto(UserTeams userTeams);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  UserTeams updateUserTeamsFromUserTeamsDto(
      UserTeamsDto userTeamsDto, @MappingTarget UserTeams userTeams);
}
