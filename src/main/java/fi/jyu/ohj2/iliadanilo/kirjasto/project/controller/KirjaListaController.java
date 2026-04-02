package fi.jyu.ohj2.iliadanilo.kirjasto.project.controller;
// the importing of the external libraries, if no imports - code wont work, for example what the fxml, computer doesnt know.
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



// the controller of the main menu
public class KirjaListaController {
    @FXML private TableView<Kirja> kirjaTablu;
    @FXML private TableColumn<Kirja, String> nimiKolumni;
    @FXML private TableColumn<Kirja, String> tekijaKolumni;
    @FXML private TableColumn<Kirja, String> isbnKolumni;
    @FXML private TableColumn<Kirja, String> tilanneKolumni;
    @FXML private TableColumn<Kirja, Integer> lainattuKolumni;
    // the valuables to use it to modify

    //calling the kirjastoservice to use it
    private KirjastoService kirjasto = new KirjastoService();

    @FXML
    // the initialize function to make functions work
    public void initialize() {
        nimiKolumni.setCellValueFactory(new PropertyValueFactory<>("nimi"));
        tekijaKolumni.setCellValueFactory(new PropertyValueFactory<>("tekija"));
        isbnKolumni.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        kirjaTablu.setItems(kirjasto.getKirjat());
        DeleteEditButton();
        tilanneKolumni.setCellValueFactory(new PropertyValueFactory<>("tilanne"));
        lainattuKolumni.setCellValueFactory(new PropertyValueFactory<>("lainauksetNmr"));
    }
    @FXML
    // method to call function
    private void avaaLisaaKirja() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/lisaakirja.fxml"));// the location of the ui
            Stage popup = new Stage(); // stage to show
            popup.setTitle("Lisää kirja"); // name of window
            popup.setScene(new Scene(loader.load())); // the scene loader
            LisaaKirjaController lisaaKirjaController = loader.getController(); //yt retrieves the controller object associated with the FXML file
            lisaaKirjaController.setKirjasto(kirjasto); //passes the kirjasto to the controller of the addbook function
            popup.showAndWait(); // show the window
        } catch (Exception w) {
            System.out.println("avaaLisaaKirja ikuna ei toimi" + w.getMessage()); // if smth went wrong - it show this
        }
    }
    @FXML
    private void avaaMyohastyneet() {
        try { // basically the same as previous method, only changes the location of ui and names
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/historia.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Myohastyneet");
            popup.setScene(new Scene(loader.load()));
            HistoriaController controller = loader.getController();
            controller.setMyohastyneet(true); // show only overdue books
            controller.setKirjasto(kirjasto);
            popup.showAndWait();
        } catch (Exception w) {
            System.out.println("avaaMyohastyneet ikuna ei toimi" + w.getMessage());
        }
    }
    @FXML
    private void avaaEdit(Kirja kirja){
        try { // basically the same as previous method, only changes the location of ui and names
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/fi/jyu/ohj2/iliadanilo/kirjasto/project/muokkaakirja.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Muokka kirjaa");
            popup.setScene(new Scene(loader.load()));
            MuokkaKirjaController muokkaKirjaController = loader.getController();
            muokkaKirjaController.setKirja(kirja);
            muokkaKirjaController.setKirjasto(kirjasto); // it gives the control of the library
            popup.showAndWait();
            kirjaTablu.refresh(); // refresh the information
        } catch (Exception w) {
            System.out.print("edit not working" + w.getMessage());
        }
    }

    private void avaaLainaus(Kirja kirja) {

        if (kirja == null || kirja.getTilanne().equals("Lainassa")) return; // of book's valur in none or book is borrowed - do nothing
        try { // basically the same as previous method, only changes the location of ui and names
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/lainaus.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Lainaukset");
            popup.setScene(new Scene(loader.load()));
            LainausController controller = loader.getController();
            controller.setKirja(kirja);
            controller.setKirjasto(kirjasto);
            popup.showAndWait();
            kirjaTablu.refresh();
        } catch (Exception w) {
            System.out.println("avaaLainaus ikuna ei toimi" + w.getMessage());
        }
    }
    @FXML
    private void avaaHistoria() {
        try { // basically the same as previous method, only changes the location of ui and names
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/historia.fxml"));
            Stage popup = new Stage();
            popup.setTitle("Historia");
            popup.setScene(new Scene(loader.load()));
            HistoriaController controller = loader.getController();
            controller.setKirjasto(kirjasto);
            popup.showAndWait();
        } catch (Exception w) {
            System.out.println("avaaMyohastyneet ikuna ei toimi" + w.getMessage());
        }
    }


    @FXML private TableColumn<Kirja, Void> toiminnotKolumni; // coll the column of the table
// creating the buttoms and what they do
    private void DeleteEditButton(){
        toiminnotKolumni.setCellFactory(column -> new TableCell<>() { // making cell to show the buttoms
            private final Button poista = new Button("Poista"); // names of button
            private final Button edit = new Button("Edit");
            private final Button lainata = new Button("Lainata");
            {
                poista.setOnAction(w -> { // actionevent when the button is pressed
                    Kirja kirja = getTableView().getItems().get(getIndex()); // what the botton does to this exactly cell
                    kirjasto.poistaKirja(kirja); // in this case, deleting
                });
                edit.setOnAction(w -> { // actionevent when the button is pressed
                    Kirja kirja = getTableView().getItems().get(getIndex()); // what the botton does to this exactly cell
                    avaaEdit(kirja); // in this case, editing
                });
                lainata.setOnAction(w -> { // actionevent when the button is pressed
                    Kirja kirja = getTableView().getItems().get(getIndex()); // what the botton does to this exactly cell
                    avaaLainaus(kirja); // in this case, borrowing
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(5, poista, edit, lainata);
                    setGraphic(box);
                }
            }
            //updateItem decides what each cell in the column should display whenever the table refreshes, scrolls, or updates.
            //the cell contains three buttons:
            //poista (delete), edit, and lainata (loan).

        });
    }

    public void tallenna() {
        kirjasto.tallenna();
    } // saves it all
}
