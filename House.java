import java.util.ArrayList;

/**
 * The House class is a subclass of the Building class
 * It has accessors, methods to move people in/out, and check if a person is a resident.
 * 
 * @author Ivy Li
 * @version 11/6/2024
 */
public class House extends Building {

    private ArrayList < String > residents; // A list of residents living in the house
    private boolean hasDiningRoom; // Indicates if the house has a dining room
    private boolean elevator; //Indicates if the house has an elevator

    /**
     * Overloaded method 1
     * Constructs a House instance with a specified name, address, and number of floors. 
     * It does not have dining room or elevator.
     * 
     * @param name House name
     * @param address House address
     * @param nFloors number of floors of this house
     */
    public House(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.residents = new ArrayList < > ();
        this.hasDiningRoom = false;
        this.elevator = false;
        System.out.println("You have built a basic house: 🏠");
    }

    /**
     * Overloaded method 2
     * Constructs a House instance with a specified name and address. 
     * It does not have dining room or elevator.
     * 
     * @param name House name
     * @param address House address
     */
    public House(String name, String address) {
        super(name, address);
        this.residents = new ArrayList < > ();
        this.hasDiningRoom = false;
        this.elevator = false;
        System.out.println("You have built a basic house: 🏠");
    }

    /**
     * Full constructor
     * Constructs a House instance with the name, address, number of floors,
     * and whether it has a dining room and elevator. 
     * 
     * @param name House name
     * @param address House address
     * @param nFloors number of floors of this house
     * @param hasDiningRoom whether it has a dining room
     * @param elevator whether it has an elevator
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean elevator) {
        super(name, address, nFloors);
        this.residents = new ArrayList < > ();
        this.hasDiningRoom = hasDiningRoom;
        this.elevator = elevator;
        System.out.println("You have built a house: 🏠");
    }

    /**
     * Accessor to get whether the house has a dining rooom. 
     * 
     * @return true if the house has a dining room, false otherwise.
     */
    public boolean getHasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Accessor to get the number of residents in the house.
     * 
     * @return the number of reidents. 
     */
    public int getNResidents() {
        return this.residents.size();
    }

    /**
     * Adds a resident to the house. If the resident already exists, they will not be added again.
     * 
     * @param name name of student moving in
     */
    public void moveIn(String name) {
        if (!this.residents.contains(name)) {
            this.residents.add(name);
            System.out.println(name + " moved in.");
        } else {
            System.out.println("This resident already exist.");
        }
    }

    /**
     * Removes a resident from the house. Throws an exception if the resident is not found.
     * 
     * @param name name of student moving out
     * @return the name of the resident that moved out.
     * @throws NullPointerException if the person is not a resident. 
     */
    public String moveOut(String name) {
        if (this.residents.contains(name)) {
            System.out.println(name + " moved out.");
            this.residents.remove(name);
            return name;
        } else {
            throw new NullPointerException("There is no resident named " + name);
        }
    }

    /**
     * Checks if a specified person is a resident of the house.
     * 
     * @param person name of resident
     * @return true if the person is a resident, false otherwise
     */
    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    /**
     * Override method
     * This method allow users to go to a floor directly if it has elevator. 
     * 
     * @param floorNum the floor that the user wish to go to 
     * @throws RuntimeException if the house does not have an elevator, if the user is not inside the building,
     * or if the floor number is out of range.
     */
    public void goToFloor(int floorNum) {
        if (elevator == false) {
            throw new RuntimeException("Cannot use this method because the house does not have an elevator.");
        }
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Override method
     * Show the options a user have in the house. 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter()\n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(name)\n + moveOut(name)");
    }

    /**
     * The main method tests the program. 
     * 
     * @param args 
     */
    public static void main(String[] args) {
        House ziskind = new House("Ziskind", "1 Henshaw Ave", 3, true, true);
        ziskind.showOptions();
        ziskind.enter();
        ziskind.goToFloor(3);
    }

}