package emanuelesanna;

import emanuelesanna.entities.CollezioneDiGiochi;
import emanuelesanna.entities.Gioco;
import emanuelesanna.entities.GiocoDaTavolo;
import emanuelesanna.entities.Videogioco;
import emanuelesanna.enums.Genere;
import emanuelesanna.enums.Piattaforma;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
//        Genero qualche istanza

        Videogioco v1 = new Videogioco("The Legend of Zelda", 2017, 69.99,
                Piattaforma.NINTENDO, 100, Genere.AVVENTURA);
        Videogioco v2 = new Videogioco("The Witcher 3", 2015, 49.99,
                Piattaforma.PC, 150, Genere.RPG);
        Videogioco v3 = new Videogioco("FIFA 23", 2022, 79.99,
                Piattaforma.PLAYSTATION, 30, Genere.SPORT);

        GiocoDaTavolo t1 = new GiocoDaTavolo("Risiko", 1957, 24.99, 4, 120);
        GiocoDaTavolo t2 = new GiocoDaTavolo("Catan", 1995, 34.99, 3, 90);
        GiocoDaTavolo t3 = new GiocoDaTavolo("Scacchi", 1475, 19.99, 2, 60);

        CollezioneDiGiochi coll1 = new CollezioneDiGiochi();

        coll1.aggiungiGioco(t1);
        coll1.aggiungiGioco(t2);
        coll1.aggiungiGioco(t3);
        coll1.aggiungiGioco(v1);
        coll1.aggiungiGioco(v2);
        coll1.aggiungiGioco(v3);

        Scanner scan1 = new Scanner(System.in);

        boolean continua = true;

        while (continua) {

            System.out.println("Benvenuto nella tua collezione, scegli cosa fare:");
            System.out.println("Premi 0 per terminare il programma");
            System.out.println("Premi 1 per aggiungere un elemento");
            System.out.println("Premi 2 per cercare un elemento per ID");
            System.out.println("Premi 3 per cercare elementi che hanno un prezzo fino a quello inserito");
            System.out.println("Premi 4 per cercare un elemento per numero di giocatori");
            System.out.println("Premi 5 per rimuovere un elemento dato un codice ID");
            System.out.println("Premi 6 per aggiornare un elemento esistente dato l'ID");
            System.out.println("Premi 7 per stampare le statistiche della collezione");

            int scelta1 = -1;

            try {
                scelta1 = Integer.parseInt(scan1.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Scelta non valida, digita un numero da 0 a 7!");
            }

            switch (scelta1) {
                case 0:
                    continua = false;
                    System.out.println("Programma terminato");
                    break;
                case 1:

//            case 2:
                    System.out.println("Digita un ID");
                    try {
                        int scelta2 = Integer.parseInt(scan1.nextLine());
                        Gioco gioco1 = coll1.cercaPerId(scelta2);

                        if (gioco1 != null) {
                            System.out.println("Gioco trovato:");
                            System.out.println(gioco1);
                        } else {
                            System.err.println("Nessun gioco trovato con ID " + scelta2);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Errore: devi inserire un numero intero valido!");
                    }
                    break;
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//            case 7:
            }
        }
    }


}
