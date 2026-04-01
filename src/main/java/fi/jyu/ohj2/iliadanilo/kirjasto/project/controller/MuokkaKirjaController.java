package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MuokkaKirjaController {

    @FXML private TextField nimiField;
    @FXML private TextField tekijaField;
    @FXML private TextField isbnField;
    @FXML private Label virheLabel;

    private KirjastoService kirjasto;
    private Kirja kirja;
    @FXML
    private void sulje(){
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
    public void setKirja(Kirja kirja){
        this.kirja = kirja;
        nimiField.setText(kirja.getNimi());
        tekijaField.setText(kirja.getTekija());
        isbnField.setText(kirja.getIsbn());
    }
    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
    }
    @FXML
    private void tallenna(){
        if (!isItCorrect()) return;
        kirja.setNimi(nimiField.getText());
        kirja.setTekija(tekijaField.getText());
        kirja.setIsbn(isbnField.getText());
        System.out.println("talenna kutsuttu");
        kirjasto.tallenna();
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



}
