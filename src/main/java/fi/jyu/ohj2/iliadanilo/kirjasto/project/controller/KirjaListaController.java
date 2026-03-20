package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;

import java.security.spec.ECField;


public class KirjaListaController {
    @FXML
    private void avaaLisaaKirja(){
        avaaPopup("/fi/jyu/ohj2/iliadanilo/kirjasto/project/lisaakirja.fxml", "Lisää kirja");
    }
    @FXML
    private void avaaMyohastyneet() {
        avaaPopup("/fi/jyu/ohj2/iliadanilo/kirjasto/project/historia.fxml", "Myöhastyneet");
    }

    private void avaaPopup(String fxmlPolku, String otsikko){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPolku));
            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle(otsikko);
            popup.setScene(new Scene(loader.load()));
            popup.showAndWait();
        } catch (Exception w){
            System.out.println("Wirhe avamaan" + w.getMessage());
        }
    }
}
