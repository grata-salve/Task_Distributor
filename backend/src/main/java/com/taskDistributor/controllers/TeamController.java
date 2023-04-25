package com.taskDistributor.controllers;

import com.taskDistributor.services.TeamService;
import com.taskDistributor.services.UserTeamsService;
import com.taskDistributor.services.dtos.TeamDto;
import com.taskDistributor.services.dtos.UserDto;
import com.taskDistributor.services.dtos.UserTeamsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

  private final TeamService teamService;
  private final UserTeamsService userTeamsService;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public TeamDto createTeam(@RequestBody TeamDto teamDto) {
    return teamService.createTeam(teamDto);
  }

  @GetMapping("/get/{teamId}")
  @ResponseStatus(HttpStatus.OK)
  public TeamDto getTeam(@PathVariable Long teamId) {
    return teamService.getTeamById(teamId);
  }

  @PutMapping("/update/{teamId}")
  @ResponseStatus(HttpStatus.OK)
  public TeamDto updateTeam(@RequestBody TeamDto teamDto,
      @PathVariable Long teamId) {
    return teamService.updateTeam(teamDto, teamId);
  }

  @DeleteMapping("/delete/{teamId}")
  @ResponseStatus(HttpStatus.OK)
  public TeamDto deleteTeam(@PathVariable Long teamId) {
    return teamService.deleteTeam(teamId);
  }

  @PostMapping("/addMember")
  @ResponseStatus(HttpStatus.CREATED)
  public UserTeamsDto addMember(@RequestBody UserTeamsDto userTeamsDto) {
    return userTeamsService.addMember(userTeamsDto);
  }

  @DeleteMapping("/removeMember/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public UserDto removeMember(@PathVariable Long userId) {
    return userTeamsService.removeMember(userId);
  }

}
