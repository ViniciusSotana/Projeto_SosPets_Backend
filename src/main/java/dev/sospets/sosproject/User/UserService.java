package dev.sospets.sosproject.User;

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

    public List<UserDTO> getAllUsers() {
        List<User> lUsers = userRepository.findAll();
        return lUsers.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::map).orElse(null);
    }

    public UserDTO addUser(UserDTO userDTO){
        User user = userMapper.map(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.map(savedUser);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User existentUser = user.get();
            existentUser.setName(userDTO.getName());
            existentUser.setEmail(userDTO.getEmail());
            existentUser.setPassword(userDTO.getPassword());

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
