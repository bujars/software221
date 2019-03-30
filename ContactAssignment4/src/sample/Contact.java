package sample;
/** Must tell the file that
 it's in the same package, else Controller won't know where to look.*/

/** This is the class that defines the attributes of a Contact object. */
public class Contact{

    /** Each contact has a first name, last name, phone number, email, and imagePath*/
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String imagePath;

    public Contact(String firstName, String lastName, String phoneNumber, String email, String imagePath){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imagePath = imagePath;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}