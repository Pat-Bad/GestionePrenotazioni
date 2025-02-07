package it.epicode.GestionePrenotazioni.Users;

import it.epicode.GestionePrenotazioni.Prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String nomeCompleto;
    private String mail;

    @OneToMany(mappedBy="user")
    private List<Prenotazione> listaPrenotazioni = new ArrayList<>();
}
