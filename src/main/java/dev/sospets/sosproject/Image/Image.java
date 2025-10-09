package dev.sospets.sosproject.Image;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Image {

    @Id
    private Long id;
    private String path;

}
