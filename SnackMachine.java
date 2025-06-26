import java.util.*;
/**
 * The `SnackMachine` class represents a machine that dispenses packets of crisps.
 * It has a maximum capacity for the number of packets it can hold, and a fixed cost
 * for each packet of crisps. It also keeps track of the total payment it has received
 * from students trying to buy crisps.
 * @author [Smit Chaudhari]

 * @version [1]

 * @since [09/12/2022]
 */
public class SnackMachine {
    private ArrayList<PackOfCrisps> packets; // a list of packets of crisps in the machine
    private int capacity; // the maximum number of packets the machine can hold
    private int cost; // the cost of each packet of crisps
    private int payment; // the total payment the machine has received from students
    private ArrayList<Penny> pennies; // a list of pennies received as payment from students

    /**
     * Constructs a new `SnackMachine` instance with the specified maximum capacity
     * and cost per packet of crisps.
     *
     * @param MAXCapaCity the maximum number of packets the machine can hold
     * @param PACKCOST the cost of each packet of crisps
     */
    public SnackMachine(int MAXCapaCity, int PACKCOST) {
        // initialize fields
        capacity = MAXCapaCity;
        cost = PACKCOST;
        payment = 0;
        pennies = new ArrayList<Penny>();
        packets = new ArrayList<PackOfCrisps>();
    }

    /**
     * Returns the cost of each packet of crisps.
     *
     * @return the cost of each packet of crisps
     */
    public int getCost() {
        return cost;
    }
    /**
     * Adds a {@link PackOfCrisps} to the machine, if the number of packets does not exceed the machine's maximum capacity.
     *
     * @param pack The {@link PackOfCrisps} to be added to the machine.
     */
    public void addPack(PackOfCrisps pack) { 
    if (packets.size() < capacity) {
        packets.add(pack);
    } else {
        System.out.println("capacity reached");
    }
    }

    /**
     * Adds a {@link PackOfCrisps} with the specified flavour to the machine, if the number of packets does not exceed the machine's maximum capacity.
     *
     *   @param pack The flavour of the {@link PackOfCrisps} to be added to the machine.
     */
    public void addPack(String pack) {
        addPack(new PackOfCrisps(pack));
    }

    /**
     * Counts the number of packets in the machine with the specified flavour.
     *
     * @param flavour The flavour of the packets to be counted.
     * @return The number of packets with the specified flavour.
     */
    public int countPacks(String flavour) {
    int counter = 0;
    for (PackOfCrisps element : packets) {
        if (element.getFlavour().equals(flavour)) {
            counter += 1;
        }
    }
    return counter;
    }

    /**
    * Inserts a {@link Penny} into the machine's collection of pennies.
    *
    * @param penny The {@link Penny} to be inserted into the machine.
    */
    public void insertMoney(Penny penny) {
        ++payment;
        pennies.add(new Penny());
            }

    /**
     * Use this method to buy a pack of crisps from the snack machine.
     * @param flavour the flavour of the crisps to buy
     * @return the {@link PackOfCrisps} object that was purchased, or `null` if the purchase failed
     */
    public PackOfCrisps buyPack(String flavour) {
        PackOfCrisps aPack = null; //// aPack is the pack with the flavour you are trying to buy.
    if (payment < cost) {
            System.out.println("Not enough money, please add some more Pennies");
        }
        else {
            int a = 0;
            boolean Flavourfound;
            ///goes through the whole list:
            for(Flavourfound = false; a < packets.size() && !Flavourfound; ++a) {
                /// compares the flavour on index a with the flavour that you want.
                ///when flavour is found gets out of the loop by chagning the boolean to True, causing one condition to fail in the loop.
                if (((PackOfCrisps)packets.get(a)).getFlavour().equals(flavour)) {
                    Flavourfound = true;
                }
               
            }
            ///now it resets the payment to 0 and the specification asked to do so.
            ///it removes aPack(the pack you just bought) from packets.
            if (Flavourfound) {
                payment = 0;
                aPack = (PackOfCrisps)packets.remove(a - 1);
            }
             else {
                    System.out.println("That flavour is not in the Machine yet!!");
                }
        }
        return aPack;
   }
   
   public void describe()
    {
    System.out.println ("The snack machine has " + packets.size() + " packets of crisps left and has taken " + payment + " in payment");
    }
}
