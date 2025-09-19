package emanuelesanna.entities;

import emanuelesanna.enums.Genere;
import emanuelesanna.enums.Piattaforma;

public class Videogioco extends Gioco {
    private Piattaforma piattaformaDiGioco;
    private int durataDiGioco;
    private Genere genereGioco;

    public Videogioco(String titoloGioco, int annoDiPubblicazione, double prezzoGioco, Piattaforma piattaformaDiGioco, int durataDiGioco, Genere genereGioco) {
        super(titoloGioco, annoDiPubblicazione, prezzoGioco);
        this.piattaformaDiGioco = piattaformaDiGioco;
        this.durataDiGioco = durataDiGioco;
        this.genereGioco = genereGioco;
    }

    public Piattaforma getPiattaformaDiGioco() {
        return piattaformaDiGioco;
    }

    public void setPiattaformaDiGioco(Piattaforma piattaformaDiGioco) {
        this.piattaformaDiGioco = piattaformaDiGioco;
    }

    public int getDurataDiGioco() {
        return durataDiGioco;
    }

    public void setDurataDiGioco(int durataDiGioco) {
        this.durataDiGioco = durataDiGioco;
    }

    public Genere getGenereGioco() {
        return genereGioco;
    }

    public void setGenereGioco(Genere genereGioco) {
        this.genereGioco = genereGioco;
    }

    @Override
    public String toString() {
        return super.toString() + "Videogioco{" +
                "piattaformaDiGioco=" + piattaformaDiGioco +
                ", durataDiGioco=" + durataDiGioco +
                ", genereGioco=" + genereGioco +
                '}';
    }
}
