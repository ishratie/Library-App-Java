package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.event.ActionEvent;
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
    private void tallenna(){
        kirja.setNimi(nimiField.getText());
        nimiField.setText(kirja.getNimi());
        tekijaField.setText(kirja.getTekija());
        isbnField.setText(kirja.getIsbn());
        System.out.println("talenna kutsuttu");
        sulje();
    }
    @FXML
    private void sulje(){
        Stage stage = (Stage) nimiField.getScene().getWindow();
        stage.close();
    }
    private Kirja kirja;
    private KirjastoService kirjasto;
    public void setKirja(Kirja kirja){
        this.kirja = kirja;
        nimiField.setText(kirja.getNimi());
        tekijaField.setText(kirja.getTekija());
        isbnField.setText(kirja.getIsbn());
    }
    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
    }
}
