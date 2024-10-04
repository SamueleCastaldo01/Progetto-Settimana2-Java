package samueleCastaldo;

import samueleCastaldo.giochi.Collezione;
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
          System.out.println("\n-------------------------------------------------------------------------");
          System.out.println("Menu operazioni: ");
          System.out.println("1. Aggiungi Gioco;");
          System.out.println("2. Ricerca gioco per ID;");
          System.out.println("3. Ricerca per prezzo Inferiore;");
          System.out.println("4. Ricerca per numero di giocatori;");
          System.out.println("5. Rimozione di un gioco tramite ID;");
          System.out.println("6. Aggiornamento di un gioco tramite ID;");
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
              case 1:
                  System.out.println("\n------------------");
                  System.out.println("Aggiungi gioco");
                  System.out.print("Seleziona il tipo di gioco: 1. VideoGioco, 2. Gioco da tavolo: ");
                  int tipoGioco = scanner.nextInt();
                  scanner.nextLine();

                  //questi sono i dati base, che entrambe le tipologie hanno
                  System.out.print("Inserisci l'id (long): ");
                  long idGioco = scanner.nextLong();
                  scanner.nextLine();
                  System.out.print("Inserisci il titolo del gioco (String): ");
                  String titoloGioco = scanner.nextLine();
                  System.out.print("Inserisci l'anno di produzione (String): ");
                  String annoDiProduzioneGioco = scanner.nextLine();
                  System.out.print("Inserisci il prezzo del gioco (double): ");
                  double prezzoGioco = scanner.nextDouble();
                  scanner.nextLine();

                  //gestione del tipo di gioco
                  if(tipoGioco == 1) {  //caso in cui sia un videogioco
                      System.out.print("Inserisci la piattaforma (String): ");
                      String piattaformaGioco = scanner.nextLine();
                      System.out.print("Inserisci la durata di gioco in ore (int): ");
                      int durataDiGioco = scanner.nextInt();
                      scanner.nextLine(); //dopo ogni next int conviene usare questa
                      System.out.print("Inserisci il genere del videogioco (AVVENTURA, AZIONE, SPORT): ");
                      String genereInput = scanner.nextLine();
                      Videogioco.Genere genereGioco = Videogioco.Genere.valueOf(genereInput.toUpperCase());

                      //creazione del videogioco
                      Videogioco nuovoVideogioco = new Videogioco(idGioco, titoloGioco, annoDiProduzioneGioco, prezzoGioco, piattaformaGioco, durataDiGioco, genereGioco);
                      try{
                          collezione.aggiungiGioco(nuovoVideogioco);
                      } catch (IllegalArgumentException error) {
                          System.out.println(error.getMessage());
                      }
                  } else if (tipoGioco == 2) { //caso in cui sia un gioco da tavolo
                      System.out.print("Inserisci il numero di giocatori da 2 a 10 (int): ");
                      int numeroGiocatoriGioco = scanner.nextInt();
                      System.out.print("Inserisci  la durata media del gioco in minuti (int): ");
                      int durataMediaPartita = scanner.nextInt();

                      //creazione gioco da tavolo
                      GiocoDaTavolo nuovoGiocoDaTavolo = new GiocoDaTavolo(idGioco, titoloGioco, annoDiProduzioneGioco, prezzoGioco, numeroGiocatoriGioco, durataMediaPartita);
                      try{
                          collezione.aggiungiGioco(nuovoGiocoDaTavolo);
                      } catch (IllegalArgumentException error) {
                          System.out.println(error.getMessage());
                      }
                  } else {  //nel caso in cui non si selezioni ne 1 ne 2
                      System.out.println("tipo di gioco non valido");
                  }
                  break;
              case 2:
                  //ricerca per id
                  System.out.println("\n------------------");
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
                  System.out.println("\n------------------");
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
                  System.out.println("\n------------------");
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
                  System.out.println("\n------------------");
                  System.out.print("Rimozione gioco tramite id, Inserisci un id (long): ");
                  long idRemove = scanner.nextLong();
                  try {
                      collezione.rimozioneGioco(idRemove);
                  } catch (IllegalArgumentException error) {
                      System.out.println(error.getMessage());
                  }
                  break;
              case 6:
                  //aggiornamento gioco tramite id
                  System.out.println("\n------------------");
                  System.out.println("Aggiorna gioco");
                  System.out.print("Inserisci l'id del gioco che vuoi aggiornare (long): ");
                  long idGioco1 = scanner.nextLong();
                  scanner.nextLine();
                  System.out.print("Seleziona il tipo di gioco: 1. VideoGioco, 2. Gioco da tavolo: ");
                  int tipoGioco1 = scanner.nextInt();
                  scanner.nextLine();

                  //questi sono i dati base, che entrambe le tipologie hanno
                  System.out.print("Inserisci il titolo del gioco (String): ");
                  String titoloGioco1 = scanner.nextLine();
                  System.out.print("Inserisci l'anno di produzione (String): ");
                  String annoDiProduzioneGioco1 = scanner.nextLine();
                  System.out.print("Inserisci il prezzo del gioco (double): ");
                  double prezzoGioco1 = scanner.nextDouble();
                  scanner.nextLine();

                  //gestione del tipo di gioco
                  if(tipoGioco1 == 1) {  //caso in cui sia un videogioco
                      System.out.print("Inserisci la piattaforma (String): ");
                      String piattaformaGioco = scanner.nextLine();
                      System.out.print("Inserisci la durata di gioco in ore (int): ");
                      int durataDiGioco = scanner.nextInt();
                      scanner.nextLine(); //dopo ogni next int conviene usare questa
                      System.out.print("Inserisci il genere del videogioco (AVVENTURA, AZIONE, SPORT): ");
                      String genereInput = scanner.nextLine();
                      Videogioco.Genere genereGioco = Videogioco.Genere.valueOf(genereInput.toUpperCase());

                      //creazione del videogioco
                      Videogioco nuovoVideogioco = new Videogioco(idGioco1, titoloGioco1, annoDiProduzioneGioco1, prezzoGioco1, piattaformaGioco, durataDiGioco, genereGioco);
                      try{
                          collezione.aggiornaGioco(idGioco1 ,nuovoVideogioco);
                      } catch (IllegalArgumentException error) {
                          System.out.println(error.getMessage());
                      }
                  } else if (tipoGioco1 == 2) { //caso in cui sia un gioco da tavolo
                      System.out.print("Inserisci il numero di giocatori da 2 a 10 (int): ");
                      int numeroGiocatoriGioco = scanner.nextInt();
                      System.out.print("Inserisci  la durata media del gioco in minuti (int): ");
                      int durataMediaPartita = scanner.nextInt();

                      //creazione gioco da tavolo
                      GiocoDaTavolo nuovoGiocoDaTavolo = new GiocoDaTavolo(idGioco1, titoloGioco1, annoDiProduzioneGioco1, prezzoGioco1, numeroGiocatoriGioco, durataMediaPartita);
                      try{
                          collezione.aggiornaGioco(idGioco1 ,nuovoGiocoDaTavolo);
                      } catch (IllegalArgumentException error) {
                          System.out.println(error.getMessage());
                      }
                  } else {  //nel caso in cui non si selezioni ne 1 ne 2
                      System.out.println("tipo di gioco non valido");
                  }
                  break;
              case 7:
                  //statistiche lista collezione
                  try {
                      collezione.statisticheGiochi();
                  } catch (IllegalArgumentException error) {
                      System.out.println(error.getMessage());
                  }
                  break;
              case 8:
                  System.out.println("\n------------------");
                  System.out.println("Risultato operazione 8: ");
                  collezione.getGiochi().forEach(System.out::println);
                  break;

              default:
                  System.out.println("\nOpzione non valida, Riprova");
          }

      }while(scelta != 0);


     //questi sono tutti i test che ho fatto, per provare i vari metodi che andavo ad implementare
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
