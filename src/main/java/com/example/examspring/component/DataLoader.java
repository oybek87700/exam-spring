package com.example.examspring.component;

import com.example.examspring.entity.RoleEnum;
import com.example.examspring.entity.User;
import com.example.examspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    final PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setRoleEnum(RoleEnum.USER);
            userRepository.save(user);

            User admin = new User();
            admin.setRoleEnum(RoleEnum.ADMIN);
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(admin);

            User admin2 = new User();
            admin2.setRoleEnum(RoleEnum.ADMIN2);
            admin2.setUsername("admin2");
            admin2.setPassword(passwordEncoder.encode("admin2"));
            userRepository.save(admin2);
        }


    }
}
