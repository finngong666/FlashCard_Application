import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class flashController implements Initializable {

    ArrayList<Question> list = QuestionOperator.loadFileToList("questions.csv");

    private static int count;

    double points = 0.1;

    @FXML
    private Text text;

    @FXML
    private TextArea answerContent;

    @FXML
    private Button nextButton;

    @FXML
    private Button previousButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label questionLable;


    @FXML
    private ToggleButton toggleButton;


    @FXML
    void hideAndShow(MouseEvent event) {

        if(toggleButton.isSelected()){

            //show answer
            answerContent.setVisible(true);
            toggleButton.setText("Hide Answer");

        }else{
            hideAnswer();
            toggleButton.setText("Show Answer");
        }

    }


    @FXML
    void handleClickNext(ActionEvent event) throws Exception {

        previousButton.setDisable(false);
        toggleButton.setSelected(false);
        toggleButton.setText("Show Answer");
        hideAnswer();

        if(text.getText().equals("10/10")){

            //when reach the end of the flashcard, change the stage to alert scene
            changeStageToAlert();
            count = 0;
            hideAnswer();
            showNextQuestion();

        }else {

            progressBarIncrement();
            hideAnswer();
            showNextQuestion();
            count++;

        }

    }


    @FXML
    void handleClickPrevious(ActionEvent event) {
        toggleButton.setSelected(false);
        toggleButton.setText("Show Answer");
        hideAnswer();

        if(text.getText().equals("2/10")){
            previousButton.setDisable(true);
        }

        progressBarDecrement();
        hideAnswer();
        showPreviousQuestion();
        count--;
    }

    private void progressBarIncrement() {
        points = points + 0.1;
        int num = (int) (Math.round(points * 1000.0) / 100.0);
        text.setText(Integer.toString(num) + "/10");
        progressBar.setProgress(points);
    }

    private void progressBarDecrement() {
        points = points - 0.1;
        int num = (int)(Math.round(points * 1000.0) / 100.0);
        text.setText(Integer.toString(num) + "/10");
        progressBar.setProgress(points);
    }

    private void changeStageToAlert() throws IOException {
        Stage stage = (Stage) nextButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("alert.fxml"));
        stage.setTitle("Alert");
        stage.setScene(new Scene(root));
    }

    private void hideAnswer() {
        answerContent.setVisible(false);
    }

    private void showPreviousQuestion() {
        questionLable.setText(list.get(count - 1).getQuestion());
        answerContent.setText(list.get(count - 1).getAnswer());
    }

    private void showNextQuestion() {
        questionLable.setText(this.list.get(count + 1).getQuestion());
        answerContent.setText(this.list.get(count + 1).getAnswer());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        previousButton.setDisable(true);
        hideAnswer();

        questionLable.setText(list.get(count).getQuestion());
        answerContent.setText(list.get(count).getAnswer());


    }
}
