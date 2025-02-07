package it.epicode.GestionePrenotazioni.Postazioni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostazioneConfig {
    @Bean
    public Postazione postazione1() {
        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Piano terra");
        postazione1.setTipoPostazione(tipoPostazione.PRIVATO);
        postazione1.setNumeroMaxOccupanti(1);

       return postazione1;
    }
    @Bean
    public Postazione postazione2() {
        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Primo piano");
        postazione2.setTipoPostazione(tipoPostazione.SALA_RIUNIONI);
        postazione2.setNumeroMaxOccupanti(10);
        return postazione2;
    }
}
