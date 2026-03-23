package fi.jyu.ohj2.iliadanilo.kirjasto.project.service;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KirjastoService {
    private final ObservableList<Kirja> kirjat = FXCollections.observableArrayList();
    public ObservableList<Kirja> getKirjat() {
        return kirjat;
    }
    public void lisaaKirja(Kirja kirja) {
        kirjat.add(kirja);
    }
}
