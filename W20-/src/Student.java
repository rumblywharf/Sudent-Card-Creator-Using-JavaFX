
public class Student {

    private int studentNumber;
    private String firstName, lastName;

    Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (!firstName.isEmpty() && firstName.length() > 1) {
            this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        }
        else
            throw new IllegalArgumentException("You cannot leave your first name empty!");
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if (!lastName.isEmpty() && lastName.length() > 1) {
            this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        }
        else
            throw new IllegalArgumentException("You cannot leave your last name blank!");
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    private void setStudentNumber(int studentNumber) {
        if (studentNumber != 0) {
            if (studentNumber > 100000000 && studentNumber < 999999999)
                this.studentNumber = studentNumber;
            else
                throw new IllegalArgumentException("Your student number is not in the range 10000000-9999999");
        }
        else
            throw new IllegalArgumentException("You cannot leave your student number empty!");
    }

    @Override
    public String toString() {
        return String.format("%s %s student #: %d", firstName, lastName, studentNumber);
    }
}
