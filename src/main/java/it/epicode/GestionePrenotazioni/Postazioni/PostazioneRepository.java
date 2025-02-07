package it.epicode.GestionePrenotazioni.Postazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    Postazione findByTipoPostazione(tipoPostazione tipoPostazione);

    @Query("SELECT p FROM Postazione p WHERE p.edificio.citta = :citta AND p.disponibile = :disponibile")
    List<Postazione> findByCittaAndDisponibile(@Param("citta") String citta,
                                                @Param("disponibile") boolean disponibile);

    List<Postazione> findByEdificioCittaAndDisponibile(String citta, boolean disponibile);
}
