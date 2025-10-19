package dev.sospets.sosproject.Role;

import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role map(RoleRequestDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }

    public RoleRequestDto map(Role role) {
        RoleRequestDto roleDto = new RoleRequestDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
