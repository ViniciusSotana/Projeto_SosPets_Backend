package dev.sospets.sosproject.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setGender(userDTO.getGender());
        user.setAge(userDTO.getAge());
        user.setRole(userDTO.getRole());
        user.setPosts(userDTO.getPosts());
        user.setPostsSocialMedia(userDTO.getPostsSocialMedia());
        user.setSuccessStories(userDTO.getSuccessStories());
        return user;
    }

    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setGender(user.getGender());
        userDTO.setAge(user.getAge());
        userDTO.setRole(user.getRole());
        userDTO.setPosts(user.getPosts());
        userDTO.setPostsSocialMedia(user.getPostsSocialMedia());
        userDTO.setSuccessStories(user.getSuccessStories());
        return userDTO;
    }


}
