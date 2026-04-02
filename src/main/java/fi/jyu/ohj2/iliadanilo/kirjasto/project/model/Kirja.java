package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import java.util.ArrayList;
import java.util.List;
// model of book
public class Kirja {
    private String nimi;
    private String tekija;
    private String isbn;
// the strings are created
    public Kirja(){} // creating empty constructor
    public Kirja(String nimi, String tekija, String isbn) { // putting the names n values inside the constructor
        this.nimi = nimi;
        this.tekija = tekija;
        this.isbn = isbn;
    }
    public String getNimi() {
        return nimi;
    } // get name
    public String getTekija() {
        return tekija;
    } // get author
    public String getIsbn() {
        return isbn;
    } // get num

    public void setNimi(String nimi){
        this.nimi = nimi;
    } // setting the name, author and num
    public void setTekija(String tekija){
        this.tekija = tekija;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    private ArrayList<Lainaus> lainaukset = new ArrayList<>(); // making lainaukset list
    public List<Lainaus> getLainaukset() {
        return lainaukset;
    } // get launaukset list
    public void lisaaLainaus(Lainaus lainaus){
        lainaukset.add(lainaus);
    } // adds launaus to the lainaukset

    public String getTilanne() { // shows the situation of the laina
        for(Lainaus lainas: lainaukset) { // for loop to scan lainas in the list lainaukset
            if (lainas.getPalautettuPvm() == null) // if lainas's return date is none - return lainassa
                return "Lainassa";
        }
        return "Saatavilla"; // in other cases return available
    }
    public int getLainauksetNmr() {
        return lainaukset.size();
    } // function to return the size of list of lainaukset.


}
