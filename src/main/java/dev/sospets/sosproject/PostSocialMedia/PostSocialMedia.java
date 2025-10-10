package dev.sospets.sosproject.PostSocialMedia;

import dev.sospets.sosproject.Image.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSocialMedia {

    @Id
    private Long id;
    private List<EnumPlatform> platforms;
    private String text;
    private boolean isSchedule;
    private boolean scheduleDate;
    private List<Image> images;

}
