package com.calebe.api.service;

import com.calebe.api.domain.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
