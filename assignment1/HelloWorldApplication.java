import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class HelloWorldApplication extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello World");
        label.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(label, 300, 250));
        primaryStage.setTitle("Hello World Application");
        primaryStage.show();
    }

    /*
    	If we include the main() method then we need to call Application.launch()
    	for launching the JavaFX application
    */
    public static void main(String[] args) {
        launch(args);
    }

}