package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
// the conroller of eding and its validation
public class MuokkaKirjaController {

    @FXML private TextField nimiField;
    @FXML private TextField tekijaField;
    @FXML private TextField isbnField;
    @FXML private Label virheLabel;
    // calling the names and variables
    private KirjastoService kirjasto;
    private Kirja kirja;
    @FXML
    private void sulje(){ // function to close the stage
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
    public void setKirja(Kirja kirja){ // setting up the book, which gets the book, name, author, number
        this.kirja = kirja;
        nimiField.setText(kirja.getNimi());
        tekijaField.setText(kirja.getTekija());
        isbnField.setText(kirja.getIsbn());
    }
    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
    } // setting up the library service to use it lately
    @FXML
    private void tallenna(){ // the save function - to save the book and information about it
        if (!isItCorrect()) return; // if smth missing - do not start the function
        kirja.setNimi(nimiField.getText()); // name
        kirja.setTekija(tekijaField.getText()); // author
        kirja.setIsbn(isbnField.getText()); // number
        System.out.println("talenna kutsuttu"); // prints in cmd that book is saved
        kirjasto.tallenna(); // saves it
        sulje(); // closes it
    }
    private boolean isItCorrect(){
        if (nimiField.getText().isBlank()) {
            virheLabel.setText("nimi on poissa");
            return false; // if name is missing - no saving the book
        }
        if (tekijaField.getText().isBlank()) {
            virheLabel.setText("tekijä on poissa");
            return false;// if author is missing - no saving the book
        }
        if (isbnField.getText().isBlank()){
            virheLabel.setText("isbn on poissa");
            return false; // if num is missing - no saving the book
        }
        virheLabel.setText("hell yeah");
        return true; // everything is okay  - saves it
    }



}
