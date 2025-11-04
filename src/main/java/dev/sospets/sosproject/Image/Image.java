package dev.sospets.sosproject.Image;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sospets.sosproject.Post.Post;
import dev.sospets.sosproject.SuccessStory.SuccessStory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;
    @ManyToOne
    @JoinColumn(name = "successStory_id")
    @JsonIgnore
    private SuccessStory successStory;

}
