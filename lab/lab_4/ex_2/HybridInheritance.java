package lab.lab_4.ex_2;

/**
 * The base class in our hierarchy.
 * Represents a generic animal with a simple behavior.
 */
class Animal {
    public void eat() {
        System.out.println("The animal is eating.");
    }
}

/**
 * An interface to represent a pet's behavior.
 * This will be part of the multiple inheritance aspect.
 */
interface Pet {
    void play();
}

/**
 * Another interface to represent a companion's behavior.
 * This also contributes to the multiple inheritance aspect.
 */
interface Companion {
    void beLoyal();
}

/**
 * A subclass that inherits from Animal.
 * This is the first level of our multilevel inheritance.
 */
class Dog extends Animal {
    public void bark() {
        System.out.println("The dog is barking.");
    }
}

/**
 * The final class in our hybrid inheritance structure.
 * It extends the Dog class (multilevel inheritance) and
 * implements the Pet and Companion interfaces (multiple inheritance).
 */
class GoldenRetriever extends Dog implements Pet, Companion {

    @Override
    public void play() {
        System.out.println("The golden retriever loves to play fetch.");
    }

    @Override
    public void beLoyal() {
        System.out.println("The golden retriever is a loyal companion.");
    }

    // A specific method for the GoldenRetriever class
    public void swim() {
        System.out.println("The golden retriever is swimming.");
    }
}

/**
 * The main class to demonstrate hybrid inheritance.
 * This class creates an object of the GoldenRetriever class and
 * calls methods from all the inherited and implemented classes/interfaces.
 */
public class HybridInheritance {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating Hybrid Inheritance ---");

        GoldenRetriever myDog = new GoldenRetriever();

        System.out.println("\nCalling methods inherited from the Animal class:");
        myDog.eat(); // Method from Animal

        System.out.println("\nCalling methods inherited from the Dog class:");
        myDog.bark(); // Method from Dog

        System.out.println("\nCalling methods implemented from the Pet interface:");
        myDog.play(); // Method from Pet interface

        System.out.println("\nCalling methods implemented from the Companion interface:");
        myDog.beLoyal(); // Method from Companion interface

        System.out.println("\nCalling a method specific to the GoldenRetriever class:");
        myDog.swim(); // Method specific to GoldenRetriever
    }
}