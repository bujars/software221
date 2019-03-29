package sample;

/**
 * Sample Skeleton for 'Painter.fxml' Controller Class
 */

//import com.sun.prism.paint.Color;
import javafx.fxml.FXML;
import javafx.event.ActionEvent; /*This needs to be imported to handle events, such as a button click*/
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class PainterController {


    private enum PenSize{
        SMALL(2),

        MEDIUM(4),

        LARGE(6);

        private final int radius;

        PenSize(int radius){this.radius = radius;}
        public int getRadius() {return radius;}

    };

    @FXML // fx:id="mediumRadioButton"
    private RadioButton mediumRadioButton; // Value injected by FXMLLoader

    @FXML // fx:id="drawingAreaPane"
    private Pane drawingAreaPane; // Value injected by FXMLLoader

    @FXML // fx:id="clearButton"
    private Button clearButton; // Value injected by FXMLLoader

    @FXML // fx:id="sizeToggleGroup"
    private ToggleGroup sizeToggleGroup; // Value injected by FXMLLoader

    @FXML // fx:id="largeRadioButton"
    private RadioButton largeRadioButton; // Value injected by FXMLLoader

    @FXML // fx:id="greenRadioButton"
    private RadioButton greenRadioButton; // Value injected by FXMLLoader

    @FXML // fx:id="redRadioButton"
    private RadioButton redRadioButton; // Value injected by FXMLLoader

    @FXML // fx:id="blackRadioButton"
    private RadioButton blackRadioButton; // Value injected by FXMLLoader

    @FXML // fx:id="colorToggleGroup"
    private ToggleGroup colorToggleGroup; // Value injected by FXMLLoader

    @FXML // fx:id="blueRadioButton"
    private RadioButton blueRadioButton; // Value injected by FXMLLoader

    @FXML // fx:id="smallRadioButton"
    private RadioButton smallRadioButton; // Value injected by FXMLLoader



    @FXML // fx:id="undoButton"
    private Button undoButton; // Value injected by FXMLLoader




    private PenSize radius = PenSize.MEDIUM;

    /*Notice Paint contains color.*/
    private Paint brushColor = Color.BLACK;


    @FXML
    public void initialize(){
        /*This sets the data for everything.*/
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }



    @FXML
    void drawAreaMouseDragged(MouseEvent event) {
        /* When we drag our mouse over the pane, we want to create a circle. We use the X and Y coordinate of the mouse
        for the circles location, use the radium of the pensize, and use the selected color/.*/
        Circle newCircle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        /* In the Pane, we add the new circle. remember cricle is just a node. getChildren() gets an observable list of
        * everything that as added. */
        drawingAreaPane.getChildren().add(newCircle);
    }


    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        /* Because our colors are stored as a group, we must get the specific one, and then get its value,
        in this case a color. WE then cast it to a color so it can be stored.*/
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        /* Because our sizes are stored as a group, we must get the specific one, and then get its value,
        in this case a size. WE then cast it to a pensize so it can be stored.*/
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }



    @FXML
    void undoButtonPressed(ActionEvent event) {
        /* Undo just means looking at the pane and getting rid of a circle.
        In this case we check if we have any circles and then we just remove it from the list of nodes.
        Note the list works like a stack. LIFO. */
        int count = drawingAreaPane.getChildren().size();
        if(count > 0) {
            drawingAreaPane.getChildren().remove(count-1);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        /*Clear the list*/
        drawingAreaPane.getChildren().clear();
    }

}
