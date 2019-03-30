package sample;

/** NOTE NOTE NOTE... THE PATH soruce of project is src, so must do ./ (current directory)   /sample (package sample) /images..... so fourth */





/**
 * Sample Skeleton for 'CoverViewer.fxml' Controller Class
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



//import javafx.fxml.FXML;
//import javafx.scene.control.ListView;

//import javafx.scene.image.ImageView;
//import javafx.beans.value.ObservableValue; /** This is to tell the program what to observe, in our case the Book and how it changes  */
//import javafx.beans.value.ChangeListener; /** This is to create what gets changed, in this case the ImageView */

//import javafx.collections.FXCollections; /** This contains static methods that we use to create an empty list*/
//import javafx.collections.ObservableList; /** This is the list, like an array. ==> has methods like add*/
//import javafx.scene.image.Image; /** This is to use new image */

public class CoverViewerController {

    @FXML // fx:id="booksListView"
    private ListView<Book> booksListView; // Value injected by FXMLLoader

    @FXML // fx:id="coverImageView"
    private ImageView coverImageView; // Value injected by FXMLLoader

    /**
     * Books is a defind class. Taken from the textbook examples.
     */
    private final ObservableList<Book> books = FXCollections.observableArrayList();

    /**
     * This is our array. Note its created each time of the program
     */


    public void initialize() {
        /** Note this is the format of adding a new book into our array list. */
        /** books.add(new Book("Andriod", "small image Location", "Large image Location"));
         books.add(new Book("Andriod", "/images/small/andriodhtp.jpg", "/images/large/andriodhtp.jpg"));*/

        books.add(new Book("Android How to Program",
                "./sample/images/small/androidhtp.jpg", "./sample/images/large/androidhtp.jpg"));
        books.add(new Book("C How to Program",
                "./sample/images/small/chtp.jpg", "./sample/images/large/chtp.jpg"));
        books.add(new Book("C++ How to Program",
                "./sample/images/small/cpphtp.jpg", "./sample/images/large/cpphtp.jpg"));
        books.add(new Book("Internet and World Wide Web How to Program",
                "./sample/images/small/iw3htp.jpg", "./sample/images/large/iw3htp.jpg"));
        books.add(new Book("Java How to Program",
                "./sample/images/small/jhtp.jpg", "./sample/images/large/jhtp.jpg"));
        books.add(new Book("Visual Basic How to Program",
                "./sample/images/small/vbhtp.jpg", "./sample/images/large/vbhtp.jpg"));
        books.add(new Book("Visual C# How to Program",
                "./sample/images/small/vcshtp.jpg", "./sample/images/large/vcshtp.jpg"));

        booksListView.setItems(books); /** bind booksListView ==> books is an ObservableValue that when a new one comes,
         // its put into the list which there "binds" tje ;ist to the books */

        booksListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Book>() {
                            @Override
                            public void changed(ObservableValue<? extends Book> ov,
                                                Book oldValue, Book newValue) {
                                coverImageView.setImage(
                                        new Image(newValue.getLargeImage()));
                            }
                        }
                );

    }
}
