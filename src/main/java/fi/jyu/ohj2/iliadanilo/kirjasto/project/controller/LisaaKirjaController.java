package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class LisaaKirjaController {

    @FXML private TextField nimiField;
    @FXML private TextField tekijaField;
    @FXML private TextField isbnField;
    @FXML private Label virheLabel;

    @FXML
    private void tallenna() {
        System.out.println("tallenna kutsuttu");
    }

    @FXML
    private void sulje() {
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
}