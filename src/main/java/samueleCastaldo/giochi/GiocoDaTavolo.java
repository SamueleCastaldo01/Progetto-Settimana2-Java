package samueleCastaldo.giochi;

public class GiocoDaTavolo extends  Gioco{
    private int numeroDiGiocatori;
    private static final int MIN_GIOCATORI = 2;  //è una costate, e le variabili per convezione vengono scritte in maiuscolo
    private static final int MAX_GIOCATORI = 10;
    private int durataMediaPartita;  //in minuti

    public GiocoDaTavolo(long idGioco, String titolo, String annoDiProduzione, double prezzo, int numeroDiGiocatori, int durataMediaPartita) {
        super(idGioco, titolo, annoDiProduzione, prezzo);
        setNumeroGiocatori(numeroDiGiocatori);  //viene inserito tramite il set, in modo tale da poter fare il controllo
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroDiGiocatori() {
        return numeroDiGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        if (numeroGiocatori >= MIN_GIOCATORI && numeroGiocatori <= MAX_GIOCATORI) { //se è compreso allora lo inserisci
            this.numeroDiGiocatori = numeroGiocatori;
        } else {
            throw new IllegalArgumentException("Il numero di giocatori deve essere compreso tra " + MIN_GIOCATORI + " e " + MAX_GIOCATORI);
        }
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numeroDiGiocatori=" + numeroDiGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}
