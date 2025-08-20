import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; // index (0-based)

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer - 1 == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create quiz questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"super", "extends", "this", "final"}, 1));
        questions.add(new Question("Which of these is not a Java primitive type?",
                new String[]{"int", "String", "char", "boolean"}, 1));
        questions.add(new Question("Which method is the entry point of Java program?",
                new String[]{"main()", "start()", "run()", "execute()"}, 0));

        int score = 0;

        System.out.println("===== Welcome to the Quiz App =====");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct Answer: " + (q.correctAnswer + 1) + ". " + q.options[q.correctAnswer]);
            }
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        sc.close();
    }
}
