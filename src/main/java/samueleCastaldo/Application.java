package samueleCastaldo;

import samueleCastaldo.giochi.Gioco;
import samueleCastaldo.giochi.GiocoDaTavolo;
import samueleCastaldo.giochi.Videogioco;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione(); //creo l'oggetto collezione, (andrà a creare la lista vuota giochi)

        List<Gioco> listaProva = Arrays.asList(
                new Videogioco(1, "The Witcher 3", "2015", 49.99, "PC", 50, Videogioco.Genere.AVVENTURA),
                new GiocoDaTavolo(2, "Monopoly", "1935", 29.99, 4, 120),
                new Videogioco(3, "FIFA 24", "2024", 59.99, "PS5", 30, Videogioco.Genere.SPORT),
                new GiocoDaTavolo(4, "Catan", "1995", 39.99, 4, 90),
                new Videogioco(5, "Dark Souls", "2011", 39.99, "PC", 40, Videogioco.Genere.AZIONE),
                new GiocoDaTavolo(6, "Ticket to Ride", "2004", 34.99, 2, 30),
                new GiocoDaTavolo(7, "Cluedo", "1974", 29.99, 4, 120)
        );

      //test esercizio 1. Aggiunta dei giochi, io lo ho fatto tramite lista, per testare
      for (Gioco g : listaProva) { //vado ad iterare la lista di prova per aggiungere a collezione
          try{
              collezione.aggiungiGioco(g); //vado ad richiamare il metodo aggiungi, in un blocco try, perché dall'altro lato ho gestisto l'eccezione
          } catch (IllegalArgumentException error) {
              System.out.println(error.getMessage());
          }
      }

      //test Esercizio 2, ricerca giochi tramite ID
        try{
            collezione.ricercaID(1);
            collezione.ricercaID(2);
            //collezione.ricercaID(8);  //in questo caso non è presente, in questo caso attualmente si arresta il programma
            collezione.ricercaID(3);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }


    }
}
