package Module2.Inheritance.NewQuizDesignDemo;

public class EssayQuestion extends Question {
    
    public EssayQuestion(String title, String stem, Integer points, Boolean showOnScreenCalculator) {
        super(title, stem, points, showOnScreenCalculator);
    }

    @Override 
    public Boolean isAnswerCorrect(Object userAnswer) {
        // TODO: grader manually grade
        return false;
    }
}
