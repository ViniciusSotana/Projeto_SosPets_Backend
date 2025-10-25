package dev.sospets.sosproject.Post;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        List<Post> lPosts = postRepository.findAll();
        return lPosts.stream().toList();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post updatedPost = optionalPost.get();
            updatedPost.setTitle(post.getTitle());
            updatedPost.setCategory(post.getCategory());
            updatedPost.setDate(post.getDate());
            updatedPost.setText(post.getText());
            updatedPost.setImages(post.getImages());

            Post postUpdated = postRepository.save(updatedPost);
            return postUpdated;
        }
        return null;
    }

    public boolean deletePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
