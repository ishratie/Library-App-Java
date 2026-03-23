package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class LisaaKirjaController {

    @FXML private TextField nimiField;
    @FXML private TextField tekijaField;
    @FXML private TextField isbnField;
    @FXML private Label virheLabel;

    private KirjastoService kirjasto;
    public void setKirjasto(KirjastoService kirjasto){
        this.kirjasto = kirjasto;
    }
    @FXML
    private void tallenna() {
        Kirja kirja = new Kirja(nimiField.getText(), tekijaField.getText(),isbnField.getText());
        kirjasto.lisaaKirja(kirja);
        sulje();
    }

    @FXML
    private void sulje() {
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
}