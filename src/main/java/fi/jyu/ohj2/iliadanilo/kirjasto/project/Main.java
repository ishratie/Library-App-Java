package fi.jyu.ohj2.iliadanilo.kirjasto.project;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.controller.KirjaListaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/jyu/ohj2/iliadanilo/kirjasto/project/kirjalista.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Kirjasto Manager");
        stage.setScene(scene);
        KirjaListaController controller  = loader.getController();
        stage.setOnCloseRequest(w -> controller.tallenna());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
