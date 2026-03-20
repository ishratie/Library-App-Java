package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
public class HistoriaController {
    @FXML private Label otsikkoLabel;
    @FXML private TableView historiaTablu;
    @FXML private TableColumn lainaajaKolumni;
    @FXML private TableColumn lainattuKolumni;
    @FXML private TableColumn palautusPvmKolumni;
    @FXML private TableColumn palautettuKolumni;
    @FXML private TableColumn toiminnotKolumni;
    @FXML
    private void sulje(){
        Stage stage = (Stage) otsikkoLabel.getScene().getWindow();
        stage.close();
    }
}
