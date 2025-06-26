/**
 * This class represents a pack of crisps, with a flavour and a number of crisps inside.
 * 
 * *@author [Smit Chaudhari]

 *@version [1]

 *@since [09/12/2022]
 */
public class PackOfCrisps {
    private boolean open;
    private int numOfCrisps;
    private String flavour;

    /**
     * Construct a new PackOfCrisps with a given flavour.
     *
     * @param PackFlavour the flavour of the crisps in the pack
     */
    public PackOfCrisps(String PackFlavour) {
        flavour = PackFlavour;
        numOfCrisps = 10;
        open = false;
    }

    /**
     * Check if the pack of crisps is empty.
     *
     * @return true if the pack is empty, false otherwise
     */
    public boolean isEmpty() {
        if (numOfCrisps == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the pack of crisps is closed.
     *
     * @return true if the pack is closed, false otherwise
     */
    public boolean isClosed() {
        if (open == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Open the pack of crisps.
     */
    public void open() {
        open = true;
    }

    /**
     * Get the flavour of the crisps in the pack.
     *
     * @return the flavour of the crisps
     */
    public String getFlavour() {
        return flavour;
    }

    /**
     * Eat one crisp from the pack.
     * If the pack is not open or is empty, this method does nothing.
     */
    public void eatCrisp() {
        if (open == true) {
            numOfCrisps = numOfCrisps - 1;
            System.out.println("you have now " + numOfCrisps + " crisps left");
        } else {
            System.out.println("Need to open the packet first");
        }
        if (isEmpty()) {
            System.out.println("The packet is empty!");
        }
    }
}
