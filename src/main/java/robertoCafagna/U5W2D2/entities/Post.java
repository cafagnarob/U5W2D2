package robertoCafagna.U5W2D2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class Post {
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int minutiDiLettura;

    public Post(String categoria, String titolo, String contenuto, int minutiDiLettura) {
        Random random = new Random();
        this.id = random.nextInt(1, 10000);
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.minutiDiLettura = minutiDiLettura;
    }
}
