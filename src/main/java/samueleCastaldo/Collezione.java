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
        for(Gioco g : giochi) {   //vado a fare il controllo, quindi devo ciclare tutta la lista giochi
            if(g.getIdGioco() == gioco.getIdGioco()) { //controllo id se sono uguali
                throw new IllegalArgumentException("Questo id esite già: " + gioco.getIdGioco()); //eccezione, esce dal metodo
            }
        }
        giochi.add(gioco);  //aggiunge il gioco alla lista
    }









}
