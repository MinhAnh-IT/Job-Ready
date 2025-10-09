package com.Job_Ready.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Job_Ready.auth.entities.Account;

public interface AccountRepository extends JpaRepository<Account, java.util.UUID> {
    Optional<Account> findByUsername(String username);
    Optional<Account> findByEmail(String email);
}
