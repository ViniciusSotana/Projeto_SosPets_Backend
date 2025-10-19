package dev.sospets.sosproject.Role;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleRequestDto>> getRoles() {
        List<RoleRequestDto> lRoles = roleService.getAllRoles();
        return ResponseEntity.ok(lRoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleRequestDto> getRoleById(@PathVariable Long id) {
        RoleRequestDto role = roleService.getRoleById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RoleRequestDto> addRole(@RequestBody @Valid RoleRequestDto roleDto) {
        RoleRequestDto createdRole = roleService.addRole(roleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleRequestDto> updateRole(@PathVariable Long id, @RequestBody @Valid RoleRequestDto roleDto) {
        RoleRequestDto updatedRole = roleService.updateRole(id, roleDto);
        if (updatedRole != null) {
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        if (roleService.getRoleById(id) != null) {
            roleService.deleteRole(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role não encontrado");
        }
    }
    
}
