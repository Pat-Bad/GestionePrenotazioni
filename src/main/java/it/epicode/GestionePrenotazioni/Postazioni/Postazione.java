package it.epicode.GestionePrenotazioni.Postazioni;

import it.epicode.GestionePrenotazioni.Edifici.Edificio;
import it.epicode.GestionePrenotazioni.Prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="postazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descrizione;
    private tipoPostazione tipoPostazione;
    private int numeroMaxOccupanti;
    private boolean disponibile;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> listaPrenotazioni = new ArrayList<>();

    }

