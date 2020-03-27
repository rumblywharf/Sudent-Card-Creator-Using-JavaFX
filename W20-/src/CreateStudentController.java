import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {
    public Label errorLabel;
    public TextField firstNameTextfield;
    public TextField lastNameTextfield;
    public TextField studentNumberTextfield;
    public Button submitButton;
    public CheckBox codingCheckbox;
    public CheckBox gamingCheckbox;
    public CheckBox watchingMoviesCheckbox;
    public CheckBox listeningtoMusicCheckbox;
    public CheckBox workingOutCheckbox;
    public CheckBox sleepingCheckbox;
    public CheckBox readingCheckbox;
    public CheckBox drawingCheckbox;
    private ArrayList<String> favouriteActivities = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
}
    public void errorHandle()
    {
        errorLabel.setText("");
        if(firstNameTextfield.getText().isEmpty() && lastNameTextfield.getText().isEmpty() && studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your first name, last name and student number are all empty");
        }
        else if(!firstNameTextfield.getText().isEmpty() && lastNameTextfield.getText().isEmpty() && studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your last name and student number are empty");
        }
        else if(firstNameTextfield.getText().isEmpty() && !lastNameTextfield.getText().isEmpty() && studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your first name and student number are empty");
        }
        else if(firstNameTextfield.getText().isEmpty() && lastNameTextfield.getText().isEmpty() && !studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your first name and last name are empty");
        }
        else if(firstNameTextfield.getText().isEmpty() && !lastNameTextfield.getText().isEmpty() && !studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your first name is empty");
        }
        else if(!firstNameTextfield.getText().isEmpty() && !lastNameTextfield.getText().isEmpty() && studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your student number is empty");
        }
        else if(!firstNameTextfield.getText().isEmpty() && lastNameTextfield.getText().isEmpty() && !studentNumberTextfield.getText().isEmpty()){
            errorLabel.setText("Your last name is empty");
        }
        else {
            checkboxPushed();
            try {
                int parsedStudentNumber = Integer.parseInt(studentNumberTextfield.getText());
                Student NewStudent = new Student(firstNameTextfield.getText(), lastNameTextfield.getText(), parsedStudentNumber, favouriteActivities);
                System.out.println(NewStudent);
            }
            catch(IllegalArgumentException e){
                errorLabel.setText(e.getMessage());
            }
            catch(Exception e){
                errorLabel.setText(e.getMessage());
            }
        }
    }
    private void checkboxPushed(){
        if(codingCheckbox.isSelected())
            favouriteActivities.add("Coding");
        if(gamingCheckbox.isSelected())
            favouriteActivities.add("Gaming");
        if(watchingMoviesCheckbox.isSelected())
            favouriteActivities.add("Watching Movies");
        if(listeningtoMusicCheckbox.isSelected())
            favouriteActivities.add("Listening to Music");
        if(workingOutCheckbox.isSelected())
            favouriteActivities.add("Working Out");
        if(sleepingCheckbox.isSelected())
            favouriteActivities.add("Sleeping");
        if(readingCheckbox.isSelected())
            favouriteActivities.add("Reading");
        if(drawingCheckbox.isSelected())
            favouriteActivities.add("Drawing");
    }
}
