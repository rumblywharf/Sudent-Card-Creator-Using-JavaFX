/**
 *    imports all needed packages
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *    creates the main class to create the fxml file
 */
public class Main extends Application{

    /**
     *    runs the testing instance through my to string method and displays in the system console
     *    launches the fxml file
     */
    public static void main(String[] args) {
        //Student testing = new Student("cameron", "Thompson", 200425992, "something");
        //System.out.println(testing);
        launch(args);
    }

    /**
     *    calls the fxml file to load,
     *    creates my stage with the title student card,
     *    sets the stage,
     *    makes it visible
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CreateStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Create a Student Card");
        stage.setScene(scene);
        stage.show();
    }
}
