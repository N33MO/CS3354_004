package Module2.Inheritance.NewQuizDesignDemo;

public class TrueFalseQuestion extends Question {
    private Boolean answer;

    public TrueFalseQuestion(String title, String stem, Boolean answer, Integer points, Boolean showOnScreenCalculator) {
        super(title, stem, points, showOnScreenCalculator);
        this.answer = answer;
    }

    // getter and setter methods for the instance variables not inherited from the superclass
    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    // check if the answer is correct
    @Override 
    public Boolean isAnswerCorrect(Object userAnswer) {
        return userAnswer instanceof Boolean && userAnswer.equals(answer);
    }

}