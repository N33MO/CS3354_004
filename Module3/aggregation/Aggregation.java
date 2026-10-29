package Module3.aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * AGGREGATION  (hollow diamond:  Team <>---- Player)
 *
 * A weaker "has-a" than composition: the whole groups parts it does NOT own.
 *  - A Player is created outside any Team and handed over.
 *  - A Player can leave a Team, join another, or belong to none.
 *  - Disbanding the Team does not destroy its Players.
 *
 * The code difference from composition is the lifecycle, not the shape of the
 * class: addPlayer takes an existing Player object, whereas
 * Module3.composition's House.addRoom only takes data and builds the part
 * itself. Run both mains and compare.
 *
 * Run from the repository root:
 *   javac Module3/aggregation/Aggregation.java
 *   java Module3.aggregation.Aggregation
 */
class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Team {
    private final String name;
    private final List<Player> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    /** Note the parameter: an already-built Player, created by someone else. */
    public void addPlayer(Player p) {
        players.add(p);
    }

    /** Players come and go without being destroyed. */
    public void removePlayer(Player p) {
        players.remove(p);
    }

    public String getName() {
        return name;
    }

    public String roster() {
        if (players.isEmpty()) {
            return name + " has no players";
        }
        StringBuilder sb = new StringBuilder(name + ":");
        for (Player p : players) {
            sb.append(" ").append(p.getName());
        }
        return sb.toString();
    }
}

public class Aggregation {
    public static void main(String[] args) {
        // The Players exist first, on their own. No Team is involved yet.
        Player ana = new Player("Ana");
        Player ben = new Player("Ben");

        Team rockets = new Team("Rockets");
        rockets.addPlayer(ana);
        rockets.addPlayer(ben);
        System.out.println(rockets.roster());

        // Ana leaves. She is removed from the roster, not destroyed.
        rockets.removePlayer(ana);
        System.out.println("After Ana leaves  -> " + rockets.roster());
        System.out.println("Ana still exists  -> " + ana.getName());

        // She can join a different Team -- a part may be shared or reused.
        Team comets = new Team("Comets");
        comets.addPlayer(ana);
        System.out.println(comets.roster());

        // Disband the Rockets entirely. Ben is unaffected: we still hold him.
        rockets = null;
        System.out.println("\nRockets disbanded -- but Ben is still here: " + ben.getName());
    }
}
