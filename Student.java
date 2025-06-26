
/**

The Student class represents a student who is snacking at a SnackBar.

Each student has a favorite flavor of crisps, a unique student ID number,

a Pocket containing Penny coins, and a PackOfCrisps that they have purchased.

@author [Smit Chaudhari]

@version [1]

@since [09/12/2022]
*/
public class Student {
// Static field to keep track of the next student ID number
private static int STUDENT_ID = 0;

// Fields for a Student object
private String favCrisps; // The student's favorite crisp flavor
private String idnum; // The student's unique ID number
private SnackMachine snacks; // The SnackMachine the student is using
private Pocket studentPocket; // The student's Pocket of Penny coins
private PackOfCrisps boughtPack; // The PackOfCrisps the student has purchased

/**

Constructor for a Student object.
@param flavour The student's favorite crisp flavor.
@param machine The SnackMachine the student is using.
*/
public Student(String flavour, SnackMachine machine) {
favCrisps = flavour;
// Increment the static STUDENT_ID field and create the student's ID number
STUDENT_ID++;
idnum = "Student No. " + STUDENT_ID;
snacks = machine;
// Initialize the student's Pocket with 20 Penny coins
studentPocket = new Pocket(20);
// Initialize the boughtPack field as null
boughtPack = null;
}
/**

Private helper method for a student to buy a PackOfCrisps from the SnackMachine.
*/
private void buyCrisps() {
// Check if there are any packs of the student's favorite flavor in the SnackMachine
if (snacks.countPacks(favCrisps) == 0) {
System.out.println(idnum + " there are no " + favCrisps + " flavoured crisps left in the machine!");
}
// Check if the student has enough money to buy a pack of crisps
else if (studentPocket.pennyCount() < snacks.getCost()) {
System.out.println(idnum + " doesn't have enough money to buy a pack!");
}
// Otherwise, the student has enough money and the SnackMachine has their favorite flavor
else {
// Remove a Penny from the student's Pocket and insert it into the SnackMachine
snacks.insertMoney(studentPocket.removePenny());
// Buy a pack of the student's favorite flavor from the SnackMachine
snacks.buyPack(favCrisps);
boughtPack = snacks.buyPack(favCrisps);
}
}
/**

Method to simulate a student snacking.
The student may buy a PackOfCrisps, open a previously bought pack,
eat a crisp from an open pack, or do nothing if they have no crisps.
*/
    public void snackTime()
    {
        if (boughtPack == null)
        {
            System.out.println ( idnum + " is buying a pack of crisps.");
            buyCrisps();
            boughtPack = new PackOfCrisps(favCrisps);
        }
        else if (boughtPack != null && boughtPack.isClosed())
        {
            System.out.println ( idnum + " is opening the packet.");
            boughtPack.open();
        }
        else if (boughtPack != null && boughtPack.isEmpty())
        {
            boughtPack = null;
            System.out.println ( idnum + "  has finished the packet!");
        }
        else if (boughtPack != null)
        {
            System.out.println ( idnum + " is eating their favourite " + favCrisps + " flavoured crisp!");
            boughtPack.eatCrisp();
        }
    }
}
