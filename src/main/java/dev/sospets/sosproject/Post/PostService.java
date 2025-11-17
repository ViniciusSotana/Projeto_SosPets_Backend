package dev.sospets.sosproject.Post;

import dev.sospets.sosproject.Category.Category;
import dev.sospets.sosproject.Category.CategoryRepository;
import dev.sospets.sosproject.Image.Image;
import dev.sospets.sosproject.config.Cloudinary.CloudinaryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final CategoryRepository categoryRepository;
    private final CloudinaryService cloudinaryService;

    public PostService(PostRepository postRepository, PostMapper postMapper, CategoryRepository categoryRepository, CloudinaryService cloudinaryService) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.categoryRepository = categoryRepository;
        this.cloudinaryService = cloudinaryService;
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

    public PostRequestDto addPost(PostRequestDto postRequestDto, List<MultipartFile> files){
        Post post = postMapper.map(postRequestDto);

        Category category = categoryRepository.findById(postRequestDto.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coleção não encontrada"));
        post.setCategory(category);
        category.getPosts().add(post);

        if (files != null && !files.isEmpty()) {
            List<Image> imagesList = new ArrayList<>();
            for (MultipartFile file : files) {
                String url = cloudinaryService.uploadFile(file);
                Image image = new Image();
                image.setPath(url);
                image.setPost(post);
                imagesList.add(image);
            }
            post.setImages(imagesList);
        }

        Post savedPost = postRepository.save(post);
        return postMapper.map(savedPost);
    }

    public PostRequestDto updatePost(Long id, PostRequestDto postRequestDto, List<MultipartFile> files) {
        Post existentPost = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Post com id " + id + " não encontrado"));

        existentPost.setTitle(postRequestDto.getTitle());
        existentPost.setText(postRequestDto.getText());
        existentPost.setDate(postRequestDto.getDate());

        if (postRequestDto.getCategory() != null && postRequestDto.getCategory().getId() != null) {
            Category category = categoryRepository.findById(postRequestDto.getCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Categoria com id " + postRequestDto.getCategory().getId() + " não encontrada"));
            existentPost.setCategory(category);
        }

        if (files != null && !files.isEmpty()) {
            List<Image> imagesList = new ArrayList<>();
            for (MultipartFile file : files) {
                String url = cloudinaryService.uploadFile(file);
                Image image = new Image();
                image.setPath(url);
                image.setPost(existentPost);
                imagesList.add(image);
            }
            existentPost.setImages(imagesList);
        }

        Post savedPost = postRepository.save(existentPost);
        return postMapper.map(savedPost);
    }

    public void deletePost(Long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            postRepository.delete(post.get());
        }
    }

}
