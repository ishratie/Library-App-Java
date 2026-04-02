package fi.jyu.ohj2.iliadanilo.kirjasto.project.service;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
// the library service, the engine under the hood
public class KirjastoService {
    private final TallennusService tallennus = new TallennusService(); // calling the save service
    private final ObservableList<Kirja> kirjat = FXCollections.observableArrayList();
    // making books teh observablearraylist, the observable list listens the changes and change in procce, while arraylist is fixed
    public ObservableList<Kirja> getKirjat() {
        return kirjat;
    } // make kirjat get and return content of the observablelist
    public KirjastoService() {
        kirjat.addAll(tallennus.loading());
    } //it loads all saved books from storage
    public void lisaaKirja(Kirja kirja) {
        kirjat.add(kirja);
    } //adds a new book object to the library
    public void poistaKirja(Kirja kirja) { // deletes the book
        kirja.getLainaukset().clear();
        kirjat.remove(kirja);
    }
    public void tallenna() {
        tallennus.tallenna(kirjat);
    } // saves the book
}
