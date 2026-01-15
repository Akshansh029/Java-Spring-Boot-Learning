package quizApp;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            QuestionService queService = new QuestionService();
            
            System.out.println("Welcome to QuizApp! Let's start the quiz...\n");
          for (Question question : queService.questions) {
              System.out.println(question.toString());
              System.out.printf("\nProvide your answer: ");
              String answer = sc.nextLine();
              if (question.checkAnswer(question, answer.trim())) {
                  System.out.println("\nCorrect answer!");
              } else {
                  System.out.println("\nWrong answer, the correct option is " + question.getAnswer());
              }
              System.out.println();
          }
      }
}
