import java.util.ArrayList;
/**
 * The CampusMap class represents a map of campus buildings
 * Users can add, remove, and list buildings on the map.
 */
public class CampusMap {

    ArrayList < Building > buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList < Building > ();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * This method returns a string representation of the campus map. It lists all buildings with their addresses.
     * 
     * @return A formatted directory of buildings on the campus map.
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }
    /**
     * The main method for testing the CampusMap class.
     * Initializes a campus map, adds buildings, and prints the map directory.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Ziskind House", "1 Henshaw Ave Northampton, MA 01063", 3, true, true));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Museum of Art", "20 Elm Street Northampton, MA 01063"));
        myMap.addBuilding(new House("Tyler House", "164 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Hubbard House", "3 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("144 Green Street Northampton, MA 01063"));
        myMap.addBuilding(new Building("Wright Hall", "5 Chapin Way Northampton, MA 01063"));
        myMap.addBuilding(new Cafe("Compass", "7 Neilson Drive Northampton, MA 01063"));
        myMap.addBuilding(new Library("Alumnae Gymnasium", "83 Green Street Northampton, MA 01063"));

        System.out.println(myMap);
    }

}