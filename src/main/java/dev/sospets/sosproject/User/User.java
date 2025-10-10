package dev.sospets.sosproject.User;

import dev.sospets.sosproject.Post.Post;
import dev.sospets.sosproject.PostSocialMedia.PostSocialMedia;
import dev.sospets.sosproject.Role.Role;
import dev.sospets.sosproject.SuccessStory.SuccessStory;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
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
    private List<Post> posts;
    private List<PostSocialMedia> postsSocialMedia;
    private List<SuccessStory> successStories;


}
