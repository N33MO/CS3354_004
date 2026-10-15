package Module2.Inheritance.NewQuizDesignDemo;

public abstract class Question {
    private String title;
    private String stem;
    private Integer points;
    private Boolean showOnScreenCalculator;

    public Question() {
        this.title = "";
        this.stem = "";
        this.points = 0;
        this.showOnScreenCalculator = false;
    }

    public Question(String title, String stem, Integer points, Boolean showOnScreenCalculator) {
        this.title = title;
        this.stem = stem;
        this.points = points;
        this.showOnScreenCalculator = showOnScreenCalculator;
    }

    // getter and setter methods for the instance variables
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        // Ensure that points is non-negative
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        }
        this.points = points;
    } 

    public Boolean getShowOnScreenCalculator() {
        return showOnScreenCalculator;
    }

    public void setShowOnScreenCalculator(Boolean showOnScreenCalculator) {
        this.showOnScreenCalculator = showOnScreenCalculator;
    }

    // check if the answer is correct
    public abstract Boolean isAnswerCorrect(Object userAnswer);
}
