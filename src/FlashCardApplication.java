import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FlashCardApplication extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //load the flashcard file
        Parent root = FXMLLoader.load(getClass().getResource("flashcard.fxml"));

        //set the stage with the scene with the root inside
        primaryStage.setScene(new Scene(root));

        //set a title for stage
        primaryStage.setTitle("Java Flashcard");

        //show the stage
        primaryStage.show();

        System.out.println(primaryStage);


    }


}
