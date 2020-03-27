/**
 *    imports all needed packages
 */
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
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
    public Label firstNameLabel;
    public Label lastNameLabel;
    public Label studentNumberLabel;
    public TextArea favouriteActivitiesTextArea;
    public ImageView image;
    private ArrayList<String> activities = new ArrayList<String>();

    /**
     *    creates an instance of my student card to display in the fxml
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Student testing = new Student("cameron", "Thompson", 200425992, "");
        //firstNameLabel.setText(String.valueOf(testing.getFirstName()));
        //lastNameLabel.setText(String.valueOf(testing.getLastName()));
        //studentNumberLabel.setText(String.valueOf(testing.getStudentNumber()));
        //image.setImage(testing.getImage());
        favouriteActivities();
    }

    /**
     *    Creates an array list for your favourite activities and throws it into the text area
     */
    private void favouriteActivities(){
        activities.add("Coding");
        activities.add("Video Games");
        activities.add("Skiing");
        activities.add("Reading Comic Books");
        activities.add("Rubix Cube Solving");
        activities.add("Driving");
        activities.add("Listening to Music ");

        /**
         *         found these next two lines of code on stack overflow
         *         the code takes the arraylist and displays it vertically
         *         without the square brakes and commas.
         *         URL: https://stackoverflow.com/questions/30222157/displaying-arrayliststring-in-jtextarea/30222259
         */
        for(String a: activities)
            favouriteActivitiesTextArea.appendText(a + "\n");
    }

}
