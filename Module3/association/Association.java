package Module3.association;

import java.util.ArrayList;
import java.util.List;

/**
 * ASSOCIATION  (plain line:  Student ---- Course)
 *
 * The weakest and most general of the three "has-a" style relationships:
 * two objects simply KNOW ABOUT each other. There is no owner and no part.
 *  - A Course exists before anybody enrolls in it.
 *  - A Student exists without being enrolled in anything.
 *  - Neither one creates or destroys the other.
 *
 * Here the link runs both ways, which a class diagram draws as a plain line
 * between the two classes (an arrowhead would mean only one side knows the
 * other). Contrast with:
 *   - Module3.aggregation -- a Team groups Players it does not own
 *   - Module3.composition -- a House owns Rooms that cannot outlive it
 *
 * Run from the repository root:
 *   javac Module3/association/Association.java
 *   java Module3.association.Association
 */
class Student {
    private final String name;
    private final List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Records the link on both sides. Neither object owns the other. */
    public void enroll(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public String schedule() {
        if (courses.isEmpty()) {
            return name + " is not enrolled in anything";
        }
        StringBuilder sb = new StringBuilder(name + " takes:");
        for (Course c : courses) {
            sb.append(" ").append(c.getCode());
        }
        return sb.toString();
    }
}

class Course {
    private final String code;
    private final String title;
    private final List<Student> roster = new ArrayList<>();

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    void addStudent(Student s) {
        roster.add(s);
    }

    public String describe() {
        StringBuilder sb = new StringBuilder(code + " (" + title + ") enrolls " + roster.size() + ":");
        for (Student s : roster) {
            sb.append(" ").append(s.getName());
        }
        return sb.toString();
    }
}

public class Association {
    public static void main(String[] args) {
        // Each object is built independently -- neither comes from the other.
        Course cs3354 = new Course("CS 3354", "Object-Oriented Design & Programming");
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        System.out.println("Before enrolling:");
        System.out.println("  " + cs3354.describe());
        System.out.println("  " + alice.schedule());

        alice.enroll(cs3354);
        bob.enroll(cs3354);

        System.out.println("\nAfter enrolling:");
        System.out.println("  " + cs3354.describe());
        System.out.println("  " + alice.schedule());

        // Clearing our own variable does NOT break the association: the Course
        // keeps its own reference, so Bob is still on the roster. That is the
        // point of a plain association -- the link is recorded on both sides,
        // and neither side's lifetime controls the other's.
        //
        // Compare the other two demos:
        //   aggregation -- removePlayer unlinks a part that keeps on existing
        //   composition -- no outside reference to a Room can exist at all
        bob = null;
        System.out.println("\nOur 'bob' variable is cleared, but the Course still knows him:");
        System.out.println("  " + cs3354.describe());
    }
}
