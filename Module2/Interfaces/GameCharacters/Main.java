package Module2.Interfaces.GameCharacters;

import Module2.Interfaces.GameCharacters.characters.GameCharacter;
import Module2.Interfaces.GameCharacters.characters.Mermaid;
import Module2.Interfaces.GameCharacters.characters.Superhero;
import Module2.Interfaces.GameCharacters.characters.Wizard;
import Module2.Interfaces.GameCharacters.skills.Flyable;
import Module2.Interfaces.GameCharacters.skills.Swimmable;
import Module2.Interfaces.GameCharacters.skills.Teleportable;

public class Main {
    public static void main(String[] args) {
        // Creating instances of each character type
        Wizard harry = new Wizard("Harry", 10, 100, 80);
        Mermaid ariel = new Mermaid("Ariel", 8, 90, 1.5);
        Superhero superman = new Superhero("Superman", 15, 120, "Super Strength");

        // Wizard actions
        System.out.println("\n----- Wizard Actions -----");
        harry.castSpell();
        harry.attack();
        harry.fly();
        harry.teleport(5, 7);
        harry.land();

        // Mermaid actions
        System.out.println("\n----- Mermaid Actions -----");
        ariel.sing();
        ariel.swim();
        ariel.defend();
        ariel.stopSwimming();

        // Superhero actions
        System.out.println("\n----- Superhero Actions -----");
        superman.saveTheDay();
        superman.attack();
        superman.fly();
        superman.teleport(10, 10);
        superman.land();
        superman.swim();
        superman.stopSwimming();
        
        // Polymorphism: Treating all game characters uniformly
        System.out.println("\n----- Polymorphism: Treating all game characters uniformly -----");
        performActions(harry);
        performActions(ariel);
        performActions(superman);
    }
    
    // Example of using polymorphism to apply actions on any GameCharacter type
    public static void performActions(GameCharacter character) {
        character.attack();
        character.defend();
        
        // Check for additional capabilities and perform them
        if(character instanceof Flyable) {
            ((Flyable) character).fly();
            ((Flyable) character).land();
        }
        if(character instanceof Swimmable) {
            ((Swimmable) character).swim();
            ((Swimmable) character).stopSwimming();
        }
        if(character instanceof Teleportable) {
            ((Teleportable) character).teleport(3, 4);
        }
    }
}
