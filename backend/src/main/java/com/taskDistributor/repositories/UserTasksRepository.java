package com.taskDistributor.repositories;

import com.taskDistributor.models.Task;
import com.taskDistributor.models.UserTasks;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTasksRepository extends JpaRepository<UserTasks, Long> {

  @Query("SELECT ut.task FROM UserTasks ut WHERE ut.user.id = :userId")
  Optional<List<Task>> findAllTasksByUserId(@Param("userId") Long userId);

  @Query("SELECT ut.task FROM UserTasks ut " +
      "INNER JOIN UserTeams utm ON ut.user = utm.user " +
      "WHERE utm.team.id = :teamId")
  Optional<List<Task>> findAllTasksByTeamId(@Param("teamId") Long teamId);
}
