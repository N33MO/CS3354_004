package Module3.composition;

import java.util.ArrayList;
import java.util.List;

/**
 * COMPOSITION  (filled diamond:  House <*>---- Room)
 *
 * The strongest "has-a": the whole OWNS its parts exclusively.
 *  - A Room belongs to exactly one House.
 *  - The House creates its own Rooms -- callers hand over data, never objects.
 *  - No code outside the House can build or keep a Room, so when the House
 *    is gone, its Rooms are gone with it.
 *
 * Compare with Module3.aggregation, where the parts are created outside and
 * outlive the whole.
 *
 * Run from the repository root:
 *   javac Module3/composition/Composition.java
 *   java Module3.composition.Composition
 */
class House {
    private final String address;
    private final List<Room> rooms = new ArrayList<>();

    public House(String address) {
        this.address = address;
    }

    /** Note the parameters: a name and a size, NOT a Room object. */
    public void addRoom(String name, double areaSqM) {
        rooms.add(new Room(name, areaSqM));   // the House builds the part itself
    }

    public double totalFloorArea() {
        double total = 0;
        for (Room r : rooms) {
            total += r.getAreaSqM();
        }
        return total;
    }

    public String describe() {
        StringBuilder sb = new StringBuilder(address + " has " + rooms.size() + " rooms:");
        for (Room r : rooms) {
            sb.append("\n  - ").append(r.getName()).append(" (").append(r.getAreaSqM()).append(" m2)");
        }
        return sb.toString();
    }

    /**
     * Room is a non-static inner class with a private constructor. Both choices
     * enforce the ownership:
     *   - inner  -> a Room instance always belongs to some House instance
     *   - private constructor -> only House can create one
     */
    class Room {
        private final String name;
        private final double areaSqM;

        private Room(String name, double areaSqM) {
            this.name = name;
            this.areaSqM = areaSqM;
        }

        public String getName() {
            return name;
        }

        public double getAreaSqM() {
            return areaSqM;
        }
    }
}

public class Composition {
    public static void main(String[] args) {
        House house = new House("12 Oak Street");
        house.addRoom("Kitchen", 14.5);
        house.addRoom("Bedroom", 18.0);

        System.out.println(house.describe());
        System.out.println("Total floor area: " + house.totalFloorArea() + " m2");

        // Neither of these compiles -- try uncommenting them:
        //   Room r = new Room("Garage", 20.0);   // Room is not visible out here
        //   house.new Room("Garage", 20.0);      // the constructor is private
        //
        // Because nothing outside can hold a Room, losing the House loses the
        // Rooms too. There is no way to keep one alive.
        house = null;
        System.out.println("\nHouse demolished -- its Rooms went with it.");
    }
}
