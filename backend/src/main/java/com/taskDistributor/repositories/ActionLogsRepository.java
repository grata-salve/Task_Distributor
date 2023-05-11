package com.taskDistributor.repositories;

import com.taskDistributor.models.ActionLog;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLogsRepository extends JpaRepository<ActionLog, Long> {

  @Query("SELECT al FROM ActionLog al WHERE al.user.id = :userId")
  Optional<List<ActionLog>> findAllByUserId(@Param("userId") Long userId);

  @Query("SELECT al FROM ActionLog al WHERE al.task.id = :taskId")
  Optional<List<ActionLog>> findAllByTaskId(@Param("taskId") Long taskId);
}