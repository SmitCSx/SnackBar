import java.util.ArrayList;
import java.util.Random;
/**

The {@code SnackBar} class represents a snack bar with a snack machine and a list of students.

The snack bar advances in discrete time steps. At each step, a random student becomes active,

buys a pack of crisps from the snack machine, or eats a crisp from the pack they already have,

and then goes back into a state of inactivity. Students may eventually run out of money or the

snack machine may run out of their favourite flavour of crisps, but they keep on trying to buy

packets from time to time anyway.

@author [Smit Chaudhari]

@version [1]

@since [09/12/2022]
*/


public class SnackBar {
    // Fields
    private Random rand;
    private String[] flavours;
    private SnackMachine machine;
    private ArrayList<Student> students;

    // Constructor
    public SnackBar(int numStudents, int numCrisps, int cost) {
        // Initialize fields
        rand = new Random();
        flavours = new String[]{"plain", "salt and vinegar", "cheese and onion", "prawn cocktail"};
        machine = new SnackMachine(numCrisps, cost);
        students = new ArrayList<Student>();
        /**

        Constructs a new SnackBar with a specified number of students, number of crisps in the

        snack machine, and cost of a pack of crisps from the machine.

        @param numStudents the number of students in the snack bar

        @param numCrisps the number of packs of crisps in the snack machine

        @param cost the cost of a pack of crisps from the snack machine
        */

        // Fill SnackMachine with random flavours of crisps
        for (int i = 0; i < numCrisps; i++) {
            String flavour = randomFlavour();
            machine.addPack(new PackOfCrisps(flavour));
        }

        // Fill students list with new students
        for (int i = 0; i < numStudents; i++) {
            String flavour = randomFlavour();
            students.add(new Student(flavour, machine));
        }
    }
        /**

        Selects a random flavour from the list of available flavours.
        @return a random flavour from the list of available flavours
        */

    // Select a random flavour from the flavours array
    private String randomFlavour() {
        int index = rand.nextInt(flavours.length);
        return flavours[index];
    }
    /**

        Describes the state of the snack bar by printing the number of hungry students and the contents of the snack machine.
        */
    // Describe the state of the SnackBar
     public void describe()
    {
        System.out.println ("The SnackBar has " + students.size() + " hungry students" );
        System.out.println ("The SnackMachine has: ");
        System.out.println (machine.countPacks("plain") + " packets of plain crisps,");
        System.out.println (machine.countPacks("salt and vinegar") + " packets of salt and vinegar crisps,");
        System.out.println (machine.countPacks("cheese and onion") + " packets of cheese and onion crisps,");
        System.out.println (machine.countPacks("prawn cocktail") + " packets of prawn cocktail crisps.");
    }
    /**

    Runs the SnackBar for a given number of time steps. At each step, a random student is selected and their {@link Student#snackTime() snackTime} method is invoked.

    @param nSteps the number of time steps to run the SnackBar for.
        */
    // Run the SnackBar for a given number of time steps
    public void runSnackBar(int nSteps) {
        for (int i = 1; i <= nSteps; i++) {
            System.out.println("Time Step " + i);
            describe();

            // Select a random student and have them snack
            int index = rand.nextInt(students.size());
            Student student = students.get(index);
            student.snackTime();
        }
    }
    /**

        The main method creates a new {@link SnackBar} with 10 students, 20 packets of crisps, and a cost of 10 coins per packet.
        It then runs the SnackBar for 20 time steps.
        @param args command line arguments (not used)
        */
    public static void main(String[] args) {
        SnackBar sb = new SnackBar(10, 20, 10);
        sb.runSnackBar(20);
    }

}

