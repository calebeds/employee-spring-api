package com.calebe.apiapplication.repository;

import com.calebe.apiapplication.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String username);
}
