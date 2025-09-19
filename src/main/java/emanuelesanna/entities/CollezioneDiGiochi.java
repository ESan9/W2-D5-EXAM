package emanuelesanna.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollezioneDiGiochi {
    private List<Gioco> giochi;

    public CollezioneDiGiochi() {
        this.giochi = new ArrayList<>();
    }

    public void aggiungiGioco(Gioco g) {
        boolean esisteGioco = giochi.stream()
                .anyMatch(gioco -> gioco.getIdGioco() == g.getIdGioco());
        if (esisteGioco) {
            System.err.println("Errore: esiste già un gioco con ID " + g.getIdGioco());
        } else {
            giochi.add(g);
            System.out.println("Aggiunto con successo: " + g);
        }
    }

    public Gioco cercaPerId(int id) {
        return giochi.stream()
                .filter(gioco -> gioco.getIdGioco() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Gioco> cercaPerPrezzo(double prezzo) {
        return giochi.stream()
                .filter(gioco -> gioco.getPrezzoGioco() <= prezzo)
                .sorted(Comparator.comparing(Gioco::getPrezzoGioco)
                        .reversed())
                .toList();
    }

    @Override

    public String toString() {
        return "CollezioneDiGiochi{" +
                "giochi=" + giochi +
                '}';
    }
}


