package Module1.JavaProgramExample;

/**
 * Shows very basic class usage:
 * <ul>
 *   <li>Four fields with different access scopes (public/private/protected/package-private)</li>
 *   <li>A nested class (a class written inside another class)</li>
 *   <li>A non-public class in the same {@code .java} file</li>
 * </ul>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/JavaProgramExample/MyClassExample.java
 * java Module1.JavaProgramExample.MyClassExample
 * </pre>
 *
 * @date 2026-02-02
 */
public class MyClassExample {

    // Access scopes (also called "access modifiers"):
    // - public: can be used from anywhere.
    public int publicField = 10;

    // - private: can be used only inside this class (MyClassExample).
    private int privateField = 20;

    // - protected: can be used inside this package (Module1.JavaProgramExample),
    //   and also in subclasses (you can ignore subclasses for now).
    protected int protectedField = 30;

    // - package-private (no keyword): can be used only inside this package.
    int packagePrivateField = 40;

    public static void main(String[] args) {
        MyClassExample demo = new MyClassExample();

        // Inside the same class, we can use ALL fields (even private).
        demo.publicField += 1;
        demo.privateField += 1;
        demo.protectedField += 1;
        demo.packagePrivateField += 1;

        System.out.println("Inside MyClassExample:");
        System.out.println("  publicField = " + demo.publicField);
        System.out.println("  privateField = " + demo.privateField);
        System.out.println("  protectedField = " + demo.protectedField);
        System.out.println("  packagePrivateField = " + demo.packagePrivateField);

        // Nested class usage (class inside a class).
        MyNestedClass nested = new MyNestedClass();
        nested.sayHello();

        // Non-public class usage (another class in the SAME .java file).
        SameFileFriend friend = new SameFileFriend();
        friend.showWhatICanAccess(demo);
    }

    public static class MyNestedClass {
        public void sayHello() {
            System.out.println("Hello, Nested World!");
        }
    }

    // This method exists so other classes can "see" the private value safely,
    // since they cannot access privateField directly.
    public int getPrivateField() {
        return privateField;
    }
}

// Non-public class in the same .java file (no "public" keyword here).
class SameFileFriend {
    public void showWhatICanAccess(MyClassExample demo) {
        System.out.println("Inside SameFileFriend (same package, different class):");
        System.out.println("  publicField = " + demo.publicField);
        System.out.println("  protectedField = " + demo.protectedField);
        System.out.println("  packagePrivateField = " + demo.packagePrivateField);

        // This would NOT compile, because privateField is private to MyClassExample:
        // System.out.println("  privateField = " + demo.privateField);

        // But we can still read it using a public method:
        System.out.println("  privateField (via getter) = " + demo.getPrivateField());
    }
}

