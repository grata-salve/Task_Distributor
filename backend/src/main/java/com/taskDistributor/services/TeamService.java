package com.taskDistributor.services;

import com.taskDistributor.models.Team;
import com.taskDistributor.repositories.TeamRepository;
import com.taskDistributor.services.dtos.TeamDto;
import com.taskDistributor.services.dtos.mappers.TeamMapper;
import com.taskDistributor.util.exceptions.TeamNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;
  private final TeamMapper teamMapper;

  public TeamDto createTeam(TeamDto teamDto) {
    Team team = teamRepository.save(teamMapper.toModel(teamDto));
    return teamMapper.toDto(team);
  }

  @Transactional(readOnly = true)
  public TeamDto getTeamById(Long teamId) {
    Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    return teamMapper.toDto(team);
  }

  //TODO: transactional over save && ReadOnly
  @Transactional
  public TeamDto updateTeam(TeamDto teamDto, Long teamId) {
    Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    team.setTeamName(teamDto.getTeamName());
    team.setDescription(teamDto.getDescription());
    return teamMapper.toDto(team);
  }

  public TeamDto deleteTeam(Long teamId) {
    Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    teamRepository.deleteById(teamId);
    return teamMapper.toDto(team);
  }
}
