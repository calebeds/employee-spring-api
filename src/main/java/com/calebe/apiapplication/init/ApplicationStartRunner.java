package com.calebe.apiapplication.init;

import com.calebe.apiapplication.domain.Role;
import com.calebe.apiapplication.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L, "123", "ROLE_USER");
        Role roleAdmin = new Role(1L, "456", "ROLE_ADMIN");
        roleRepository.saveAll(Arrays.asList(roleUser, roleAdmin));
    }
}
