package samueleCastaldo;

import samueleCastaldo.giochi.Gioco;
import samueleCastaldo.giochi.GiocoDaTavolo;
import samueleCastaldo.giochi.Videogioco;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione(); //creo l'oggetto collezione, (andrà a creare la lista vuota giochi)
        Scanner scanner = new Scanner(System.in);

        List<Gioco> listaProva = Arrays.asList(
                new Videogioco(1, "The Witcher 3", "2015", 49.99, "PC", 50, Videogioco.Genere.AVVENTURA),
                new GiocoDaTavolo(2, "Monopoly", "1935", 29.99, 4, 120),
                new Videogioco(3, "FIFA 24", "2024", 59.99, "PS5", 30, Videogioco.Genere.SPORT),
                new GiocoDaTavolo(4, "Catan", "1995", 39.99, 4, 90),
                new Videogioco(5, "Dark Souls", "2011", 39.99, "PC", 40, Videogioco.Genere.AZIONE),
                new GiocoDaTavolo(6, "Ticket to Ride", "2004", 34.99, 2, 30),
                new GiocoDaTavolo(7, "Cluedo", "1974", 29.99, 4, 120)
        );

        //questo lo lascio in questo modo ho una lista di riferimento
      //test esercizio 1. Aggiunta dei giochi, io lo ho fatto tramite lista, per testare
      for (Gioco g : listaProva) { //vado ad iterare la lista di prova per aggiungere a collezione
          try{
              collezione.aggiungiGioco(g); //vado ad richiamare il metodo aggiungi, in un blocco try, perché dall'altro lato ho gestisto l'eccezione
          } catch (IllegalArgumentException error) {
              System.out.println(error.getMessage());
          }
      }

      int scelta = 0;
      do{
          System.out.println("\nMenu operazioni: ");
          System.out.println("1. Aggiungi Gioco;");
          System.out.println("2. Ricerca gioco per ID;");
          System.out.println("3. Ricerca per prezzo Inferiore;");
          System.out.println("4. Ricerca per numero di giocatori;");
          System.out.println("5. Rimozione di un gioco tramite ID;");
          System.out.println("6. Aggiornamento di gioco tramite ID;");
          System.out.println("7. Statistiche della lista collezione;");
          System.out.println("8. Visualizza lista collezione;");
          System.out.println("0. Termina programma;");
          System.out.print("\nSeleziona operazione: ");

          scelta = scanner.nextInt();

          //adesso faccio lo switch per andare ad utilizzare i vari metodi
          switch (scelta) {
              case 0:
                  System.out.println("Chiusura del programma in corso...");
                  break;
              case 2:
                  //ricerca per id
                  System.out.print("Ricerca per id, Inserisci un id (long): ");
                  long id = scanner.nextLong();
                  try{
                      collezione.ricercaID(id);
                  } catch (IllegalArgumentException error) {
                      System.out.println(error.getMessage());
                  }
                  break;
              case 3:
                  //ricerca per prezzo inferiore
                  System.out.print("Ricerca per prezzo inferiore, Inserisci un prezzo (double): ");
                  double prezzo = scanner.nextDouble();
                  try {
                      List<Gioco> risultato = collezione.ricercaPrezzoInferiore(prezzo);
                      risultato.forEach(System.out::println);
                  } catch (IllegalArgumentException error) {
                      System.out.println(error.getMessage());
                  }
                  break;
              case 4:
                  //ricerca per numero di giocatori
                  System.out.print("Ricerca per numero di giocatori, Inserisci numero di giocatori (int) da 2 a 10: ");
                  int numeroDiGiocatori = scanner.nextInt();
                  try{
                      List<GiocoDaTavolo> risultato = collezione.ricercaNumeroGiocatori(numeroDiGiocatori);
                      risultato.forEach(System.out::println);
                  } catch (IllegalArgumentException error) {
                      System.out.println(error.getMessage());
                  }
                  break;
              case 5:
                  //rimozione gioco tramite id
                  System.out.print("Rimozione gioco tramite id, Inserisci un id (long): ");
                  long idRemove = scanner.nextLong();
                  try {
                      collezione.rimozioneGioco(idRemove);
                  } catch (IllegalArgumentException error) {
                      System.out.println(error.getMessage());
                  }
                  break;
              case 8:
                  System.out.println("\nRisultato operazione 8: ");
                  collezione.getGiochi().forEach(System.out::println);
                  break;

              default:
                  System.out.println("Opzione non valida, Riprova");
          }

      }while(scelta != 0);






      /*
      //test Esercizio 2, ricerca giochi tramite ID
        try{
            collezione.ricercaID(1);
            collezione.ricercaID(2);
            //collezione.ricercaID(8);  //in questo caso non è presente, in questo caso attualmente si arresta il programma
            collezione.ricercaID(3);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        //test Esercizio 3, ricerca per prezzo inferiore mi restituisce una lista di Gioco
        try {
            List<Gioco> risultatoEsercizio3 = collezione.ricercaPrezzoInferiore(30);
            System.out.println("\nEsercizio numero 3");
            risultatoEsercizio3.forEach(System.out::println);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        //test Esercizio 4, ricerca per numero di giocatori quindi è riferito a giochi da tavolo
        try {
            List<GiocoDaTavolo> risultatoEsercizio4 = collezione.ricercaNumeroGiocatori(4);
            System.out.println("\nEsercizio numero 4");
            risultatoEsercizio4.forEach(System.out::println);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        //test Esercizio 5, eliminazione di un gioco tramite id.
        try {
            collezione.rimozioneGioco(1);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        //test Esercizio 6, aggiornamento gioco, tramite id
        GiocoDaTavolo giocoAggiornato = new GiocoDaTavolo(2, "Monopoly Deluxe", "1935", 39.99, 4, 120);
        try{
            collezione.aggiornaGioco(2, giocoAggiornato);
            System.out.println();
            collezione.getGiochi().forEach(System.out::println); //verifica della lista
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        //test Esercizio 7, statistiche
        collezione.statisticheGiochi();
       */


    }
}
