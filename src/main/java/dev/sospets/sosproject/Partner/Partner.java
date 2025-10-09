package dev.sospets.sosproject.Partner;

import dev.sospets.sosproject.Specialty.Specialty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Partner {

    @Id
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String siteUrl;
    @OneToMany
    private List<Specialty> specialties;

}
