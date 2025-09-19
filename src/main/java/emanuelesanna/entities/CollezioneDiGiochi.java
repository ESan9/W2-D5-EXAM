package emanuelesanna.entities;

import java.util.*;

public class CollezioneDiGiochi {
    private List<Gioco> giochi;

    public CollezioneDiGiochi() {
        this.giochi = new ArrayList<>();
    }

    public void aggiungiGioco(Gioco g) {
        Objects.requireNonNull(g, "Il gioco non può essere null");
        boolean duplicato = giochi.stream().anyMatch(x -> x.getIdGioco() == g.getIdGioco());
        if (duplicato) throw new IllegalArgumentException("Esiste già un gioco con ID " + g.getIdGioco());
        giochi.add(g);
    }

    public Optional<Gioco> cercaPerId(int id) {
        if (id <= 0) throw new IllegalArgumentException("L'ID deve essere positivo");
        return giochi.stream()
                .filter(g -> g.getIdGioco() == id)
                .findFirst();
    }

    public List<Gioco> cercaPerPrezzo(double prezzo) {
        return giochi.stream()
                .filter(gioco -> gioco.getPrezzoGioco() <= prezzo)
                .sorted(Comparator.comparing(Gioco::getPrezzoGioco)
                        .reversed())
                .toList();
    }

    public List<Gioco> cercaPerGiocatori(int giocatori) {
        return giochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
//                .toList();
//        System.out.println(cercaPerGiocatori);
                .map(gioco -> (GiocoDaTavolo) gioco)
                .filter(giocoDaTavolo -> giocoDaTavolo.getNumberoDiGiocatori() == giocatori)
                .map(giocoDaTavolo -> (Gioco) giocoDaTavolo)
                .toList();
    }

    public void eliminaElementoPerId(int id) {
        Optional<Gioco> giocoOptional = giochi.stream()
                .filter(gioco -> gioco.getIdGioco() == id)
                .findFirst();
        // Cosa voglio? Mmmmm un Optional perché può non esserci di Gioco dal quale estrarre il valore con get nel caso in cui sia presente
        if (giocoOptional.isPresent()) {
            Gioco gioco1 = giocoOptional.get();
            giochi.remove(gioco1);
        } else {
            System.out.println("Non è presente un gioco con questo ID");
        }

    }

    public DoubleSummaryStatistics sommarioDiStatistiche() {
        DoubleSummaryStatistics statsGiochi = giochi.stream()
                .mapToDouble(Gioco::getPrezzoGioco)
                .summaryStatistics();
        return statsGiochi;
    }

//    Purtroppo non ritorna il totale di videogiochi o giochi da tavolo ma almeno ho la media e volevo provarlo

    public int numeroVideogiochi() {
        return (int) giochi.stream()
                .filter(gioco -> gioco instanceof Videogioco)
                .count();
    }

    public int numeroGiochiDaTavolo() {
        return (int) giochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .count();
    }

    public String giocoConPrezzoMax() {
        return giochi.stream()
                .max(Comparator.comparingDouble(Gioco::getPrezzoGioco))
                .toString();
    }

//    public Optional<Gioco> aggiornaElementoPerId(int id) {
//        if (id <= 0) throw new IllegalArgumentException("L'ID deve essere positivo");
//        Optional<Gioco> giocoOptional = giochi.stream()
//                .filter(gioco -> gioco.getIdGioco() == id)
//                .findFirst();
//        Mi sono lasciato per ultimo questo, da scrivere è lunghissimo e non ho molto tempo
//
//    }

    @Override

    public String toString() {
        return "CollezioneDiGiochi{" +
                "giochi=" + giochi +
                '}';
    }
}


