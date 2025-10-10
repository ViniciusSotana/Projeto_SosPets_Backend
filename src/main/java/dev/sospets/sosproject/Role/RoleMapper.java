package dev.sospets.sosproject.Role;

import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role map(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }

    public RoleDto map(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
