package dev.sospets.sosproject.Informations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Informations {

    @Id
    private Long id;
    private String cnpj;
    private String pixKey;
    private String email;
    private String phone;
    private String address;

}
