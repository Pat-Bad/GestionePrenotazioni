package it.epicode.GestionePrenotazioni.Users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public User user1(){
        User user1 = new User();
        user1.setUsername("PrimoUtenteCreato");
        user1.setNomeCompleto("Patricia Badji");
        user1.setMail("patricia@ciao.com");
        return user1;
    }

    @Bean
    public User user2(){
        User user2 = new User();
        user2.setUsername("SecondoUtenteCreato");
        user2.setNomeCompleto("Jules Destropper");
        user2.setMail("jules@ciao.com");
        return user2;
    }
}
