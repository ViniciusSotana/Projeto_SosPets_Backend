package dev.sospets.sosproject.Post;

import dev.sospets.sosproject.Category.Category;
import dev.sospets.sosproject.Category.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, PostMapper postMapper, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.categoryRepository = categoryRepository;
    }


    public List<PostRequestDto> getAllPosts() {
        List<Post> lPost = postRepository.findAll();
        return lPost.stream()
                .map(postMapper::map)
                .collect(Collectors.toList());
    }

    public PostRequestDto getPostById(Long id){
        Optional<Post> post = postRepository.findById(id);
        return post.map(postMapper::map).orElse(null);
    }

    public PostRequestDto addPost(PostRequestDto postRequestDto){
        Post post = postMapper.map(postRequestDto);

        Category category = categoryRepository.findById(postRequestDto.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coleção não encontrada"));
        post.setCategory(category);
        category.getPosts().add(post);

        Post savedPost = postRepository.save(post);
        return postMapper.map(savedPost);
    }

    public PostRequestDto updatePost(Long id, PostRequestDto postRequestDto){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            Post existentPost = post.get();

            existentPost.setDate(postRequestDto.getDate());
            existentPost.setText(postRequestDto.getText());
            existentPost.setTitle(postRequestDto.getTitle());

            if (postRequestDto.getCategory() != null) {
                Category category = categoryRepository.findById(postRequestDto.getCategory().getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coleção com id " + postRequestDto.getCategory().getId() + " não encontrada"));
                existentPost.setCategory(category);
                category.getPosts().add(existentPost);
            }

            Post savedPost = postRepository.save(existentPost);
            return postMapper.map(savedPost);
        }
        return null;
    }

    public void deletePost(Long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            postRepository.delete(post.get());
        }
    }

}
