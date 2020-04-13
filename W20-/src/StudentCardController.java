/**
 *    imports all needed packages
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *    creates the controller class to implement into my fxml file
 */
public class StudentCardController implements Initializable {

    /**
     *    all variables being used
     */
    @FXML
    public Label firstNameLabel;
    @FXML
    public Label lastNameLabel;
    @FXML
    public Label studentNumberLabel;
    @FXML
    public TextArea favouriteActivitiesTextArea;
    @FXML
    public Label birthdayLabel;
    @FXML
    public ImageView image;
    @FXML
    public Button createNewStudentButton;
    @FXML
    public ListView<Student> studentListView;
    private Student selectedStudent;

    /**
     *    creates an empty initializable method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Fills the labels, images and textareas with the selected students information that was just created
     * @param student
     */
    public void selectedStudent(Student student){
        selectedStudent = student;
        studentListView.getItems().addAll(Main.getStudents());
        firstNameLabel.setText(selectedStudent.getFirstName());
        lastNameLabel.setText(selectedStudent.getLastName());
        studentNumberLabel.setText(Integer.toString(selectedStudent.getStudentNumber()));
        favouriteActivitiesTextArea.setText(String.valueOf(selectedStudent.getInterests()));
        birthdayLabel.setText(Integer.toString(selectedStudent.getBirthday()));
        image.setImage(selectedStudent.getImage());
    }

    /**
     * when the create a new student button is clicked go back to the create student fxml file
     * @param event
     * @throws IOException
     */
    public void goBackCreateStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateStudent.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Create a New Student Card");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * depending on which student is selected in the list, it shows the current students information that is selected
     */
    public void selectListView() {
        selectedStudent = studentListView.getSelectionModel().getSelectedItem();
        firstNameLabel.setText(selectedStudent.getFirstName());
        lastNameLabel.setText(selectedStudent.getLastName());
        studentNumberLabel.setText(Integer.toString(selectedStudent.getStudentNumber()));
        favouriteActivitiesTextArea.setText(String.valueOf(selectedStudent.getInterests()).substring(1, String.valueOf(selectedStudent.getInterests()).length() - 1));
        birthdayLabel.setText(Integer.toString(selectedStudent.getBirthday()));
        image.setImage(selectedStudent.getImage());
    }
}
