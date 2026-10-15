package Module2.Inheritance.Application;

import Module2.Inheritance.NewQuizDesignDemo.MultipleChoiceQuestion;
import Module2.Inheritance.NewQuizDesignDemo.TrueFalseQuestion;
import Module2.Inheritance.NewQuizDesignDemo.Question;

// import Module2.Inheritance.QuizDesign.*;

public class Quiz {
    

    public static void main(String[] args) {
        // create a multiple choice question
        String[] options = {"A", "B", "C", "D"};
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(
            "MCQ1",
            "What is the capital of France?",
            options,
            1,
            5,
            false);

        
        // update MCQ1 points
        mcq.setPoints(10);


        // create a true/false question
        TrueFalseQuestion tfq = new TrueFalseQuestion("TFQ1", "The Earth is flat.", false, 3, false);

        // check answers for the multiple choice question
        System.out.println("MCQ Answer Correct: " + mcq.isAnswerCorrect(1)); // true
        System.out.println("MCQ Answer Correct: " + mcq.isAnswerCorrect(2)); // false

        // check answers for the true/false question
        System.out.println("TFQ Answer Correct: " + tfq.isAnswerCorrect(false)); // true
        System.out.println("TFQ Answer Correct: " + tfq.isAnswerCorrect(true)); // false

        // Question is abstract, so it cannot be instantiated. Uncomment the
        // next line to see the compiler reject it:
        //    "Question is abstract; cannot be instantiated"
        // Question q = new Question();
    }
}
