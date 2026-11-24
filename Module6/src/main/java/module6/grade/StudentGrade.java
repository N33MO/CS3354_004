package module6.grade;

/**
 * A simple grading example for teaching return-value testing.
 *
 * This class stores one student's name and numeric score.
 */
public class StudentGrade {
    private final String name;
    private final double score;

    public StudentGrade(String name, double score) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank.");
        }

        validateScore(score);
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getLetterGrade() {
        return getLetterGrade(score);
    }

    public String getLetterGrade(double score) {
        validateScore(score);

        if (score >= 90) {
            return "A";
        }

        if (score >= 80) {
            return "B";
        }

        if (score >= 70) {
            return "C";
        }

        if (score >= 60) {
            return "D";
        }

        return "F";
    }

    public boolean isPassing() {
        return score >= 60;
    }

    private void validateScore(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
    }
}
