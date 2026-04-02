package fi.jyu.ohj2.iliadanilo.kirjasto.project;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.controller.KirjaListaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application { // extending the application because fxml requires it
    @Override // entry point of javafx ui
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/kirjalista.fxml")); //loading ui from java ui
        Scene scene = new Scene(loader.load()); // setting scene
        stage.setTitle("Kirjasto Manager"); // name of the window
        stage.setScene(scene); // stage
        KirjaListaController controller  = loader.getController(); // references to the controller that manages the main list book
        stage.setOnCloseRequest(w -> controller.tallenna()); //javafx triggers the event and controller saves the data to .json
        stage.show(); // shows it
    }

    public static void main(String[] args) {
        launch(args);
    } // launch it
}
