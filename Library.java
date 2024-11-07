import java.util.Hashtable;

/**
 * The Library class is a subclass of the Building class
 * It has methods that allow you to add/remove titles, checkout/return items, 
 * and print out the entire collection in the library. 
 * 
 * @author Ivy Li
 * @version 11/6/2024
 */
public class Library extends Building {

    private Hashtable < String, Boolean > collection; // The collection stores the titles and its availability. 
    private boolean elevator; //Indicates if the library has an elevator

    /**
     * Overloaded method 1
     * Constructs a library instance with a specified name, address, number of floors, whether it has an elevator
     * and a pre-existed collection.
     * 
     * @param name name of library
     * @param address address of library
     * @param nFloors number of floors of library
     * @param elevator whether library has an elevator
     * @param collection pre-existed collection
     */
    public Library(String name, String address, int nFloors, boolean elevator, Hashtable < String, Boolean > collection) {
        super(name, address, nFloors);
        this.collection = collection;
        this.elevator = elevator;

        System.out.println("You have built a library with existing collection: 📖");
    }

    /**
     * Overloaded method 2
     * Constructs a library instance with specified name and address only, and the library does not have an elevator.
     * 
     * @param name Library name 
     * @param address Library address
     */
    public Library(String name, String address) {
        super(name, address);
        this.collection = new Hashtable < String, Boolean > ();
        this.elevator = false;

        System.out.println("You have built a library without elevator: 📖");
    }

    /**
     * Constructs a library instance with name, address, and number of floors of the library.
     * 
     * @param name name of library
     * @param address address of library
     * @param nFloors number of floors of this library
     * @param elevator whether this library has an elevator
     */
    public Library(String name, String address, int nFloors, boolean elevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable < String, Boolean > ();
        this.elevator = elevator;

        System.out.println("You have built a library: 📖");
    }

    /**
     * This method allows us to add new titles. 
     * If a title already exist, it will not be added again. 
     * 
     * @param title title of the book
     */
    public void addTitle(String title) { //exception //do we need to consider having multiple books that are the same? do we need if statement to check?
        if (!this.collection.containsKey(title)) {

            this.collection.put(title, true);
            System.out.println(title + " is added.");
        } else {
            System.out.println("Cannot be added. This title already exist.");
        }

    }

    /**
     * This method allows us to remove a title.
     * 
     * @param title title of the book 
     * @return the title that was removed
     * @throws NullPointerException if the title does not exist. 
     */
    public String removeTitle(String title) {
        if (this.collection.containsKey(title)) {
            this.collection.remove(title);
            System.out.println(title + " is removed.");
            return title;
        } else {
            throw new NullPointerException("This item does not exist.");
        }
    }

    /**
     * This method allows us to checkout a book.
     * The title will be marked as unavailable if checked out successfully.
     * 
     * @param title title of the book
     * @throws NullPointerException if the title does not exist in the collection. 
     */

    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                this.collection.put(title, false);
                System.out.println(title + " is checked out successfully.");
            } else {
                System.out.println(title + " is checked out already. Not available for checking out.");
            }
        } else {
            throw new NullPointerException(title + " does not exist.");
        }
    }

    /**
     * This method allows us to return a book.
     * If the book is available in the collection, it cannot be returned again. 
     * 
     * @param title title of the book
     * @throws NullPointerException if the title doesn't exist in the collection. 
     */
    public void returnBook(String title) {
        if (this.collection.containsKey(title)) {
            if (!this.collection.get(title)) {
                this.collection.put(title, true);
                System.out.println(title + " is returned.");
            } else {
                System.out.println(title + " is already returned. Not availble for return.");
            }
        } else {
            throw new NullPointerException("This item doesn't exist.");
        }
    }

    /**
     * This method check if a book exist in the collecion. 
     * 
     * @param title title of the book
     * @return true if the title appears as a key in the Libary's collection, false otherwise
     */
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    /**
     * This method check if a book is available. 
     * @param title title of the book
     * @return true if the book is available, false otherwise
     * @throws NullPointerException if the book doesn't exist in the collection. 
     */
    public boolean isAvailable(String title) {
        if (this.collection.containsKey(title)) {
            return this.collection.get(title);
        } else {
            throw new NullPointerException("This item does not exist.");
        }
    }

    /**
     * This code is AI generated. 
     * This method prints the entire collection of titles with their availability status.
     */
    public void printCollection() {
        for (String title: this.collection.keySet()) { //The for loop access each of the keys of the collection
            String status = this.collection.get(title) ? "Available" : "Checked Out"; //String status will be "available" if this.collection.get(title) return true, and "checked out" if returns false.
            System.out.println(title + ": " + status); //This prints out the title and whether it is available.
        }
    }

    /**
     * Override method
     * This method allow users to go to a floor directly if it has elevator. 
     * 
     * @param floorNum floor number user wish to go to.
     * @throws RuntimeException if the house does not have an elevator, if the user is not inside the building,
     * or if the floor number is out of range.
     */
    public void goToFloor(int floorNum) {
        if (elevator == false) {
            throw new RuntimeException("Cannot use this method because this library does not have an elevator.");
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
     * Show the options a user have in the Library. 
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + checkOut(title)\n + returnBook(title)\n + addTitle(title)\n + removeTitle(title)");
    }

    /**
     * The main method tests the program.
     *
     * @param args 
     */
    public static void main(String[] args) {
        Hashtable < String, Boolean > bookCollection = new Hashtable < > ();
        bookCollection.put("book1", true);
        bookCollection.put("book2", true);
        Library neilson = new Library("Neilson", "1 ave", 4, true, bookCollection);
        neilson.showOptions();
        neilson.enter();
        neilson.goToFloor(1);
    }

}