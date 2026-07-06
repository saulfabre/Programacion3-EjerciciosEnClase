import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(getClass().getResource("/styles/estilos.css").toExternalForm());

        stage.setScene(scene);

        stage.setTitle("Generador de Contraseñas");

        stage.show();
    }
}
