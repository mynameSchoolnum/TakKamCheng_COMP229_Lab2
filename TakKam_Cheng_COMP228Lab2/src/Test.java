import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

    private String[] questions = {
            "Which of the following Java program units defines a group of related objects?",
            "What does an instance variable describe?",
            "Which of the following statements is true in relation to the life of an instance variable?",
            "Which of the following statements is false in relation to Java parameters?",
            "When a method that specifies a return type other than void is called, what must the method do when it " +
                    "completes its task? and completes its task, the method must return a result to its calling method."
    };

    private String[][] options = {
            {"1. Java Class", "2. Java method",
                    "3. Java", "4. Java default constructor"},

            {"1. Properties of an object", "2. Behaviour of an object", "3. Measurement of an object", "4. Height of an object."},

            {"1. Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution.",
                    "2. Instance variables starts its life only after a method is called on an object, and lasts till the  method completes its execution.",
                    "3. Instance variables exist even before methods are called on an object and lasts only till methods are called on an object.",
                    "4. Instance variables exist before methods are called on an object, while the methods are executing and after the methods complete execution."},

            {"1. Parameters are located inside the parentheses that follow the method name in the method declaration.",
                    "2. Parameter names must follow the naming rules of identifiers.",
                    "3. Parameters are declared in a comma-separated parameter list", "4. Parameters do not need to specify a datatype."},

            {"1. It must return one result only to the statement one line after the line from which it was called.", "2. It must return a result exactly to the point from which it was called.",
                    "3. It must return one result to the statement immediately after the method body.", "4. It must return more than just one result to its caller."}
    };

    private int[] correctAnswers = {1, 1, 1, 4, 2};

    private int correctCount = 0;
    private int incorrectCount = 0;

    private Random randomObject = new Random();

    private int simulateQuestion(int questionIndex) {
        String question = questions[questionIndex];
        String[] choices = options[questionIndex];

        StringBuilder questionBuilder = new StringBuilder(question + "\n");
        for (String option : choices) {
            questionBuilder.append(option).append("\n");
        }

        String userAnswer = JOptionPane.showInputDialog(null, questionBuilder.toString(),
                "JavaLab 1 _ Exercise 1 _ Quiz", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(userAnswer);
    }

    private boolean checkAnswer(int questionIndex, int userAnswer) {
        return userAnswer == correctAnswers[questionIndex];
    }

    private String generateCorrectMessage() {
        switch (randomObject.nextInt(4)) {
            case 0: return "Excellent!!";
            case 1: return "Good!!";
            case 2: return "Keep up the good work!!";
            case 3: return "Nice work!!";
            default: return "Great!!";
        }
    }

    private String generateIncorrectMessage(int correctAnswer) {
        switch (randomObject.nextInt(4)) {
            case 0: return "No. Please try again. The correct answer was: " + correctAnswer;
            case 1: return "Wrong. Try once more. The correct answer was: " + correctAnswer;
            case 2: return "Don't give up! The correct answer was: " + correctAnswer;
            case 3: return "No. Keep trying.. The correct answer was: " + correctAnswer;
            default: return "Try again! The correct answer was: " + correctAnswer;
        }
    }

    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            int userAnswer = simulateQuestion(i);
            if (checkAnswer(i, userAnswer)) {
                JOptionPane.showMessageDialog(null, generateCorrectMessage(),
                        "JavaLab 1 _ Exercise 1 _ Quiz", JOptionPane.INFORMATION_MESSAGE);
                correctCount++;
            } else {
                JOptionPane.showMessageDialog(null, generateIncorrectMessage(correctAnswers[i]),
                        "JavaLab 1 _ Exercise 1 _ Quiz", JOptionPane.INFORMATION_MESSAGE);
                incorrectCount++;
            }
        }
        displayResult();
    }

    private void displayResult() {
        int totalQuestions = questions.length;
        double percentage = (correctCount / (double) totalQuestions) * 100;
        String resultMessage = String.format("Correct answers: %d\nIncorrect answers: %d\nPercentage: %.2f%%",
                correctCount, incorrectCount, percentage);
        JOptionPane.showMessageDialog(null, resultMessage, "Test Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        Test quizTest = new Test();
        quizTest.inputAnswer();
    }
}