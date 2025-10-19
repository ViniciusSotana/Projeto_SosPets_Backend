package dev.sospets.sosproject.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserRequestDto userRequestDto) {
        User user = new User();
        user.setId(userRequestDto.getId());
        user.setName(userRequestDto.getName());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        user.setPhone(userRequestDto.getPhone());
        user.setGender(userRequestDto.getGender());
        user.setAge(userRequestDto.getAge());
        user.setRole(userRequestDto.getRole());
        user.setPosts(userRequestDto.getPosts());
        user.setPostsSocialMedia(userRequestDto.getPostsSocialMedia());
        user.setSuccessStories(userRequestDto.getSuccessStories());
        return user;
    }

    public UserRequestDto map(User user) {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setId(user.getId());
        userRequestDto.setName(user.getName());
        userRequestDto.setPassword(user.getPassword());
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setPhone(user.getPhone());
        userRequestDto.setGender(user.getGender());
        userRequestDto.setAge(user.getAge());
        userRequestDto.setRole(user.getRole());
        userRequestDto.setPosts(user.getPosts());
        userRequestDto.setPostsSocialMedia(user.getPostsSocialMedia());
        userRequestDto.setSuccessStories(user.getSuccessStories());
        return userRequestDto;
    }


}
