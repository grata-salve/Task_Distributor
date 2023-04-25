package com.taskDistributor.services.dtos.mappers;

import com.taskDistributor.models.User;
import com.taskDistributor.services.dtos.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

  User toModel(UserDto userDto);

  UserDto toDto(User user);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  User updateUserFromUserDto(
      UserDto userDto, @MappingTarget User user);
}
