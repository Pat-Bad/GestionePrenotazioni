package it.epicode.GestionePrenotazioni.Prenotazioni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrenotazioneConfig {
    @Bean
    public Prenotazione prenotazione1() {
        Prenotazione prenotazione1 = new Prenotazione();
        return prenotazione1;
    }
    @Bean
    public Prenotazione prenotazione2() {
        Prenotazione prenotazione2 = new Prenotazione();
        return prenotazione2;
    }
}
