package com.manu.account.repository;

import com.manu.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUserId(String userId);
    Optional<Account> findByUserId(String userId);
    List<Account> findAllByUserId(String userId);
}
