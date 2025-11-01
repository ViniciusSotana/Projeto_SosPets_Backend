package dev.sospets.sosproject.SuccessStory;

import dev.sospets.sosproject.Image.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private Date date;
    private String petName;
    private String petBreed;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "successStory_id")
    private List<Image> images;

}
