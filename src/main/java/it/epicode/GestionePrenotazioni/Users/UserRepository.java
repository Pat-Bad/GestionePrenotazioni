package it.epicode.GestionePrenotazioni.Users;

import it.epicode.GestionePrenotazioni.Prenotazioni.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
