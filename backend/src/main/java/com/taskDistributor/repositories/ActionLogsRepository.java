package com.taskDistributor.repositories;

import com.taskDistributor.models.ActionLogs;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLogsRepository extends JpaRepository<ActionLogs, Long> {

  @Query("SELECT al FROM ActionLogs al WHERE al.user.id = :userId")
  Optional<List<ActionLogs>> findAllByUserId(@Param("userId") Long userId);

  @Query("SELECT al FROM ActionLogs al WHERE al.task.id = :taskId")
  Optional<List<ActionLogs>> findAllByTaskId(@Param("taskId") Long taskId);
}