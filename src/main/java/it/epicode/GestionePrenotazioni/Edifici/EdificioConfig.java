package it.epicode.GestionePrenotazioni.Edifici;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdificioConfig {

    @Bean
    public Edificio edificio1() {
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Palazzo Stella");
        edificio1.setIndirizzo("Via del Cielo, 5");
        edificio1.setCitta("Milano");

        return edificio1;
    };

    @Bean
    public Edificio edificio2() {
        Edificio edificio2 = new Edificio();
        edificio2.setNome("Palazzo Blu");
        edificio2.setIndirizzo("Via del Mare, 7");
        edificio2.setCitta("Bari");

        return edificio2;}


}
