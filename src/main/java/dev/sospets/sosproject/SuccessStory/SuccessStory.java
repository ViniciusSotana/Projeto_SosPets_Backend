package dev.sospets.sosproject.SuccessStory;

import dev.sospets.sosproject.Image.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
public class SuccessStory {

    @Id
    private Long id;
    private String title;
    private String text;
    private Date date;
    private String petName;
    private String petBreed;
    private List<Image> images;

}
