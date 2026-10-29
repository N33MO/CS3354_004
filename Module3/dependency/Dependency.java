package Module3.dependency;

/**
 * DEPENDENCY  (dashed arrow:  ZooApp - - -> Animal)
 *
 * The weakest relationship of all: one class merely USES another, briefly,
 * without keeping it.
 *  - ZooApp has no Animal field -- nothing is stored.
 *  - The Animal arrives as a method parameter and is forgotten when
 *    printAnimalName returns.
 *  - Change Animal's public methods and ZooApp may stop compiling; that is
 *    the "depends on" part. But at runtime ZooApp holds nothing.
 *
 * A dependency also appears when a class is used as a return type, a local
 * variable, or a static call -- anywhere except as stored state.
 *
 * Contrast with the three "has-a" relationships, which all keep a reference:
 *   association  -- Student and Course each store the other
 *   aggregation  -- Team stores Players created elsewhere
 *   composition  -- House stores Rooms it created itself
 *
 * Run from the repository root:
 *   javac Module3/dependency/Dependency.java
 *   java Module3.dependency.Dependency
 */
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ZooApp {
    public void printAnimalName(Animal a) {   // Animal is only used as a parameter
        System.out.println("Animal: " + a.getName());
    }
}

public class Dependency {
    public static void main(String[] args) {
        ZooApp app = new ZooApp();

        Animal simba = new Animal("Simba");
        app.printAnimalName(simba);

        // The same ZooApp serves a different Animal. It kept nothing from the
        // first call, because it has no field to keep it in -- each call is
        // completely independent.
        app.printAnimalName(new Animal("Nala"));

        // There is no app.getAnimal(): ZooApp never owned or stored one.
        System.out.println("ZooApp holds no Animal between calls.");
    }
}
