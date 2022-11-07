package com.calebe.apiapplication.service.impl;

import com.calebe.apiapplication.domain.Account;
import com.calebe.apiapplication.repository.AccountRepository;
import com.calebe.apiapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        if(account.getRoles() == null || account.getRoles().isEmpty()) {
            throw new RuntimeException("User has no roles");
        }
        Collection<GrantedAuthority> authorities = account.getRoles().stream().map(role -> {
           return new SimpleGrantedAuthority(role.getName());
        }).collect(Collectors.toList());

        return new User(account.getUsername(), account.getPassword(),
                account.isEnabled(), !account.isExpired(), !account.isCredentialsExpired(), !account.isLocked(),authorities);
    }
}
