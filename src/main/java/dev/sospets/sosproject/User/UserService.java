package dev.sospets.sosproject.User;

import dev.sospets.sosproject.Role.Role;
import dev.sospets.sosproject.Role.RoleRepository;
import dev.sospets.sosproject.Role.RoleService;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> lUsers = userRepository.findAll();
        return lUsers.stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toUserResponse).orElse(null);
    }

    public UserResponseDto addUser(UserRequestDto userRequestDto){
        User user = userMapper.map(userRequestDto);
        String defaultRoleName = "ROLE_USER";
        Role defaultRole = roleRepository.findByName(defaultRoleName)
                .orElseThrow(() -> new RuntimeException("Erro: A Role '" + defaultRoleName + "' não foi encontrada no banco."));
        user.setRole(defaultRole);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User existentUser = user.get();
            existentUser.setName(userRequestDto.getName());
            existentUser.setEmail(userRequestDto.getEmail());
            existentUser.setPassword(userRequestDto.getPassword());
            existentUser.setAge(userRequestDto.getAge());
            existentUser.setCpf(userRequestDto.getCpf());
            existentUser.setPhone(userRequestDto.getPhone());

            User savedUser = userRepository.save(existentUser);
            return userMapper.toUserResponse(savedUser);
        }
        return null;
    }

    public boolean deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

}
