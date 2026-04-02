package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LisaaKirjaController {
    // calling the names and values
    @FXML private TextField nimiField;
    @FXML private TextField tekijaField;
    @FXML private TextField isbnField;
    @FXML private Label virheLabel;

    private KirjastoService kirjasto; // calling the library
    private Kirja kirja; // calling the model book

    public void setKirjasto(KirjastoService kirjasto){
        this.kirjasto = kirjasto;
    } // setting up the library
    public void setKirja(Kirja kirja){ // what contains the library: book, name of the book, author, isbn number
        this.kirja = kirja;
        nimiField.setText(kirja.getNimi());
        tekijaField.setText(kirja.getTekija());
        isbnField.setText(kirja.getIsbn());
    }
    @FXML
    private void tallenna() { // function to save the book
        if (!isItCorrect()) return; // if smth is not correct - do not start the function
        Kirja kirja = new Kirja( // what book contains
                nimiField.getText(),
                tekijaField.getText(),
                isbnField.getText());
        kirjasto.lisaaKirja(kirja); // eding the book
        sulje(); // closing
    }
    private boolean isItCorrect(){ // the funcion to check is user wrote correctly new book to add it iside the table
        if (nimiField.getText().isBlank()) {
            virheLabel.setText("nimi on poissa");
            return false;
        } // is smth missing it will pop up for user to know
        if (tekijaField.getText().isBlank()) {
            virheLabel.setText("tekijä on poissa");
            return false;
        }
        if (isbnField.getText().isBlank()){
            virheLabel.setText("isbn on poissa");
            return false;
        }
        virheLabel.setText("hell yeah"); // if everything is alright we go
        return true; // positive flag aka 1
    }

    @FXML
    private void sulje() { // closing up this show
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
}