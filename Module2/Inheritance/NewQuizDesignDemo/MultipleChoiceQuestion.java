package Module2.Inheritance.NewQuizDesignDemo;

public class MultipleChoiceQuestion extends Question {
    private String[] options;
    private Integer correctOptionIndex;

    public MultipleChoiceQuestion(String title, String stem, String[] options, Integer correctOptionIndex, Integer points, Boolean showOnScreenCalculator) {
        super(title, stem, points, showOnScreenCalculator);
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    // getter and setter methods for the instance variables not inherited from the superclass
    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public Integer getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(Integer correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    // check if the answer is correct
    @Override 
    public Boolean isAnswerCorrect(Object userAnswerIndex) {
        return userAnswerIndex instanceof Integer && userAnswerIndex.equals(correctOptionIndex);
    }

    public static void main(String[] args) {
        String[] options = {"Option A", "Option B", "Option C", "Option D"};
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("Sample MCQ", "What is the correct option?", options, 1, 5, true);
        
        // Test the isAnswerCorrect method
        System.out.println(mcq.isAnswerCorrect(1)); // true
        System.out.println(mcq.isAnswerCorrect(2)); // false


        System.out.println(mcq);
    }
}
