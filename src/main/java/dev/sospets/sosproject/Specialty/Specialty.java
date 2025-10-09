package dev.sospets.sosproject.Specialty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Specialty {

    @Id
    private Long id;
    private String name;

}
