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







}
