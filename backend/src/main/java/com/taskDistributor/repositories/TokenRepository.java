package com.taskDistributor.repositories;

import com.taskDistributor.models.auth.Token;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

  @Query("select t from Token t inner join User u on t.user.id = u.id "
      + "where u.id = :id and t.revoked = false")
  List<Token> findAllValidTokenByUser(Long id);

  Optional<Token> findByToken(String token);
}
