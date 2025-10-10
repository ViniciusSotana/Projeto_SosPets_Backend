package dev.sospets.sosproject.Specialty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDto {

    private Long id;
    @NotBlank
    private String name;

}
