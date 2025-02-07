package it.epicode.GestionePrenotazioni.runners;

import it.epicode.GestionePrenotazioni.Postazioni.Postazione;
import it.epicode.GestionePrenotazioni.Postazioni.PostazioneRepository;
import it.epicode.GestionePrenotazioni.Prenotazioni.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.Services.PrenotazioniService;
import it.epicode.GestionePrenotazioni.Users.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;


@Component
@AllArgsConstructor
@Order(2)
public class RunnerScanner implements CommandLineRunner {
    private final PostazioneRepository postazioneRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final UserRepository userRepository;
    private final PrenotazioniService prenotazioniService;


    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un'opzione");
            System.out.println("1. Cercare una postazione disponibile");
            System.out.println("2. Prenota una postazione");
            System.out.println("3. Uscire");

            int choice = scanner.nextInt();

            switch(choice){
                case 1: cercaPostazione(scanner);
                break;
                case 2: prenotaPostazione(scanner);
                break;
                case 3: scanner.close();
                return;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        }

    }

    public void cercaPostazione(Scanner scanner) {
        System.out.println("Inserisci la città in cui vuoi prenotare");

        scanner.nextLine();
        String citta = scanner.nextLine();

        System.out.println("Hai scelto la città: " + citta);
        List<Postazione> postazioniDisponibili = prenotazioniService.cercaPostazioniPerCitta(citta, true);

        System.out.println("Postazioni trovate: " + postazioniDisponibili.size());

        if (postazioniDisponibili.isEmpty()) {
            System.out.println("Nessuna postazione disponibile in questa città");
        } else {
            System.out.println("Postazioni disponibili: " + postazioniDisponibili.size());
            for (Postazione postazione : postazioniDisponibili) {
                System.out.println("ID postazione: " + postazione.getId()
                        + "\n - Tipo: " + postazione.getTipoPostazione()
                        + "- Edificio: " + postazione.getEdificio());
            }
        }
    }
    @Transactional
    private void prenotaPostazione(Scanner scanner) {
        System.out.println("Inserisci il tuo ID");
        Long idUtente = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Inserisci l'ID della postazione che vuoi prenotare");
        Long idPostazione = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Inserisci la data della prenotazione (anno-mese-giorno): ");
        String dataPrenotazioneInput = scanner.nextLine();

            try {
                LocalDate data = LocalDate.parse(dataPrenotazioneInput);
                LocalDateTime dataPrenotazione = data.atStartOfDay();


                boolean prenotazioneValida = prenotazioniService.haPrenotazioneNellaData(idUtente, data);
                if (prenotazioneValida) {
                    System.out.println("Non puoi prenotare più di una postazione nello stesso giorno.");
                } else {

                    String prenotata = prenotazioniService.prenotaPostazione(idPostazione, idUtente, dataPrenotazione);
                    System.out.println("Ecco la tua prenotazione: " + prenotata);
                }
            } catch (DateTimeParseException e) {

                System.out.println("Data non valida. Assicurati di seguire il formato 'anno-mese-giorno'.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Si è verificato un errore. Riprova.");
            }}}
