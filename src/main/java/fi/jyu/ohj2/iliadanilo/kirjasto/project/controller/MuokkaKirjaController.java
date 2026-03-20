package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
public class MuokkaKirjaController {
    @FXML private TextField nimiField;
    @FXML private TextField tekijaField;
    @FXML private TextField isbnField;
    @FXML private Label virheLabel;
    @FXML
    private void talenna(){
        System.out.println("talenna kutsuttu");
    }
    @FXML
    private void sulje(){
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }

}
