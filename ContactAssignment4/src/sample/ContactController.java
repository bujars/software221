package sample;

/**
 * Sample Skeleton for 'Contact.fxml' Controller Class
 */

import javafx.beans.value.ObservableValue; /**Used for listening and changing values*/
import javafx.beans.value.ChangeListener; /** Provides changed() method that sets the gridpane. */
import javafx.collections.FXCollections; /** Provide methods that an be used to create empty List*/
import javafx.collections.ObservableList; /** Provides static methods for the Observable list, such as add, delete, empty.*/
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.util.Callback;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;


public class ContactController {

    @FXML // fx:id="contactGridPane"
    private GridPane contactGridPane; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNumberTextField"
    private TextField phoneNumberTextField; // Value injected by FXMLLoader

    @FXML // fx:id="contactListView"
    private ListView<Contact> contactListView; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameTextField"
    private TextField lastNameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="emailTextField"
    private TextField emailTextField; // Value injected by FXMLLoader

    @FXML // fx:id="imageTextField"
    private TextField imageTextField; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameTextField"
    private TextField firstNameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="contactImageView"
    private ImageView contactImageView; // Value injected by FXMLLoader

    @FXML // fx:id="addButton"
    private Button addButton; // Value injected by FXMLLoader

    @FXML // fx:id="updateButton"
    private Button updateButton; // Value injected by FXMLLoader

    @FXML // fx:id="deteleButton"
    private Button deteleButton; // Value injected by FXMLLoader


    /** Create an ObservableList, which is like an ArrayList except
     * the content can be observed, which means binded/listened to. */
    /** Named contactList because its a list of contacts */
    /** Declared as final because we don't want to set it to a new list.
     * Note we can add/delete/empty everything in the list */
    private final ObservableList<Contact> contactList =
            FXCollections.observableArrayList();
    /** This is essential empty when its first started */

    /** Function that sets up the APP.*/
    public void initialize(){
        /** Add initial Contacts here as example. Follow Structure. Try to keep the size as close to 100*100 for clear view */
        contactList.add(new Contact("Bujar", "Sefa", "9178567401","bsefa000@citymail.cuny.edu", "./sample/images/bujar.png"));
        contactList.add(new Contact("Kanchan", "Gondiker", "NA", "kgondik000@citymail.cuny.edu", "./sample/images/kanchangondiker.png"));


        /** Add the contact List to the view. ==> This binds the View to the ObservableList.
         * So basically anytime we add a new Contac, it will appear on the list.*/
        /*ComparatorChain chain = new ComparatorChain();
        chain.addComparator(new sortByLastName());
        Collections.sort(contactList.getItem(), chain);*/
        Collections.sort(contactList, new Comparator<Contact>() {

            @Override
            public int compare(Contact o1, Contact o2) {

                return -o1.getLastName().compareTo(o2.getLastName());

            }
        });

        contactListView.setItems(contactList);

        /** Must listen to items picked on the ListView, to display on the grid pane...
         *
         *  I think you need to listen to each of different text fields and bind them. This also applies for the image
         *
         *  CORRECT!!!
         * */
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneNumberTextField.setText("");
        emailTextField.setText("");
        imageTextField.setText("./sample/images/default.png");
        contactImageView.setImage(new Image(imageTextField.getText()));
        contactListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Contact>() {
                    @Override
                    public void changed(ObservableValue<? extends Contact> observable, Contact oldValue, Contact newValue) {

                        if(newValue==null || contactList.size()==0){
                            firstNameTextField.setText("");
                            lastNameTextField.setText("");
                            phoneNumberTextField.setText("");
                            emailTextField.setText("");
                            imageTextField.setText("./sample/images/default.png");
                            contactImageView.setImage(new Image(imageTextField.getText()));
                        } else {

                            /** NOTE setText so that it displace. Set User data works differently. */
                            firstNameTextField.setText(newValue.getFirstName());
                            lastNameTextField.setText(newValue.getLastName());
                            phoneNumberTextField.setText(newValue.getPhoneNumber());
                            emailTextField.setText(newValue.getEmail());
                            imageTextField.setText(newValue.getImagePath());
                            contactImageView.setImage(new Image(newValue.getImagePath()));
                        }
                    }
                }
        );
        /** The way that list View works is that it figures out how to output everything at the very end. Hence here we
         * call back and make sure that our list prints as our Image and Text cells and not just a string.*/
        contactListView.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {
            @Override
            public ListCell<Contact> call(ListView<Contact> param) {
                return new ImageTextCell();
            }
        });



    }




    @FXML
    void addContactActionEvent(ActionEvent event) {
        String imaFile = "src/"+imageTextField.getText().substring(2);
        File imageFile = new File(imaFile);
        if(!(imageTextField.getText().equals("./sample/images/default.png"))) {
            if (!(imageFile.exists())&& !(imaFile.equals("src/sample/images/"))){
                imageTextField.setText("./sample/images/default.png");
                contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setImagePath(imageTextField.getText());
            }
        }

        if(imageFile.exists()==false){
            imageTextField.setText("./sample/images/default.png");
        }

        contactList.add(new Contact(firstNameTextField.getText(), lastNameTextField.getText(), phoneNumberTextField.getText(), emailTextField.getText(), imageTextField.getText()));
        /** Becasue the listView is binded to the array, it will automatically update the list view.*/


        /** Once you add the contact, you want to make it blank so that the person can add new ones. */
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneNumberTextField.setText("");
        emailTextField.setText("");
        imageTextField.setText("./sample/images/default.png");
        contactImageView.setImage(new Image(imageTextField.getText())); /** Will put errors but cant do anything about it*/
        Collections.sort(contactList, new Comparator<Contact>() {

            @Override
            public int compare(Contact o1, Contact o2) {

                return -o1.getLastName().compareTo(o2.getLastName());

            }
        });
        contactListView.refresh();


    }

    @FXML
    void updateContactActionEvent(ActionEvent event) {
        int index = contactList.indexOf(contactListView.getSelectionModel().getSelectedItem());
        /*System.out.println(index);*/
        if((index < 0) || contactList.size()==0){
            return; /** DO nothing or there will be a crash and it wont work anymore!!!!!*/
        }

        /** Check if we have a file else everything will come crashing down!*/


        contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setFirstName(firstNameTextField.getText());
        contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setLastName(lastNameTextField.getText());
        contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setPhoneNumber(phoneNumberTextField.getText());
        contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setEmail(emailTextField.getText());

        contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setImagePath(imageTextField.getText());
        String imaFile = "src/"+imageTextField.getText().substring(2);
        File imageFile = new File(imaFile);

       /* File imageF = new File("./sample/images/bujar.png");
        File imageFie = new File("src/sample/images/bujar.png");

        System.out.println(imageFile.exists());
        System.out.println(imageF.exists());
        System.out.println(imageFie.exists());
        System.out.println(imageTextField.getText());*/

        if(!(imageTextField.getText().equals("./sample/images/default.png"))) {
            if (!(imageFile.exists())&& !(imaFile.equals("src/sample/images/"))){
                imageTextField.setText("./sample/images/default.png");
                contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).setImagePath(imageTextField.getText());
            }
        }
        contactImageView.setImage(new Image(contactList.get((contactList.indexOf(contactListView.getSelectionModel().getSelectedItem()))).getImagePath()));
        //contactListView.setItems(contactList);
        Collections.sort(contactList, new Comparator<Contact>() {

            @Override
            public int compare(Contact o1, Contact o2) {

                return -o1.getLastName().compareTo(o2.getLastName());

            }
        });
        contactListView.refresh();

        /** This doest work refer to how i did it above. */
        /*contactList.get(contactListView.getEditingIndex()).setLastName(lastNameTextField.getText());
        contactList.get(contactListView.getEditingIndex()).setPhoneNumber(phoneNumberTextField.getText());
        contactList.get(contactListView.getEditingIndex()).setEmail(emailTextField.getText());
        contactList.get(contactListView.getEditingIndex()).setImagePath(imageTextField.getText());*/

        /** Remember the image is binded to its path so it will always update.*/
    }

    @FXML
    void deleteButtonActionEvent(ActionEvent event) {
        int index = contactList.indexOf(contactListView.getSelectionModel().getSelectedItem());
        /*System.out.println(index);*/
        if((index < 0) || contactList.size()==0){
            return; /** DO nothing or there will be a crash and it wont work anymore!!!!!*/
        }
        if(contactList.size()==1){
            contactList.clear();
            return;
        }


        contactList.remove(index, index+1);

        //contactList.remove(contactListView.getEditingIndex(), contactListView.getEditingIndex()+1);
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneNumberTextField.setText("");
        emailTextField.setText("");
        imageTextField.setText("./sample/images/default.png");
        contactImageView.setImage(new Image(imageTextField.getText()));
        //contactListView.setItems(contactList);
        Collections.sort(contactList, new Comparator<Contact>() {

            @Override
            public int compare(Contact o1, Contact o2) {

                return -o1.getLastName().compareTo(o2.getLastName());

            }
        });
        contactListView.refresh();


    }

}
