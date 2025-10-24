package dev.sospets.sosproject.Post;

import dev.sospets.sosproject.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {this.postService = postService;}

}
