package dev.sospets.sosproject.User;

import dev.sospets.sosproject.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String age;
    private String gender;
    private String phone;
    private String cpf;
    private Role role;

}
