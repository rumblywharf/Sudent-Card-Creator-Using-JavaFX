/**
 *    imports all needed packages
 */
import javafx.scene.image.Image;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *    creates the student class that extends to the create student controller
 */
public class Student extends CreateStudentController {

    /**
     *    creates all needed variables
     */
    private int studentNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Image image;
    private ArrayList<String> interests;

    /**
     *    pulls the birthday and image through a constructor
     *    passes the variables through their validators
     */
    Student(String firstName, String lastName, int studentNumber, ArrayList<String> interests, LocalDate birthday, Image image) {
        this.birthday = birthday;
        this.image = image;
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setInterests(interests);
    }

    /**
     * gets the arraylist of interests
     * @return
     */
    public ArrayList<String> getInterests() {
        return interests;
    }

    /**
     * sets the intrests array list, so if any validation was needed you could include here
     * @param interests
     */
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
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
        if(firstName.length() > 1) {
            if (!firstName.isEmpty()) {
                this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            } else
                throw new IllegalArgumentException("You cannot leave your first name empty!");
        }
        else{
            throw new IllegalArgumentException("Your first name must be longer than 1 letter!");
        }
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
        if (lastName.length() > 1) {
            if (!lastName.isEmpty()) {
                this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
            } else
                throw new IllegalArgumentException("You cannot leave your last name blank!");
        }
        else {
            throw new IllegalArgumentException("Your last name must be longer than 1 letter!");
        }
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
     * pulls a birthday in years that compares to the current date to read the age of someone
     * @return
     */
    public int getBirthday(){
        return Period.between(birthday, LocalDate.now()).getYears();
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
        return String.format("%s %s Student #: %d \n", firstName, lastName, studentNumber);
    }
}
