package quizApp;

public class QuestionService {
      Question[] questions = new Question[5];

      public QuestionService(){
            questions[0] = new Question(1, "Which keyword is used to inherit a class in Java?", "this", "super", "extends", "implements", "extends");

            questions[1] = new Question(2, "Which of the following is NOT a pillar of Object-Oriented Programming?", "Encapsulation", "Inheritance", "Compilation", "Polymorphism", "Compilation");

            questions[2] = new Question(3, "Which method is used to start execution of a Java program?", "start()", "run()", "main()", "execute()", "main()");

            questions[3] = new Question(4, "Which access modifier makes a member accessible only within the same class?", "public", "protected", "default", "private", "private");

            questions[4] = new Question(5, "Which concept allows a child class to provide a specific implementation of a method?", "Abstraction", "Encapsulation", "Method Overloading", "Method Overriding", "Method Overriding");
      }
}
