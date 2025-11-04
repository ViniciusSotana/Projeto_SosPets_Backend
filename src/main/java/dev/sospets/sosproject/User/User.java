package dev.sospets.sosproject.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sospets.sosproject.Post.Post;
import dev.sospets.sosproject.Role.Role;
import dev.sospets.sosproject.SuccessStory.SuccessStory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    private String gender;
    private String cpf;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    @ManyToOne
    private Role role;
    @OneToMany
    @JsonIgnore
    private List<Post> posts;
    @OneToMany
    @JsonIgnore
    private List<SuccessStory> successStories;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == null) {
            return List.of();
        }
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Conta não expirada
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Conta não bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credenciais (senha) não expiradas
    }

    @Override
    public boolean isEnabled() {
        return true; // Conta habilitada
    }


}
