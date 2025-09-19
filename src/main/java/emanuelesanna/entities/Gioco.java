package emanuelesanna.entities;

public class Gioco {
    private static int contatoreId = 0;
    private final int idGioco;
    private String titoloGioco;
    private int annoDiPubblicazione;
    private double prezzoGioco;

    public Gioco(String titoloGioco, int annoDiPubblicazione, double prezzoGioco) {
        this.idGioco = ++contatoreId;
        this.titoloGioco = titoloGioco;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.prezzoGioco = prezzoGioco;
    }

    public int getIdGioco() {
        return idGioco;
    }

    public String getTitoloGioco() {
        return titoloGioco;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public double getPrezzoGioco() {
        return prezzoGioco;
    }

    public void setPrezzoGioco(double prezzoGioco) {
        if (prezzoGioco <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere positivio");
        }
        this.prezzoGioco = prezzoGioco;
    }

    @Override
    public String toString() {
        return "Gioco{" +
                "idGioco=" + idGioco +
                ", titoloGioco='" + titoloGioco + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", prezzoGioco=" + prezzoGioco +
                '}';
    }
}
