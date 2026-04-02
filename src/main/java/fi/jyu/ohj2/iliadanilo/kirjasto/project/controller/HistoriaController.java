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
// the controller of the history
public class HistoriaController {
    // fxml variables taken from fxml files to modify them
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
        // to initialize the functions
        // PropertyValueFactory convenience implementation of the Callback interface,
        // designed specifically for use within the TableColumn cell value factory.
        lainaajaKolumni.setCellValueFactory(new PropertyValueFactory<>("lainaajanimi"));
        lainattuKolumni.setCellValueFactory(new PropertyValueFactory<>("lainattuPvm"));
        palautusPvmKolumni.setCellValueFactory(new PropertyValueFactory<>("palautusPvm"));
        palautettuKolumni.setCellValueFactory(new PropertyValueFactory<>("palautettuPvm"));
        palautaBTN();
    }
    // true or false statment, a.k.a is the book is late or no
    private boolean isitmyohastynyt = false;
    //The method sets the internal isitmyohastynyt flag,
    // and if the new value is true, it changes the UI label text to “Myöhästyneet lainaukset”
    public void setMyohastyneet(boolean myohastyneet) {
        this.isitmyohastynyt = myohastyneet;
        if (myohastyneet) otsikkoLabel.setText("Myöhästyneet lainaukset");
    }
    //closes the window
    @FXML
    private void sulje() {
        Stage stage = (Stage) otsikkoLabel.getScene().getWindow();
        stage.close();
    }
    //making the refferenct from kirjastoService to use it to modify
    private KirjastoService kirjasto;
    // method ensures that as soon as kirjasto changes it will change too
    public void setKirjasto(KirjastoService kirjasto) {
        this.kirjasto = kirjasto;
        paivitaTaulu();
    }
    //function to update the library list
    private void paivitaTaulu() {
        if (kirjasto == null) return; // if no library method stops
        List<Lainaus> kirjat = new ArrayList<>(); // kirjat is list
        for (Kirja kirja : kirjasto.getKirjat()) { // loop to go through every book
            for (Lainaus lainaus : kirja.getLainaukset()) { // loop to go though every borrowing book
                if (isitmyohastynyt) { // statement if - is it late
                    if (lainaus.getPalautettuPvm() == null // if palautettupvm is none
                            && lainaus.getPalautusPvm() != null // if palautuspvm is not none
                            && LocalDate.now().isAfter(lainaus.getPalautusPvm())) { // it checks whether todays date is after the loans due date
                        kirjat.add(lainaus); // adds lainaus in kirjat list
                    }
                } else {
                    kirjat.add(lainaus); // else statement, add lainaus in kirjat list
                }
            }
        }
        historiaTablu.setItems(FXCollections.observableArrayList(kirjat)); // it updates the tables contents by giving it a new list of items.
    }

    // creating the button
    private void palautaBTN() {
        //is placed inside of the tablecell
        toiminnotKolumni.setCellFactory(col -> new TableCell<>() {
            private final Button palauta = new Button("Palauta"); // name of the button
            {
                palauta.setOnAction(e -> { // what the button does
                    Lainaus lainaus = getTableView().getItems().get(getIndex()); // find the loan
                    lainaus.setPalautettuPvm(LocalDate.now()); // mark the loan as returned today
                    kirjasto.tallenna(); // saves it
                    paivitaTaulu(); // updates the table
                    historiaTablu.refresh(); //updates the table of history
                });
            }

            @Override // replacing the parent method
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null); // if the cell in table is empty - remove button
                } else {
                    Lainaus lainaus = getTableView().getItems().get(getIndex());// get loan for this exact location/position
                    setGraphic(lainaus.getPalautettuPvm() == null ? palauta : null);
                    // show the button only if its not returned (button for returning)
                    // if button is already returned - no button
                }

            }
        });
    }
}
