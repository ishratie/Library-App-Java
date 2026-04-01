package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Lainaus;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoriaController {
    @FXML
    private Label otsikkoLabel;
    @FXML
    private TableView<Lainaus> historiaTablu;
    @FXML
    private TableColumn<Lainaus, String> lainaajaKolumni;
    @FXML
    private TableColumn<Lainaus, LocalDate> lainattuKolumni;
    @FXML
    private TableColumn<Lainaus, LocalDate> palautusPvmKolumni;
    @FXML
    private TableColumn<Lainaus, LocalDate> palautettuKolumni;
    @FXML
    private TableColumn<Lainaus, Void> toiminnotKolumni;

    @FXML
    public void initialize() {
        lainaajaKolumni.setCellValueFactory(new PropertyValueFactory<>("lainaajanimi"));
        lainattuKolumni.setCellValueFactory(new PropertyValueFactory<>("lainattuPvm"));
        palautusPvmKolumni.setCellValueFactory(new PropertyValueFactory<>("palautusPvm"));
        palautettuKolumni.setCellValueFactory(new PropertyValueFactory<>("palautettuPvm"));
        palautaBTN();
    }

    private boolean isitmyohastynyt = false;

    public void setMyohastyneet(boolean myohastyneet) {
        this.isitmyohastynyt = myohastyneet;
        if (myohastyneet) otsikkoLabel.setText("Myöhästyneet lainaukset");
    }

    @FXML
    private void sulje() {
        Stage stage = (Stage) otsikkoLabel.getScene().getWindow();
        stage.close();
    }

    private KirjastoService kirjasto;

    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
        paivitaTaulu();
    }

    private void paivitaTaulu() {
        if (kirjasto == null) return;
        List<Lainaus> kirjat = new ArrayList<>();
        for (Kirja kirja : kirjasto.getKirjat()) {
            for (Lainaus lainaus : kirja.getLainaukset()) {
                if (isitmyohastynyt) {
                    if (lainaus.getPalautettuPvm() == null
                            && lainaus.getPalautusPvm() != null
                            && LocalDate.now().isAfter(lainaus.getPalautusPvm())) {
                        kirjat.add(lainaus);
                    }
                } else {
                    kirjat.add(lainaus);
                }
            }
        }
        historiaTablu.setItems(FXCollections.observableArrayList(kirjat));
    }


    private void palautaBTN() {
        toiminnotKolumni.setCellFactory(col -> new TableCell<>() {
            private final Button palauta = new Button("Palauta");

            {
                palauta.setOnAction(e -> {
                    Lainaus lainaus = getTableView().getItems().get(getIndex());
                    lainaus.setPalautettuPvm(LocalDate.now());
                    kirjasto.tallenna();
                    paivitaTaulu();
                    historiaTablu.refresh();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Lainaus lainaus = getTableView().getItems().get(getIndex());
                    setGraphic(lainaus.getPalautettuPvm() == null ? palauta : null);
                }

            }
        });
    }
}
