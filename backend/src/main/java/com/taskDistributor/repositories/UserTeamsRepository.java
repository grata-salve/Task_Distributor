package com.taskDistributor.repositories;

import com.taskDistributor.models.UserTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTeamsRepository extends JpaRepository<UserTeams, Long> {

  @Modifying
  @Query("DELETE FROM UserTeams ut WHERE ut.user.id = :userId")
  void deleteAllByUserId(@Param("userId") Long userId);
}