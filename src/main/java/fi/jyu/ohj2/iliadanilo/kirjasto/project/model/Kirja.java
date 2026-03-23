package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

public class Kirja {
    private String nimi;
    private String tekija;
    private String isbn;

    public Kirja(String nimi, String tekija, String isbn) {
        this.nimi = nimi;
        this.tekija = tekija;
        this.isbn = isbn;
    }
    public String getNimi() {
        return nimi;
    }
    public String getTekija() {
        return tekija;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    public void setTekija(String tekija){
        this.tekija = tekija;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }


}
