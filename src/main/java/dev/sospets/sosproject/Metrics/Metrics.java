package dev.sospets.sosproject.Metrics;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metrics {

    @Id
    private Long id;
    private Integer rescuedPets;
    private Integer activeVolunteers;
    private Double financialSupport;
    private Integer totalFollowers;
    private Integer facebookFollowers;
    private Integer instagramFollowers;

}
