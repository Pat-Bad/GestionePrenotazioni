package it.epicode.GestionePrenotazioni.Prenotazioni;

import it.epicode.GestionePrenotazioni.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUserId(Long userId);
}
