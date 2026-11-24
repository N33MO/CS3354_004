package module6.grade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit 6 tests for StudentGrade.
 *
 * This class is useful for demonstrating:
 * - basic @Test methods
 * - assertEquals() for return values
 * - boundary testing
 * - exception testing
 */
class StudentGradeTest {
    private static final double DELTA = 0.0001;

    @Test
    void constructor_shouldStoreStudentNameScoreAndLetterGrade() {
        // Arrange
        StudentGrade student = null;
        assertNull(student);

        student = new StudentGrade("Jordan", 92.5);
        assertNotNull(student);

        // Act
        String name = student.getName();
        double score = student.getScore();
        String letterGrade = student.getLetterGrade();

        // Assert
        assertAll(
            () -> assertNotNull(name),
            () -> assertEquals("Jordan", name),
            () -> assertFalse(name.isBlank()),
            () -> assertEquals(92.5, score, DELTA),
            () -> assertEquals("A", letterGrade)
        );
    }

    @Test
    void constructor_shouldThrowExceptionWhenNameIsNull() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade(null, 85.0)
        );

        assertEquals("Student name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenNameIsBlank() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade("   ", 85.0)
        );

        assertEquals("Student name cannot be null or blank.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenScoreIsBelowZero() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade("Jordan", -1.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void constructor_shouldThrowExceptionWhenScoreIsAbove100() {
        // Arrange, Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new StudentGrade("Jordan", 101.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void isPassing_shouldReturnTrueForScoreAtOrAbove60() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 60.0);

        // Act and Assert
        assertTrue(student.isPassing());
    }

    @Test
    void isPassing_shouldReturnFalseForScoreBelow60() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 59.99);

        // Act and Assert
        assertFalse(student.isPassing());
    }

    @ParameterizedTest
    @CsvSource({
        "100.0, A",
        "95.5, A",
        "90.0, A",
        "89.99, B",
        "80.0, B",
        "79.99, C",
        "70.0, C",
        "69.99, D",
        "60.0, D",
        "59.99, F",
        "0.0, F"
    })
    void getLetterGrade_shouldReturnExpectedLetterForScore(double score, String expectedLetterGrade) {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", score);

        // Act
        String actualLetterGrade = student.getLetterGrade();

        // Assert
        assertEquals(expectedLetterGrade, actualLetterGrade);
    }

    @Test
    void getLetterGrade_shouldThrowExceptionWhenScoreIsBelowZero() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 85.0);

        // Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.getLetterGrade(-1.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void getLetterGrade_shouldThrowExceptionWhenScoreIsAbove100() {
        // Arrange
        StudentGrade student = new StudentGrade("Jordan", 85.0);

        // Act, Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.getLetterGrade(101.0)
        );

        assertEquals("Score must be between 0 and 100.", exception.getMessage());
    }
}
