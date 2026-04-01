package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Lainaus;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoriaController {
    @FXML private Label otsikkoLabel;
    @FXML private TableView<Lainaus> historiaTablu;
    @FXML private TableColumn<Lainaus, String> lainaajaKolumni;
    @FXML private TableColumn<Lainaus, LocalDate> lainattuKolumni;
    @FXML private TableColumn<Lainaus, LocalDate> palautusPvmKolumni;
    @FXML private TableColumn<Lainaus, LocalDate> palautettuKolumni;
    @FXML private TableColumn<Lainaus, Void> toiminnotKolumni;
    @FXML
    private void sulje(){
        Stage stage = (Stage) otsikkoLabel.getScene().getWindow();
        stage.close();
    }
    private KirjastoService kirjasto;

    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
        paivitaTaulu();
    }
    private void paivitaTaulu() {
        List<Lainaus> kirjat = new ArrayList<>();
        for (Kirja kirja : kirjasto.getKirjat()) {
            kirjat.addAll(kirja.getLainaukset());
        }
        historiaTablu.setItems(FXCollections.observableArrayList(kirjat));
    }
    @FXML
    public void initialize() {
        lainaajaKolumni.setCellValueFactory(new PropertyValueFactory<>("lainaajanimi"));
        lainattuKolumni.setCellValueFactory(new PropertyValueFactory<>("lainattuPvm"));
        palautusPvmKolumni.setCellValueFactory(new PropertyValueFactory<>("palautusPvm"));
        palautettuKolumni.setCellValueFactory(new PropertyValueFactory<>("palautettuPvm"));
    }
}
