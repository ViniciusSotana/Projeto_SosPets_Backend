package dev.sospets.sosproject.Partner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.sospets.sosproject.Specialty.Specialty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerResponseDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @Email
    private String email;
    private String siteUrl;
    @JsonIgnore
    private List<Specialty> specialties;

}
