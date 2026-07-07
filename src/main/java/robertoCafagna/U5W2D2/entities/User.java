package robertoCafagna.U5W2D2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Setter
@Getter
@ToString
public class User {
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public User(String nome, String cognome, String email, LocalDate dataDiNascita) {
        Random random = new Random();
        this.id = random.nextInt(1, 10000);
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = "https://ui-avatars.com/api/?name=Mario+Rossi";
    }
}
