package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Lainaus;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class LainausController {
    @FXML private TextField lainaajaField;
    @FXML private DatePicker palautusPvmPicker;
    @FXML private Label virheLabel;

    private Kirja kirja;
    public void setKirja(Kirja kirja){
        this.kirja = kirja;
    }
    @FXML
    public void lainaa(){
        if (lainaajaField.getText().isEmpty() || palautusPvmPicker.getValue() == null) {
            virheLabel.setText("some field is empty");
            return;
        }
        Lainaus lainaus = new Lainaus(
                lainaajaField.getText(),
                LocalDate.now(),
                null,
                palautusPvmPicker.getValue(),
                kirja
        );
        System.out.println("lainaa kutsuttu");
        kirja.lisaaLainaus(lainaus);
        sulje();
    }
    @FXML
    public void sulje(){
        Stage stage = (Stage) lainaajaField.getScene().getWindow();
        stage.close();
    }
}

