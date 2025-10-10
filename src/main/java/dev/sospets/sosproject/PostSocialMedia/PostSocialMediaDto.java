package dev.sospets.sosproject.PostSocialMedia;

import dev.sospets.sosproject.Image.Image;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSocialMediaDto {

    private Long id;
    @NotBlank
    private List<EnumPlatform> platforms;
    @NotBlank
    private String text;
    @NotBlank
    private boolean isSchedule;
    private boolean scheduleDate;
    private List<Image> images;

}
