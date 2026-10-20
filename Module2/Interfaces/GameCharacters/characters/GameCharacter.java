package Module2.Interfaces.GameCharacters.characters;

// GameCharacter Class

import Module2.Interfaces.GameCharacters.skills.Flyable;
import Module2.Interfaces.GameCharacters.skills.Swimmable;
import Module2.Interfaces.GameCharacters.skills.Teleportable;

// Each character declares only the skills it actually has (see Mermaid,
// Wizard, Superhero). Pushing every skill onto the base class instead looks
// tempting, but try it to see why it is wrong -- replace the declaration
// below with:
//
//    public abstract class GameCharacter implements Flyable, Swimmable, Teleportable {
//
// Now EVERY character must implement all five skill methods, so a Mermaid is
// forced to fly() and land(), and a Wizard is forced to swim(). That is
// interface pollution: the base class promises behavior its subclasses do
// not have.
public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    
    public GameCharacter(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public void attack() {
        System.out.println(name + " is attacking!");
    }

    public void defend() {
        System.out.println(name + " is defending!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // additional settersand getters for level and health fields
}


