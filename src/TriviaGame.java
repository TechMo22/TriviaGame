import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {
    private ArrayList<Question> questionList;
    public TriviaGame(){
        questionList = new ArrayList<Question>();
        String questionOne = "What year was the first computer game created in?";
        String [] oneAnswers = new String[]{"1982", "1955", "1961","1972"};

        questionList.add(new Question(questionOne, oneAnswers, "1961"));

       String questionTwo = "Kautilya Katariya became the world's youngest computer programmer at what age?";
        String [] twoAnswers = new String[]{"12", "15", "6", "8"};

        questionList.add(new Question(questionTwo, twoAnswers, "6"));

        String questionThree = "The first computer “bug” was discovered in 1947 in the form of a dead what?";
        String [] threeAnswers = new String[]{"Moth", "Spider", "Ant", "Caterpillar"};
        questionList.add(new Question(questionThree, threeAnswers, "Moth"));

        String questionFour = "Who is the first computer programmer?";
        String [] fourAnswers = new String[]{"Bill Gates", "Grace Hopper", "Ada Lovelace", "Steve Jobs"};
        questionList.add(new Question(questionFour, fourAnswers, "Ada Lovelace"));

        String questionFive = "There are approximately ___ coding languages?";
        String [] fiveAnswers = new String[]{"250", "500", "100", "700"};
        questionList.add(new Question(questionFive, fiveAnswers, "700"));

        Collections.shuffle(questionList, new Random());
    }

    public void start(){
        Scanner scan = new Scanner(System.in);
        int numCorrect = 0;
        for(int i = 0; i < questionList.size(); i++){
            System.out.println(questionList.get(i).getQuestion());
            int numChoices = questionList.get(i).getChoices().size();
            for(int j = 0; j < numChoices; j++){
                System.out.println((j +1) + ": " + questionList.get(i).getChoices().get(j));
            }
            int playerAnswer = scan.nextInt();
            ArrayList<String> choiceSet = questionList.get(i).getChoices();
            String correctAnswer = questionList.get(i).getAnswer();
            int correctIndex = choiceSet.indexOf(correctAnswer);
            if(playerAnswer == correctIndex +1){
                numCorrect++;
                System.out.println("Correct Answer");
            } else {
                System.out.println("Incorrect Answer");
            }
        }
        System.out.println("You got " + numCorrect + " answer(s) correct");

    }

}
