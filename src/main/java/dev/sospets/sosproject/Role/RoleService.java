package dev.sospets.sosproject.Role;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleRequestDto> getAllRoles() {
        List<Role> lRoles = roleRepository.findAll();
        return lRoles.stream()
                .map(roleMapper::map)
                .collect(Collectors.toList());
    }

    public RoleRequestDto getRoleById(Long id){
        Optional<Role> role = roleRepository.findById(id);
        return role.map(roleMapper::map).orElse(null);
    }

    public RoleRequestDto addRole(RoleRequestDto roleRequestDto){
        Role role = roleMapper.map(roleRequestDto);
        Role savedRole = roleRepository.save(role);
        return roleMapper.map(savedRole);
    }

    public RoleRequestDto updateRole(Long id, RoleRequestDto roleRequestDto){
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            Role existentRole = role.get();
            existentRole.setName(roleRequestDto.getName());
            Role savedRole = roleRepository.save(existentRole);
            return roleMapper.map(existentRole);
        }
        return null;
    }

    public void deleteRole(Long id){
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            roleRepository.delete(role.get());
        }
    }

}
