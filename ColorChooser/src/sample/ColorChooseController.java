package sample;

/**
 * Sample Skeleton for 'ColorChooser.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class ColorChooseController {

    @FXML // fx:id="greenTextField"
    private TextField greenTextField; // Value injected by FXMLLoader

    @FXML // fx:id="greenSlider"
    private Slider greenSlider; // Value injected by FXMLLoader

    @FXML // fx:id="redSlider"
    private Slider redSlider; // Value injected by FXMLLoader

    @FXML // fx:id="alphaTextField"
    private TextField alphaTextField; // Value injected by FXMLLoader

    @FXML // fx:id="redTextField"
    private TextField redTextField; // Value injected by FXMLLoader

    @FXML // fx:id="colorRectange"
    private Rectangle colorRectangle; // Value injected by FXMLLoader

    @FXML // fx:id="blueSlider"
    private Slider blueSlider; // Value injected by FXMLLoader

    @FXML // fx:id="blueTextField"
    private TextField blueTextField; // Value injected by FXMLLoader

    @FXML // fx:id="alphaSlider"
    private Slider alphaSlider; // Value injected by FXMLLoader

    @FXML
    private Circle colorCircle;


    /* Instance variables that will be used to hold slider values. */
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize(){

        /* Notice how the textfields depend on the value of the slider.
        Thus we need to bind them. */

        /* Take the text field. Take the property of the field (ie what its composed of.)
        Bind its property, to the sliders value property. And save the slider value as a string */

        redTextField.textProperty().bind(
                redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(
                greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(
                blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(
                alphaSlider.valueProperty().asString("%.2f"));



        /* Here we add a Listener, which is just what listens to changes,
        in this case if a user changes the slider.

        ChangeListender definds how the change occurs.
        Its the more specific interface versues ObserveListener that is les specific.
        */
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                /*Set our red value*/
                red = newValue.intValue();
                /*refill the shape with new color. */
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });

        greenSlider.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                        /*Set our green value*/
                        green = newValue.intValue();
                        /*refill the shape with new color. */
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
        });

        blueSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                /*Set our blue value*/
                blue = newValue.intValue();
                /*refill the shape with new color. */
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });

        alphaSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                /*Set our alpha value NOTE THIS IS A DOUBLE*/
                alpha = newValue.doubleValue();
                /*refill the shape with new color. */
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });


    }

}
