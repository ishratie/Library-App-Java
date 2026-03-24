package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class KirjaListaController {
    @FXML private TableView<Kirja> kirjaTablu;
    @FXML private TableColumn<Kirja, String> nimiKolumni;
    @FXML private TableColumn<Kirja, String> tekijaKolumni;
    @FXML private TableColumn<Kirja, String> isbnKolumni;



    private KirjastoService kirjasto = new KirjastoService();

    @FXML
    public void initialize() {
        nimiKolumni.setCellValueFactory(new PropertyValueFactory<>("nimi"));
        tekijaKolumni.setCellValueFactory(new PropertyValueFactory<>("tekija"));
        isbnKolumni.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        kirjaTablu.setItems(kirjasto.getKirjat());
        DeleteEditButton();

    }
    @FXML
    private void avaaLisaaKirja() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/lisaakirja.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Lisää kirja");
            popup.setScene(new Scene(loader.load()));
            LisaaKirjaController lisaaKirjaController = loader.getController();
            lisaaKirjaController.setKirjasto(kirjasto);
            popup.showAndWait();
        } catch (Exception w) {
            System.out.println("avaaLisaaKirja ikuna ei toimi" + w.getMessage());
        }
    }
    @FXML
    private void avaaMyohastyneet() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/historia.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Myohastyneet");
            popup.setScene(new Scene(loader.load()));
            popup.showAndWait();
        } catch (Exception w) {
            System.out.println("avaaMyohastyneet ikuna ei toimi" + w.getMessage());
        }
    }
    @FXML
    private void avaaEdit(Kirja kirja){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/fi/jyu/ohj2/iliadanilo/kirjasto/project/muokkaakirja.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Muokka kirjaa");
            popup.setScene(new Scene(loader.load()));
            MuokkaKirjaController muokkaKirjaController = loader.getController();
            muokkaKirjaController.setKirja(kirja);
            muokkaKirjaController.setKirjasto(kirjasto);
            popup.showAndWait();
            kirjaTablu.refresh();
        } catch (Exception w) {
            System.out.print("edit not working" + w.getMessage());
        }
    }


    @FXML private TableColumn<Kirja, Void> toiminnotKolumni;

    private void DeleteEditButton(){
        toiminnotKolumni.setCellFactory(column -> new TableCell<>() {
            private final Button poista = new Button("Poista");
            private final Button edit = new Button("Edit");
            {
                poista.setOnAction(w -> {
                    Kirja kirja = getTableView().getItems().get(getIndex());
                    kirjasto.poistaKirja(kirja);
                });
                edit.setOnAction(w -> {
                    Kirja kirja = getTableView().getItems().get(getIndex());
                    avaaEdit(kirja);
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(5, poista, edit);
                    setGraphic(box);
                }
            }

        });
    }

    public void tallenna() {
        kirjasto.tallenna();
    }
}
