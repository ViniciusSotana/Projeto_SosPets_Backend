package dev.sospets.sosproject.SuccessStory;

import dev.sospets.sosproject.Image.Image;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessStoryDto {

    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String text;
    private Date date;
    @NotBlank
    private String petName;
    @NotBlank
    private String petBreed;
    private List<Image> images;


}
