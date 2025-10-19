package dev.sospets.sosproject.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sospets.sosproject.Post.Post;
import dev.sospets.sosproject.PostSocialMedia.PostSocialMedia;
import dev.sospets.sosproject.Role.Role;
import dev.sospets.sosproject.SuccessStory.SuccessStory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    private String gender;
    private String cpf;
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
    private List<PostSocialMedia> postsSocialMedia;
    @OneToMany
    @JsonIgnore
    private List<SuccessStory> successStories;


}
