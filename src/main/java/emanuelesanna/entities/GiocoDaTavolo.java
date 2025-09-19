package emanuelesanna.entities;

public class GiocoDaTavolo extends Gioco {
    private int numberoDiGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String titoloGioco, int annoDiPubblicazione, double prezzoGioco, int numberoDiGiocatori, int durataMediaPartita) {
        super(titoloGioco, annoDiPubblicazione, prezzoGioco);
        this.numberoDiGiocatori = numberoDiGiocatori;
        this.durataMediaPartita = durataMediaPartita;


    }

    public int getNumberoDiGiocatori() {
        return numberoDiGiocatori;
    }

    public void setNumberoDiGiocatori(int numberoDiGiocatori) {
        if (numberoDiGiocatori < 2 || numberoDiGiocatori > 10) {
            throw new IllegalArgumentException("Il numero dei giocatori deve essere compreso tra 2 e 10 inclusi");
        }
        this.numberoDiGiocatori = numberoDiGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }

    @Override
    public String toString() {
        return super.toString() + "GiocoDaTavolo{" +
                "numberoDiGiocatori=" + numberoDiGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}
