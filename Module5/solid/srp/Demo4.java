package Module5.solid.srp;

public class Demo4 {
    
}

/**
 * The class below violates SRP. Given the design requirements, how 
 * would you refactor it?
 * 
 * 1. The GPA calculation formula will change — the school is adopting a
 * weighted grading scale next semester.
 * 
 * 2. The school is migrating from a local MySQL database to a cloud 
 * storage solution.
 * 
 * 3. The transcript layout will be redesigned by the registrar's 
 * office.
 * 
 * 4. The notification channel may switch from email to SMS in the 
 * future.
 */
// BEFORE
class StudentRecord {

    public double calculateGPA() {
        return grades.stream()
            .mapToDouble(Grade::getScore).average().orElse(0.0);
    }

    public void saveToDatabase() {
        db.save(this);
    }

    public void printTranscript() {
        System.out.println("Student: " + name + ", GPA: " + calculateGPA());
    }

    public void sendNotification() {
        emailClient.send(email, "Your transcript is ready.");
    }
}

// AFTER
// owned by: academics
class StudentRecord {
    public double calculateGPA() {
    return grades.stream()
        .mapToDouble(Grade::getScore).average().orElse(0.0);
    }
}
// owned by: IT/DBA
class StudentRepository {
    public void save(StudentRecord student) {
        db.save(student);
    }
}
// owned by: registrar
class TranscriptPrinter {
    public void print(
        StudentRecord s) {
        System.out.println(
            "Student: " + s.getName()+ ", GPA: " + s.calculateGPA()
        );
    }
}
// owned by: communications
class NotificationService {
    public void notify(StudentRecord s) {
        emailClient.send(s.getEmail(),"Your transcript is ready.");
    }
}