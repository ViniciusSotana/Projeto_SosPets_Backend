package dev.sospets.sosproject.Post;

import dev.sospets.sosproject.Category.Category;
import dev.sospets.sosproject.Image.Image;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    @ManyToOne
    private Category category;
    private Date date;
    @OneToMany
    private List<Image> images;


}
