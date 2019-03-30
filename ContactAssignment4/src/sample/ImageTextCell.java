package sample;

import javafx.scene.control.ListCell;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;


/**
 *  Note what this class does is create a custom way to represent the contacts in the ListView.
 * */

public class ImageTextCell extends ListCell<Contact>{
    /** These instance variables are for the controls/layout*/
    private ImageView imageView = new ImageView();
    private Label label = new Label();
    private VBox vBox = new VBox(8.0); //Following textbook 8-point gap between controls.

    public ImageTextCell(){
        vBox.setAlignment(Pos.CENTER);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100.0);
        vBox.getChildren().add(imageView); /** Attach the image to the VBOX */

        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);
        vBox.getChildren().add(label); /**Attach label to the VBOX*/

        setPrefWidth(USE_PREF_SIZE);

    }

    /** This updates the cell based on our input, in this case a contact*/
    @Override
    protected void updateItem(Contact item, boolean empty){
        super.updateItem(item, empty); /**Call parents constructor to set up everything. */

        /** if we have no input, create empty cell.*/
        if(empty || item==null){
            setGraphic(null);
        } else { /**Else add the appropriate image and  label to each cell.*/
            imageView.setImage(new Image(item.getImagePath()));
            label.setText(item.getLastName() + ", " + item.getFirstName());
            setGraphic(vBox);
        }
    }
}