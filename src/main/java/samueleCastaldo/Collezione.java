package samueleCastaldo;

import samueleCastaldo.giochi.Gioco;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> giochi;

    public Collezione() {
        this.giochi = new ArrayList<>(); //in questo modo andiamo a creare una lista vuota
    }

    //Esercizio1 aggiungi gioco l'elemento Id deve essere univoco, quindi devo fare il controllo, prima di inserirlo
    public void aggiungiGioco (Gioco gioco) {
        boolean idEsistente = giochi.stream().anyMatch(game -> game.getIdGioco() == gioco.getIdGioco());
        if(idEsistente) {
            throw new IllegalArgumentException("questo id esiste già: " + gioco.getIdGioco());
        } else {
            giochi.add(gioco);  //aggiunge il gioco alla lista
        }

    }

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


    //Esercizio 3 ricerca per prezzo, deve ritornare una lista di giochi con prezzo inferiore al prezzo inserito
    public List<Gioco> ricercaPrezzoInferiore (double prezzo) {
        List<Gioco> risultati = giochi.stream().filter(game -> game.getPrezzo() < prezzo).toList();
        if(!risultati.isEmpty()) {  //controllo tramite se la lista è vuota o meno, stesso controllo di sopra
            return risultati;
        } else {  //Se la lista è vuota allora abbiamo l'eccezione
            throw new IllegalArgumentException("Non esiste un gioco con il prezzo inferiore a: " +prezzo);
        }
    }





}
