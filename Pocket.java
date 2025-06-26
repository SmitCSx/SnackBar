import java.util.HashSet;
import java.util.Iterator;


/**
 * Pocket is a class that represents a collection of Penny objects.
 *
 *@author [Smit Chaudhari]

 *@version [1]

 *@since [09/12/2022]
 */
public class Pocket {
    private HashSet<Penny> pocket ;

    /**
     * Constructs a new Pocket with a given number of Penny objects.
     *
     * @param InitialPennies the number of Penny objects to add to the Pocket
     */
    public Pocket(int InitialPennies){
        pocket = new HashSet<Penny>(InitialPennies);
        for (int a = 0; a < InitialPennies; a++) {
            pocket.add(new Penny());
        }
    }

    /**
     * Returns the number of Penny objects in the Pocket.
     *
     * @return the number of Penny objects in the Pocket
     */
    public int pennyCount(){
        return pocket.size();
    }

    /**
     * Removes a Penny object from the Pocket.
     *
     * @return the removed Penny object, or null if the Pocket is empty
     */
    public Penny removePenny() {
        Iterator<Penny> iterator = pocket.iterator();
        if (iterator.hasNext()) {
            Penny penny = iterator.next();
            iterator.remove();
            return penny;
        }
        return null;
    }
}

