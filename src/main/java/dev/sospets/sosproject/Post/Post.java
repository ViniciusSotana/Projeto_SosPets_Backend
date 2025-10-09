package dev.sospets.sosproject.Post;

import dev.sospets.sosproject.Category.Category;
import dev.sospets.sosproject.Image.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    private Long id;
    private String title;
    private String text;
    @ManyToOne
    private Category category;
    private Date date;
    private List<Image> images;


}
