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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * creates the create student controller
 */
public class CreateStudentController implements Initializable {

    /**
     * creates the variables needed to run the program
     */
    @FXML
    public Label errorLabel;
    @FXML
    public Label ageLabel;
    @FXML
    public TextField firstNameTextfield;
    @FXML
    public TextField lastNameTextfield;
    @FXML
    public TextField studentNumberTextfield;
    @FXML
    public Button submitButton;
    @FXML
    public Button changeImageButton;
    @FXML
    public CheckBox codingCheckbox;
    @FXML
    public CheckBox gamingCheckbox;
    @FXML
    public CheckBox watchingMoviesCheckbox;
    @FXML
    public CheckBox listeningtoMusicCheckbox;
    @FXML
    public CheckBox workingOutCheckbox;
    @FXML
    public CheckBox sleepingCheckbox;
    @FXML
    public CheckBox readingCheckbox;
    @FXML
    public CheckBox drawingCheckbox;
    @FXML
    public ImageView studentImage;
    @FXML
    public DatePicker birthdayPicker;
    private ArrayList<String> favouriteActivities = new ArrayList<String>();
    public static int presetStudentNumber = 100000001;

    /**
     * creates an initializable method to automatically set the student number textbox to the public static variable created above
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentNumberTextfield.setText(String.valueOf(presetStudentNumber));
    }

    /**
     * validates that all text input areas are populated, if not it shows a helpful error message in red at the bottom
     * creates a new student object with the inputted information
     * adds 1 to the non editable textfield
     * changes scenes to the view student card scene
     * @param event
     */
    public void errorHandle(ActionEvent event) {
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
                Student NewStudent = new Student(firstNameTextfield.getText(), lastNameTextfield.getText(), parsedStudentNumber, favouriteActivities, birthdayPicker.getValue(), studentImage.getImage());
                presetStudentNumber += 1;
                Main.getStudents().add(NewStudent);
                changeScene(event, NewStudent);

            }
            catch(IllegalArgumentException e){
                errorLabel.setText(e.getMessage());
            }
            catch(Exception e){
                errorLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * Depending on what checkbox is pressed, it adds the corresponding text to the arraylist of interests
     */
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

    /**
     * upload a new file method that directs the user to the pictures directory when pressed and filters only jpg and png
     * the method than reads the uploaded image and displays it into the image viewbox
     * @param event
     */
    public void chooseFile(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Choose an Image");
        FileChooser.ExtensionFilter photoFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        filechooser.getExtensionFilters().addAll(photoFilter);
        String startDirectorString = System.getProperty("user.home") + "\\Pictures";
        File startDirectory = new File(startDirectorString);
        if(!startDirectory.canRead()) {
            startDirectory = new File(System.getProperty("user.home"));
        }
        filechooser.setInitialDirectory(startDirectory);
        File photoFile = filechooser.showOpenDialog(stage);
        if(photoFile != null && photoFile.isFile())
            studentImage.setImage(new Image(photoFile.toURI().toString()));
    }

    /**
     * Generates a default image based when the default image button
     */
    public void defaultImage() {
        studentImage.setImage(new Image("img/Default.jpg"));
    }

    /**
     * Generates a basic student with my personal credentials that links to the set default student button
     */
    public void defaultStudent() {
    firstNameTextfield.setText("Cameron");
    lastNameTextfield.setText("Thompson");
    birthdayPicker.setValue(LocalDate.parse("2001-11-07"));
    studentImage.setImage(new Image("img/cameron.jpg"));
    gamingCheckbox.setSelected(true);
    sleepingCheckbox.setSelected(true);
    listeningtoMusicCheckbox.setSelected(true);
    }

    /**
     * Sets the age and validates that it is greater than or equal to 10 and that it is smaller than or equal to 120
     */
    public void generateAge(){
        LocalDate dateNow = LocalDate.now();
        LocalDate dateEntered = birthdayPicker.getValue();
        int age = (int) ChronoUnit.YEARS.between(dateEntered,dateNow);
        ageLabel.setText("Age: " + age);
        if(age >= 120 || age <= 10){
            errorLabel.setText("Age must be between 10 and and 120");
        }
    }

    /**
     * method to switch the scene to the view screen
     * @param event
     * @param newStudent
     * @throws IOException
     */
    public void changeScene(ActionEvent event, Student newStudent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Student_Card.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        StudentCardController controller = loader.getController();
        controller.selectedStudent(newStudent);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setTitle("View Student Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    }
