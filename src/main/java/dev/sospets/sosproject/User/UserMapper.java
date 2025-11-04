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
        user.setCpf(userRequestDto.getCpf());
        user.setRole(userRequestDto.getRole());
        return user;
    }

    public UserResponseDto toUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setGender(user.getGender());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setCpf(user.getCpf());
        userResponseDto.setRole(user.getRole());

        return userResponseDto;
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
        userRequestDto.setCpf(user.getCpf());
        userRequestDto.setRole(user.getRole());
        return userRequestDto;
    }


}
