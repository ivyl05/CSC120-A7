/**
 * The Cafe class is a subclass of the Building Class. It sells coffeee and restocks inventory if needed.
 * 
 * @author Ivy Li
 * @version 11/06/2024
 */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Overloaded method 1
     * Constructs a Cafe instance with a specified name and address, initializing inventory values to zero.
     * 
     * @param name The name of the cafe.
     * @param address The address of the cafe.
     */

    public Cafe(String name, String address) {
        super(name, address);
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
        System.out.println("You have built a basic cafe: ☕");
    }

    /**
     * Overloaded method 2
     * Constructs a Cafe instance with a address only, initializing inventory values to zero.
     * 
     * @param address The address of the cafe.
     */
    public Cafe(String address) {
        super(address);
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
        System.out.println("You have built a basic cafe: ☕");
    }

    /**
     * Full Constructor of Cafe
     * 
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors the cafe has 
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams amount of cream
     * @param nCups number of cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) { //Do we pass in these values? 
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * This method sells a cup of coffee 
     * If there is insufficient inventory, it will attempt to restock.
     * 
     * @param size Coffe size
     * @param nSugarPackets number of sugar packets
     * @param nCreams amount of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets &&
            this.nCreams >= nCreams && this.nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
            System.out.println("Coffee sold!");
        } else {
            System.out.println("Not enough inventory to sell coffee. Restocking...");
            restock(size, nSugarPackets, nCreams, 1);
        }
    }

    /**
     * Restocks the cafe's inventory 
     * 
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams amount of cream
     * @param nCups number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Override method
     * Go to a floor directly. User cannot go because cafe does not have an elevator. 
     * 
     * @param floorNum the floor number that user want to go to
     * @throws RuntimeException Cafe does not have an elevator.
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
        }
        throw new RuntimeException("Cannot use this method because the cafe does not have an elevator.");
    }
    /**
     * Override method
     * Show the options a user have in the cafe. 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + sellCoffee(size, nSugarPackets, nCreams)\n + exit() \n");
    }

    /**
     * The main method tests the program.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass", "1 ave", 1, 100, 20, 10, 10);
        compass.showOptions();
        compass.enter();
        compass.goToFloor(1);
    }

}