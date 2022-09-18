import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadyController {

    @FXML
    private Button noFlash;

    @FXML
    private Button yesFlash;

    @FXML
    void noToFlash(MouseEvent event) throws IOException {

        Stage stage = (Stage) noFlash.getScene().getWindow();
        stage.close();
    }

    @FXML
    void yesToFlash(MouseEvent event) throws IOException {
        Stage stage =  (Stage) yesFlash.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("flashcard.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("FlashCard");
    }

}
