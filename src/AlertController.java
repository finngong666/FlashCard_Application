import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertController {

    @FXML
    private Button buttonNo;

    @FXML
    private Button buttonYes;

    @FXML
    void GoBackToScene(MouseEvent event) throws IOException {
        changeStageToFlashCard();
    }

    private void changeStageToFlashCard() throws IOException {
        Stage stage =  (Stage) buttonYes.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("flashcard.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("FlashCard");
    }

    @FXML
    void EndProgram(MouseEvent event) {

       Stage stage = (Stage) buttonNo.getScene().getWindow();
        stage.close();

    }


}
