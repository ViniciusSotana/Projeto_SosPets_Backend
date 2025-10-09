package dev.sospets.sosproject.Informations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Informations {

    @Id
    private Long id;
    private String cnpj;
    private String pixKey;
    private String email;
    private String phone;
    private String address;

}
