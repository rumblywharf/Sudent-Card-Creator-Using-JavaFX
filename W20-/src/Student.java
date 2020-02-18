/**
 *    imports all needed packages
 */
import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 *    creates the student class
 */
public class Student {

    /**
     *    creates all needed variables
     */
    private int studentNumber;
    private String firstName, lastName;
    private Image image;
    private ArrayList<String> activities;

    /**
     *    passes the variables through their validators,
     *    gets the image file
     */
    Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        image = new Image("./img/cameron.jpg");
    }

    /**
     *    pulls the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *    validates the first name is not empty,
     *    validates the first name is longer than 1 character,
     *    sets the first letter to a capital letter
     *    if the first name is 1 character or empty then the application with throw an error message
     */
    private void setFirstName(String firstName) {
        if (!firstName.isEmpty() && firstName.length() > 1) {
            this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        }
        else
            throw new IllegalArgumentException("You cannot leave your first name empty!");
    }

    /**
     *    pulls the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *    validates the last name is not empty,
     *    validates the last name is longer than 1 character,
     *    sets the last letter to a capital letter
     *    if the last name is 1 character or empty then the application will throw an error message
     */
    private void setLastName(String lastName) {
        if (!lastName.isEmpty() && lastName.length() > 1) {
            this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        }
        else
            throw new IllegalArgumentException("You cannot leave your last name blank!");
    }

    /**
     *    pulls the student number
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     *    validates that your student number is not 0,
     *    validates that your student number is between 100000000-999999999
     *    if your student number is 0 or is not between 100000000-999999999 then the application will throw an error message
     *    THIS APPLICATION USES MY GEORGIAN STUDENT NUMBER, HOWEVER IF I WERE TO USES MY LAKEHEAD STUDENT NUMBER I WOULD ADJUST THE VALIDATING NUMBERS IN MY IF STATEMENT
     */
    private void setStudentNumber(int studentNumber) {
        if (studentNumber != 0) {
            if (studentNumber > 100000000 && studentNumber < 999999999)
                this.studentNumber = studentNumber;
            else
                throw new IllegalArgumentException("Your student number is not in the range 100000000-999999999");
        }
        else
            throw new IllegalArgumentException("You cannot leave your student number empty!");
    }

    /**
     *    pulls an image
     */
    public Image getImage() {
        return image;
    }

    /**
     *    creates a to string method that uses the instance variables to display in a formatted sentence
     */
    @Override
    public String toString() {
        return String.format("%s %s student #: %d", firstName, lastName, studentNumber);
    }
}
