package emanuelesanna.entities;

import java.util.ArrayList;
import java.util.List;

public class CollezioneDiGiochi {
    private List<Gioco> giochi;

    public CollezioneDiGiochi() {
        this.giochi = new ArrayList<>();
    }

    public void aggiungiGioco(Gioco g) {
        giochi.add(g);
    }

    public Gioco cercaPerId(int id) {
        return giochi.stream()
                .filter(gioco -> gioco.getIdGioco() == id)
                .findFirst()
                .orElse(null);
    }

}


