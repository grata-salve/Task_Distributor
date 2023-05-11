package com.taskDistributor.services;

import com.taskDistributor.models.User;
import com.taskDistributor.models.UserTeam;
import com.taskDistributor.repositories.UserRepository;
import com.taskDistributor.repositories.UserTeamRepository;
import com.taskDistributor.services.dtos.UserDto;
import com.taskDistributor.services.dtos.UserTeamDto;
import com.taskDistributor.services.dtos.mappers.UserMapper;
import com.taskDistributor.services.dtos.mappers.UserTeamMapper;
import com.taskDistributor.util.exceptions.UserNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTeamService {

  private final UserTeamRepository userTeamRepository;
  private final UserRepository userRepository;
  private final UserTeamMapper userTeamMapper;
  private final UserMapper userMapper;

  public UserTeamDto addMember(UserTeamDto userTeamDto) {
    UserTeam userTeam = userTeamMapper.toModel(userTeamDto);
    return userTeamMapper.toDto(userTeamRepository.save(userTeam));
  }

  @Transactional
  public UserDto removeMember(Long userId) {
    userTeamRepository.deleteAllByUserId(userId);
    User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    return userMapper.toDto(user);
  }
}
