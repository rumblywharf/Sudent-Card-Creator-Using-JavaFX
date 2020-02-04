import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{

    public static void main(String[] args) {
        Student testing = new Student("cameron", "Thompson", 200425992);
        System.out.println(testing);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Student_Card.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student Card");
        stage.setScene(scene);
        stage.show();
    }
}
