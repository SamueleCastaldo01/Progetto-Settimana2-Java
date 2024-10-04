package samueleCastaldo.giochi;

public abstract class Gioco {
    private long idGioco;
    private String titolo;
    private String annoDiPubblicazione;
    private double prezzo;

    public Gioco(long idGioco, String titolo, String annoDiProduzione, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiProduzione;
        this.prezzo = prezzo;
    }

    public long getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setIdGioco(long idGioco) {
        this.idGioco = idGioco;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoDiPubblicazione(String annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
