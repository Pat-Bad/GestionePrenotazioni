package it.epicode.GestionePrenotazioni.Edifici;

import it.epicode.GestionePrenotazioni.Postazioni.Postazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="edifici")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Postazione> listaPostazioni = new ArrayList<>();
}
