package it.epicode.GestionePrenotazioni.Edifici;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    Edificio findByCitta(String citta);
}
