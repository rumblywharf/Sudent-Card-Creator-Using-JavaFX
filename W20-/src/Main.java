/**
 *    imports all needed packages
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 *    creates the main class to create the fxml file
 */
public class Main extends Application{
    /**
     * Creates an arraylist of students that have been created
     */
    private static ArrayList<Student> students;

    /**
     *    creates a new arraylist to be used
     *    launches the fxml file
     */
    public static void main(String[] args) {
        students = new ArrayList<>();
        launch(args);
    }

    /**
     * creates a get method to retrieve the arraylist
     * @return
     */
    public static ArrayList<Student> getStudents() {
        return students;
    }

    /**
     *    calls the fxml file to load,
     *    creates my stage with the title to create a student card,
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
