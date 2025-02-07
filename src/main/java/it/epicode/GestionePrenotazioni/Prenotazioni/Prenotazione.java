package it.epicode.GestionePrenotazioni.Prenotazioni;

import it.epicode.GestionePrenotazioni.Postazioni.Postazione;
import it.epicode.GestionePrenotazioni.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="postazione_id")
    private Postazione postazione;
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
