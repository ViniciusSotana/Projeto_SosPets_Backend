package dev.sospets.sosproject.config;

import dev.sospets.sosproject.Role.Role;
import dev.sospets.sosproject.Role.RoleRepository;
import dev.sospets.sosproject.Role.RoleService;
import dev.sospets.sosproject.User.User;
import dev.sospets.sosproject.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final RoleService roleService;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, RoleService roleService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if(userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setName("John Doe");
            user.setGender("Female");
            user.setEmail("Teste@teste.com");
            user.setPassword("123456");
            Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("ROLE_ADMIN não encontrada"));
            user.setRole(adminRole);
            userRepository.save(user);
        }
    }
}