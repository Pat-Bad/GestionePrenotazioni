package it.epicode.GestionePrenotazioni.Services;

import it.epicode.GestionePrenotazioni.Postazioni.Postazione;
import it.epicode.GestionePrenotazioni.Postazioni.PostazioneRepository;
import it.epicode.GestionePrenotazioni.Prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.Prenotazioni.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.Users.User;
import it.epicode.GestionePrenotazioni.Users.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrenotazioniService {
    private final PostazioneRepository postazioneRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final UserRepository userRepository;

    // Metodo per cercare la postazione disponibile in base alla città dell'edificio
    public List<Postazione> cercaPostazioniPerCitta(String citta, boolean isAvailable) {
        return postazioneRepository.findByEdificioCittaAndDisponibile(citta, isAvailable);
    }

    // Metodo per vedere se c'è già una prenotazione
    public boolean haPrenotazioneNellaData(Long userId, LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUserId(userId);
        for (Prenotazione p : prenotazioni) {
            if (p.getDataPrenotazione().isEqual(dataPrenotazione)) {
                return true;
            }
        }
        return false;
    }

    // Metodo per prenotare effettivamente la postazione
    @Transactional
    public String prenotaPostazione(Long postazioneId, Long userId, LocalDateTime dataPrenotazione) {
        if (haPrenotazioneNellaData(userId, dataPrenotazione.toLocalDate())) {
            return "Non puoi prenotare più di una postazione nello stesso giorno.";
        }
        Optional<Postazione> postazione = postazioneRepository.findById(postazioneId);
        if (postazione.isPresent() && postazione.get().isDisponibile()) {

            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent()) {
                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setPostazione(postazione.get());
                prenotazione.setUser(user.get());
                prenotazione.setDataPrenotazione(LocalDate.from(dataPrenotazione));
                prenotazioneRepository.save(prenotazione);
                postazione.get().setDisponibile(false);
                postazioneRepository.save(postazione.get());

                return "postazione: " + postazione;
            } else {
                return "Utente non trovato!";
            }
        } else {
            return "purtroppo la postazione non è disponibile.";
        }
    }
}
