package com.taskDistributor.services;

import com.taskDistributor.models.User;
import com.taskDistributor.models.UserTeams;
import com.taskDistributor.repositories.UserRepository;
import com.taskDistributor.repositories.UserTeamsRepository;
import com.taskDistributor.services.dtos.UserDto;
import com.taskDistributor.services.dtos.UserTeamsDto;
import com.taskDistributor.services.dtos.mappers.UserMapper;
import com.taskDistributor.services.dtos.mappers.UserTeamsMapper;
import com.taskDistributor.util.exceptions.UserNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTeamsService {

  private final UserTeamsRepository userTeamsRepository;
  private final UserRepository userRepository;
  private final UserTeamsMapper userTeamsMapper;
  private final UserMapper userMapper;

  public UserTeamsDto addMember(UserTeamsDto userTeamsDto) {
    UserTeams userTeams = userTeamsMapper.toModel(userTeamsDto);
    return userTeamsMapper.toDto(userTeamsRepository.save(userTeams));
  }

  @Transactional
  public UserDto removeMember(Long userId) {
    userTeamsRepository.deleteAllByUserId(userId);
    User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    return userMapper.toDto(user);
  }
}
