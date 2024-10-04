package samueleCastaldo.giochi;

public class Videogioco  extends Gioco{
    private String piattaforma;
    private int durataDiGioco;

    public enum Genere {
        AZIONE,
        AVVENTURA,
        GDR,
        SPARATUTTO,
        STRATEGIA,
        SPORT,
        CORSE,
        SIMULAZIONE,
        HORROR,
        PUZZLE,
        PLATFORM
    }
    private Genere genere;


    public Videogioco(long idGioco, String titolo, String annoDiProduzione, double prezzo, String piattaforma, int durataDiGioco, Genere genere) {
        super(idGioco, titolo, annoDiProduzione, prezzo);
        this.piattaforma = piattaforma;
        this.durataDiGioco = durataDiGioco;
        this.genere = genere;
    }

    //metodi get----------------------------------------------------
    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataDiGioco() {
        return durataDiGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    //metodi set--------------------------------------------------------
    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public void setDurataDiGioco(int durataDiGioco) {
        this.durataDiGioco = durataDiGioco;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
