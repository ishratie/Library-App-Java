package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class LainausController {
    @FXML private TextField lainaajaField;
    @FXML private DatePicker palautusPvmPicker;
    @FXML private Label virheLabel;
    @FXML
    public void lainaa(){
        System.out.println("lainaa kutsuttu");
    }
    @FXML
    public void sulje(){
        Stage stage = (Stage) lainaajaField.getScene().getWindow();
        stage.close();
    }
}

