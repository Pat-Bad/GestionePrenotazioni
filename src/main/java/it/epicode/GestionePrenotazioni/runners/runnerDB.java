package it.epicode.GestionePrenotazioni.runners;

import it.epicode.GestionePrenotazioni.Edifici.EdificioRepository;
import it.epicode.GestionePrenotazioni.Postazioni.Postazione;
import it.epicode.GestionePrenotazioni.Postazioni.PostazioneRepository;
import it.epicode.GestionePrenotazioni.Prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.Prenotazioni.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.Users.User;
import it.epicode.GestionePrenotazioni.Users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import it.epicode.GestionePrenotazioni.Edifici.Edificio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class runnerDB implements CommandLineRunner {
    private final Edificio edificio1;
    private final Edificio edificio2;
    private final Postazione postazione1;
    private final Postazione postazione2;
    private final User user1;
    private final User user2;
    private final Prenotazione prenotazione1;
    private final Prenotazione prenotazione2;
    private final PostazioneRepository postazioneRepository;
    private final EdificioRepository edificioRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Prova salvataggio");
        edificioRepository.save(edificio1);

        edificio1.getListaPostazioni().add(postazione1);
        edificio1.getListaPostazioni().add(postazione2);

        postazione1.setEdificio(edificio1);
        postazione2.setEdificio(edificio1);

        postazioneRepository.save(postazione1);
        postazioneRepository.save(postazione2);

        System.out.println("fine prova salvataggio");
        System.out.println("prova associazione prenotazioni");
        userRepository.save(user1);

        postazione1.getListaPrenotazioni().add(prenotazione1);

        user1.getListaPrenotazioni().add(prenotazione1);

        prenotazione1.setUser(user1);
        prenotazione1.setPostazione(postazione1);
        prenotazione1.setDataPrenotazione(LocalDate.of(2025,02,07));
        prenotazione2.setPostazione(postazione1);
        prenotazione2.setUser(user1);
        prenotazione2.setDataPrenotazione(LocalDate.of(2025,03,07));

        prenotazioneRepository.save(prenotazione1);
        prenotazioneRepository.save(prenotazione2);
        System.out.println("fine prova associazione prenotazioni");
        Edificio milano = edificioRepository.findByCitta("Milano");
        System.out.println("---------------------------------\n"+ milano);


       // List<Prenotazione> prenotazioniUser1 = prenotazioneRepository.findByUserId(1L);
        //System.out.println("=========== prenotazioniUser1 ============" +prenotazioniUser1);







    }
}
