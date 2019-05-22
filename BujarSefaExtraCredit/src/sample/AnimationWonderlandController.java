package sample;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationWonderlandController {
    @FXML private Rectangle rectangleFillAndStroke;
    @FXML private Rectangle rectangleFade;
    @FXML private Rectangle rectangleRotate;
    @FXML private Rectangle rectanglePath;
    @FXML private Rectangle rectangleScale;


    // configure and start fill and stroke animation
    @FXML
    private void startButtonPressedFillAndStroke(ActionEvent event) {
        //  change a shape's filling color
        FillTransition fillTransition =
                new FillTransition(Duration.seconds(1));
        fillTransition.setToValue(Color.BLACK);
        fillTransition.setCycleCount(4);

        // go back to start color
        fillTransition.setAutoReverse(true);

        // Change the outer color
        StrokeTransition strokeTransition =
                new StrokeTransition(Duration.seconds(1));
        strokeTransition.setToValue(Color.PINK);
        strokeTransition.setCycleCount(4);
        strokeTransition.setAutoReverse(true);

        // To combine both colors
        ParallelTransition parallelTransition =
                new ParallelTransition(fillTransition, strokeTransition);

        // Apply transition to the appropriate rectangle
        SequentialTransition rectangleTransition =
                new SequentialTransition (rectangleFillAndStroke, parallelTransition);

        rectangleTransition.play(); // play the transition
    }
    @FXML
    private void startButtonPressedFade(ActionEvent event) {

        // Make the color blend
        FadeTransition fadeTransition =
                new FadeTransition(Duration.seconds(1));
        fadeTransition.setFromValue(1.0); // opaque
        fadeTransition.setToValue(0.0); // transparent
        fadeTransition.setCycleCount(4);
        fadeTransition.setAutoReverse(true);

        // Apply transition to the appropriate rectangle
        SequentialTransition rectangleTransition =
                new SequentialTransition (rectangleFade,
                        fadeTransition);
        // play the transition
        rectangleTransition.play();
    }


    @FXML
    private void startButtonPressedRotate(ActionEvent event) {

        // Rotate a rectangle
        RotateTransition rotateTransition =
                new RotateTransition(Duration.seconds(1));
        rotateTransition.setByAngle(360.0);
        rotateTransition.setCycleCount(4);
        rotateTransition.setInterpolator(Interpolator.EASE_BOTH);
        rotateTransition.setAutoReverse(true);

        // Apply transition to the appropriate rectangle
        SequentialTransition rectangleTransition =
                new SequentialTransition (rectangleRotate, rotateTransition);
        // play the transition
        rectangleTransition.play();
    }
    @FXML
    private void startButtonPressedPath(ActionEvent event) {


        // MAke the rectangle move
        Path path = new Path(new MoveTo(45, 45), new LineTo(45, 0),
                new LineTo(90, 0), new LineTo(90, 90), new LineTo(0, 90));
        PathTransition translateTransition =
                new PathTransition(Duration.seconds(2), path);
        translateTransition.setCycleCount(4);
        translateTransition.setInterpolator(Interpolator.EASE_IN);
        translateTransition.setAutoReverse(true);


        // Apply transition to the appropriate rectangle
        SequentialTransition rectangleTransition =
                new SequentialTransition (rectanglePath, translateTransition);
        // play the transition
        rectangleTransition.play();
    }

    @FXML
    private void startButtonPressedScale(ActionEvent event) {

        // make it bigger or smaller
        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.seconds(1));
        scaleTransition.setByX(0.5);
        scaleTransition.setByY(0.5);
        scaleTransition.setCycleCount(4);
        scaleTransition.setInterpolator(Interpolator.EASE_OUT);
        scaleTransition.setAutoReverse(true);

        // Apply transition to the appropriate rectangle
        SequentialTransition rectangleTransition =
                new SequentialTransition (rectangleScale, scaleTransition);
        // play the transition
        rectangleTransition.play();
    }

}

