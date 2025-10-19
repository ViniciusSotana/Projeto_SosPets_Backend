package dev.sospets.sosproject.Image;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequestDto {

    private Long id;
    @NotBlank
    private String path;


}
