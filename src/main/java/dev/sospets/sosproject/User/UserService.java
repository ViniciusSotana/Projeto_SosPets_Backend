package dev.sospets.sosproject.User;

import dev.sospets.sosproject.Role.Role;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserRequestDto> getAllUsers() {
        List<User> lUsers = userRepository.findAll();
        return lUsers.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserRequestDto getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::map).orElse(null);
    }

    public UserRequestDto addUser(UserRequestDto userRequestDto){
        User user = userMapper.map(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.map(savedUser);
    }

    public UserRequestDto updateUser(Long id, UserRequestDto userRequestDto){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User existentUser = user.get();
            existentUser.setName(userRequestDto.getName());
            existentUser.setEmail(userRequestDto.getEmail());
            existentUser.setPassword(userRequestDto.getPassword());
            existentUser.setAge(userRequestDto.getAge());
            existentUser.setRole(userRequestDto.getRole());
            existentUser.setCpf(userRequestDto.getCpf());
            existentUser.setPhone(userRequestDto.getPhone());

            User savedUser = userRepository.save(existentUser);
            return userMapper.map(savedUser);
        }
        return null;
    }

    public void deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
        }
    }



}
