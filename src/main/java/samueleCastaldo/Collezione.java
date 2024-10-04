package samueleCastaldo;

import samueleCastaldo.giochi.Gioco;
import samueleCastaldo.giochi.GiocoDaTavolo;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> giochi;

    public Collezione() {
        this.giochi = new ArrayList<>(); //in questo modo andiamo a creare una lista vuota
    }

    public List<Gioco> getGiochi() {
        return giochi;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    //Esercizio1 aggiungi gioco l'elemento Id deve essere univoco, quindi devo fare il controllo, prima di inserirlo
    public void aggiungiGioco (Gioco gioco) {
        boolean idEsistente = giochi.stream().anyMatch(game -> game.getIdGioco() == gioco.getIdGioco());
        if(idEsistente) {
            throw new IllegalArgumentException("questo id esiste già: " + gioco.getIdGioco());
        } else {
            giochi.add(gioco);  //aggiunge il gioco alla lista
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
    //Esercizio 2 ricerca per ID
    public void ricercaID (long id) {
        // vado a fare il filter e va a prendere l'elemento con lo stesso id, metto il limit tanto l'id è univoco
        List<Gioco> giocoTrovato = giochi.stream().filter(game -> game.getIdGioco() == id).limit(1).toList();
        System.out.println();
        if(!giocoTrovato.isEmpty()) {  //controllo tramite se la lista è vuota o meno
            Gioco trovato = giocoTrovato.getFirst();  //andiamo a prendere il primo elemento, tanto ne abbiamo solo 1
            System.out.println("titolo: " + trovato.getTitolo() + " ID: " + trovato.getIdGioco());
        } else {  //Se la lista è vuota allora abbiamo l'eccezione
            throw new IllegalArgumentException("Il gioco non esiste: " +id);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
    //Esercizio 3 ricerca per prezzo, deve ritornare una lista di giochi con prezzo inferiore al prezzo inserito
    public List<Gioco> ricercaPrezzoInferiore (double prezzo) {
        List<Gioco> risultati = giochi.stream().filter(game -> game.getPrezzo() < prezzo).toList();
        if(!risultati.isEmpty()) {  //controllo tramite se la lista è vuota o meno, stesso controllo di sopra
            return risultati;
        } else {  //Se la lista è vuota allora abbiamo l'eccezione
            throw new IllegalArgumentException("Non esiste un gioco con il prezzo inferiore a: " +prezzo);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
    //Esercizio 4; Ricerca per numero giocatori, quindi deve essere uguale a quel numero, e credo intenda di ritornare la lista
    //devo fare prima di tutto un controllo solo sui giochi da tavolo, e poi fare la comparazione
    public List<GiocoDaTavolo> ricercaNumeroGiocatori (int numeroGiocatori) {
        //come prima cosa vado a verificare se il numero di giocatori inseriti dall'utente rispetti il range
        if(numeroGiocatori <2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Il numero di giocatori deve essere compreso tra 2 a 10");
        }
        //ricerca tramite lo stream, mi restituisce una lista
        List<GiocoDaTavolo> risultati = giochi.stream().filter(game-> game instanceof GiocoDaTavolo) //va a prendersi solo i giochi da tavolo
                .map(game -> (GiocoDaTavolo) game).filter(giocoDaTavolo -> giocoDaTavolo.getNumeroDiGiocatori() == numeroGiocatori)
                .toList();

        if (!risultati.isEmpty()) { //Stesso controllo rispetto ai precedenti
            return risultati;
        } else {
            throw new IllegalArgumentException("Non esistono giochi da tavolo per " + numeroGiocatori + " giocatori.");
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
    //Esercizio 5, Rimozione tramite un codice ID. In questo coso lo posso fare con un void, con la conferma
    public void rimozioneGioco (long id) {
        boolean rimosso = giochi.removeIf(game -> game.getIdGioco() == id); //questo metodo mi permette direttamente di rimuovere l'elemento se lo trova
        System.out.println("\nEsercizio 5");
        if(!rimosso) {  //se non lo trova lancia un'eccezione
            throw new IllegalArgumentException("Nessun id trovato: " + id);
        } else {  //messaggio di conferma che è stato eliminato correttamente
            System.out.println("Il gioco è stato eliminato correttamente (id) " +id);
        }
    }

    //Esercizio 6, aggiornamento di un elemento tramite ID, mi basta utilizzare la rimozioneGioco per quel id, e dopo aggiungere tramite metodo
    //non vado ad usare la rimozione gioco, perché lo ho gestito diversamente, ma vado a prendere lo stesso stream
    //in caso di successo quindi viene cancellato, con lo stesso id vado a crea anche un nuovo gioco, in questo modo si aggiorna
    //questa è la soluzione più veloce e più completa secondo il mio punto di vista.
    //l'unico difetto è che perde la posizione, ma non credo che sia un groppo problema, tanto cmq devono essere ordinati
    public void aggiornaGioco (long id, Gioco gioco) {
        boolean rimosso = giochi.removeIf(game -> game.getIdGioco() == id);
        System.out.println("\nEsercizio 6");
        if(!rimosso) {  //nel caso in cui non trova l'id
            throw new IllegalArgumentException("Id non trovato, non è possibile aggiornare il gioco: id: " + id);
        } else {
            gioco.setIdGioco(id); //qui gli andiamo a dare lo stesso id, nel caso in cui l'utente sbagliasse a mettere l'id quando inserisce il gioco da aggiornare
            aggiungiGioco(gioco);  //vado a richiamare il metodo aggiungi Gioco. Qui in realtà potevo fare anche direttamente .add
            System.out.println("Gioco aggiornato con successo");
        }
    }



}
