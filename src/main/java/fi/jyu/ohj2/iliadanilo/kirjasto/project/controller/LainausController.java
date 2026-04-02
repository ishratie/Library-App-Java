package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Lainaus;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
// the borriwing controller
public class LainausController { // the calling the values/ the variables to modify them
    @FXML private TextField lainaajaField;
    @FXML private DatePicker palautusPvmPicker;
    @FXML private Label virheLabel;
    private KirjastoService kirjasto;
    // the set functions , to make sure that if we use variable library its library which we have created, not new one
    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
    }
    private Kirja kirja; // calling the string privately inside this class
    public void setKirja(Kirja kirja){
        this.kirja = kirja;
    }
    @FXML
    public void lainaa(){ // borrowing functiong
        if (lainaajaField.getText().isEmpty() || palautusPvmPicker.getValue() == null) {
            // so if the smth is missig in the blank of borrowing it will stop the execution of the function
            virheLabel.setText("some field is empty"); // is smth is missing will be text
            return; // returning the output - the book is borrowed in the system
        }
        if (kirjasto != null) kirjasto.tallenna(); // savng the data if kirjasto object exists
        Lainaus lainaus = new Lainaus( // creates the loan object which contains name, date, returning date of the book and the book
                lainaajaField.getText(),
                LocalDate.now(),
                null,
                palautusPvmPicker.getValue(),
                kirja
        );
        System.out.println("lainaa kutsuttu"); // prints in cmd what the function called
        kirja.lisaaLainaus(lainaus); // adding the book
        sulje(); // closes the window
    }
    @FXML
    public void sulje(){ // closes the window
        Stage stage = (Stage) lainaajaField.getScene().getWindow();
        stage.close();
    }
}

