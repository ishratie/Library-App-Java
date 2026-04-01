package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import java.util.ArrayList;
import java.util.List;

public class Kirja {
    private String nimi;
    private String tekija;
    private String isbn;

    public Kirja(){}
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
    private ArrayList<Lainaus> lainaukset = new ArrayList<>();
    public List<Lainaus> getLainaukset() {
        return lainaukset;
    }
    public void lisaaLainaus(Lainaus lainaus){
        lainaukset.add(lainaus);
    }

    public String getTilanne() {
        for(Lainaus lainas : lainaukset) {
            if (lainas.getPalautettuPvm() == null)
                return "Lainassa";
        }
        return "Saatavilla";
    }
    public int getLainauksetNmr() {
        return lainaukset.size();
    }


}
