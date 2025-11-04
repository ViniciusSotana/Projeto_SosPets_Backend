package dev.sospets.sosproject.Post;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostRequestDto>> getPosts() {
        List<PostRequestDto> lPosts = postService.getAllPosts();
        return ResponseEntity.ok(lPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostRequestDto> getPostById(@PathVariable Long id) {
        PostRequestDto post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PostRequestDto> addPost(@RequestBody @Valid PostRequestDto postRequestDto) {
        PostRequestDto createdPost = postService.addPost(postRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostRequestDto> updatePost(@PathVariable Long id, @RequestBody @Valid PostRequestDto postRequestDto) {
        PostRequestDto updatedPost = postService.updatePost(id, postRequestDto);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        if (postService.getPostById(id) != null) {
            postService.deletePost(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        }
    }
}
