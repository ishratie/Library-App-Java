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
    private Kirja kirja;

    public void setKirjasto(KirjastoService kirjasto){
        this.kirjasto = kirjasto;
    }
    public void setKirja(Kirja kirja){
        this.kirja = kirja;
        nimiField.setText(kirja.getNimi());
        tekijaField.setText(kirja.getTekija());
        isbnField.setText(kirja.getIsbn());
    }
    @FXML
    private void tallenna() {
        if (!isItCorrect()) return;
        Kirja kirja = new Kirja(
                nimiField.getText(),
                tekijaField.getText(),
                isbnField.getText());
        kirjasto.lisaaKirja(kirja);
        sulje();
    }
    private boolean isItCorrect(){
        if (nimiField.getText().isBlank()) {
            virheLabel.setText("nimi on poissa");
            return false;
        }
        if (tekijaField.getText().isBlank()) {
            virheLabel.setText("tekijä on poissa");
            return false;
        }
        if (isbnField.getText().isBlank()){
            virheLabel.setText("isbn on poissa");
            return false;
        }
        virheLabel.setText("hell yeah");
        return true;
    }

    @FXML
    private void sulje() {
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
}