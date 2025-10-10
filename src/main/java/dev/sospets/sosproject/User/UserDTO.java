package dev.sospets.sosproject.User;

import dev.sospets.sosproject.Post.Post;
import dev.sospets.sosproject.PostSocialMedia.PostSocialMedia;
import dev.sospets.sosproject.Role.Role;
import dev.sospets.sosproject.SuccessStory.SuccessStory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank
    private String name;
    private String age;
    private String gender;
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    @Email
    private String email;
    @Size(min = 6)
    private String password;
    @Size(max = 11)
    private String phone;
    private Role role;
    private List<Post> posts;
    private List<PostSocialMedia> postsSocialMedia;
    private List<SuccessStory> successStories;



}
