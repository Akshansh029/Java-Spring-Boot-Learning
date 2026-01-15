package quizApp;
import java.util.Scanner;

public class QuestionService {
      private int score = 0;
      Question[] questions = new Question[5];

      public QuestionService(){
            questions[0] = new Question(1, "Which keyword is used to inherit a class in Java?", "this", "super", "extends", "implements", "extends");

            questions[1] = new Question(2, "Which of the following is NOT a pillar of Object-Oriented Programming?", "Encapsulation", "Inheritance", "Compilation", "Polymorphism", "Compilation");

            questions[2] = new Question(3, "Which method is used to start execution of a Java program?", "start()", "run()", "main()", "execute()", "main()");

            questions[3] = new Question(4, "Which access modifier makes a member accessible only within the same class?", "public", "protected", "default", "private", "private");

            questions[4] = new Question(5, "Which concept allows a child class to provide a specific implementation of a method?", "Abstraction", "Encapsulation", "Method Overloading", "Method Overriding", "Method Overriding");
      }

      public void incScore(){
            score++;
      }

      public String displayScore(){
            return String.format("Your final score is %d/5!\nThank you for playing our quiz app!", score);
      }

      public void playQuiz(){
            try (Scanner sc = new Scanner(System.in)) {
                  System.out.println("Welcome to QuizApp! Let's start the quiz...\n");
                  for (Question question : questions) {
                        System.out.println(question.toString());
                        System.out.printf("\nProvide your answer: ");
                        String answer = sc.nextLine();
                        if (question.checkAnswer(question, answer.trim())) {
                            incScore();
                            System.out.println("\nCorrect answer! ");
                        } else {
                            System.out.println("\nWrong answer, the correct option is " + question.getAnswer());
                        }
                        System.out.println();
                  }
                  System.out.println(displayScore());
                  sc.close();
            } catch(Exception e){
                  System.out.println(e.getMessage());
            }
      }
}
