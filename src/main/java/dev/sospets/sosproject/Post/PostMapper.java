package dev.sospets.sosproject.Post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post map(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setId(postRequestDto.getId());
        post.setTitle(postRequestDto.getTitle());
        post.setText(postRequestDto.getText());
        post.setDate(postRequestDto.getDate());
        post.setCategory(postRequestDto.getCategory());
        post.setImages(postRequestDto.getImages());
        return post;
    }

    public PostRequestDto map(Post post) {
        PostRequestDto postRequestDto = new PostRequestDto();
        postRequestDto.setId(post.getId());
        postRequestDto.setTitle(post.getTitle());
        postRequestDto.setText(post.getText());
        postRequestDto.setDate(post.getDate());
        postRequestDto.setCategory(post.getCategory());
        postRequestDto.setImages(post.getImages());
        return postRequestDto;
    }

}
