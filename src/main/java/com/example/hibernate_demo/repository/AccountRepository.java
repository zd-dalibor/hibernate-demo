package com.example.hibernate_demo.repository;

import com.example.hibernate_demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    //@Query("SELECT a FROM Account a JOIN FETCH a.user u WHERE a.user.username = :username")
    @Query("SELECT a FROM Account a WHERE a.user.username = :username")
    Optional<Account> findByUsername(
            @Param("username") String username);
}
