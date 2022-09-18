import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionOperator {

    public static ArrayList<Question> loadFileToList(String fileName){

        File file = new File("questions.csv");

        if(fileName == null || !file.exists()){
            return new ArrayList<Question>();
        }

        ArrayList<Question> questionsList = new ArrayList<>();
        try(
                Scanner input = new Scanner(file);
                ){
            while(input.hasNext()){
                String fileData = input.nextLine();
                String[] fields = fileData.split("=");
                String question = fields[0];
                String answer = fields[1];
                Question question1 = new Question(question, answer);
                questionsList.add(question1);
            }
        }
        catch(IOException exception){
            System.out.println("cannot read the file for some reason");
        }
        return questionsList;
    }
}
