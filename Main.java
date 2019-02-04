/*This is the main class of the program. It interacts with
the Pokedex Class to manipulate the size of the Pokedex,
to arrange the Pokedex, and to add Pokemon to the Pokedex as well
as level up the Pokemon within it*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    static Pokedex pokedex; // Pokedex object
    static Scanner scan = new Scanner(System.in); // scanner for user input

    // MAIN
    public static void main(String[] args) {
        int pokeDexSize = 0; // Size of the array in the Pokedex class
        int menuChoice; // user menu choice
        boolean isAnError = false; // if input error, set to true
        boolean repeatMenu = true; // always true so the menu will always repeat

        System.out.println("Welcome to your new PokeDex!");
        while(!isAnError) { // If input error, ask again

            try {
                System.out.print("How many Pokemon are in your region?: ");
                pokeDexSize = scan.nextInt();

                if (pokeDexSize < 0) { // Pokedex cannot be negative
                    displayError();
                    isAnError = false;
                } else {
                    pokedex = new Pokedex(pokeDexSize); //Sets the size of the array in the Pokedex class
                    isAnError = true;
                }
            } catch (InputMismatchException e) { // Pokedex must be an integer
                displayError();
                scan.next();
                isAnError = false;
            }
        }
        start(pokeDexSize); // Tells user how big their pokedex is
        isAnError = false; // set back to false for the menu inputs

        while (!isAnError || repeatMenu) {// restarts and loops menu if input error

            try {
                displayMenu();
                menuChoice = scan.nextInt();

                if (menuChoice < 1 || menuChoice > 6){ // if user input is out of range, restart menu
                    displayError();
                    isAnError = false;
                } else {
                    menuSelection(menuChoice);
                    isAnError = true;
                }
            }catch(InputMismatchException e){ // if user input is not a number, restart menu
                displayError();
                scan.next();
                isAnError = false;
            }
        }
    }

    // METHODS
    public static void start(int size){ // States size of pokedex

        System.out.println("\nYour new Pokedex can hold " + size + " Pokemon. Let's start using it!");
    }

    public static void displayMenu(){ // Displays menu options

        System.out.println("");
        System.out.print("1. List Pokemon\n" +
                            "2. Add Pokemon\n" +
                            "3. Check a Pokemon's Stats\n" +
                            "4. Evolve Pokemon\n" +
                            "5. Sort Pokemon\n" +
                            "6. Exit\n\n" +
                            "What would you like to do? ");
    }

    public static void displayError(){// displays error for incorrect input

        System.out.println("\nThat is not a valid choice. Try again.");
    }

   public static void menuSelection(int choice){ // executes menu option

       switch(choice){
           case 1: // List Pokemon
               list();
               break;
           case 2: // Add Pokemon
               add();
               break;
           case 3: // Check a Pokemon's Stats
               stats();
               break;
           case 4: // Evolve Pokemon
               evolve();
               break;
           case 5: // Sort Pokemon
               pokedex.sortPokedex();
               break;
           case 6: // Exit
               System.exit(0);
       }
    }

    public static void list(){ // list the Pokemon in the Pokedex
        String[] array;
        array = pokedex.listPokemon();

        if (array == null) { // if the array is empty, print
            System.out.println("Empty");
        }else{
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + 1 + ". " + array[i]);
            }
        }
    }

    public static void add(){ // add Pokemon to the Pokedex
        String species = "";

        System.out.print("\nPlease enter the Pokemon's Species: ");
        species = scan.next();
        pokedex.addPokemon(species);

    }

    public static void stats(){ // print Pokemon power levels
        String species = "";
        int[] stats;

        System.out.print("\nPlease enter the Pokemon of interest: ");
        species = scan.next();
        stats = pokedex.checkStats(species);

        if (stats == null){ // if Pokemon is not there, print
            System.out.println("Missing");
        }else{
            System.out.println("The stats for " + species + " are:");
            System.out.println("Attack: " + stats[0]);
            System.out.println("Defense: " + stats[1]);
            System.out.println("Speed: " + stats[2]);
        }
    }

    public static void evolve(){ // increases power level of Pokemon
        String species = "";
        boolean evolved; // if the Pokemon evolved or not

        System.out.print("\nPlease enter the Pokemon of interest: ");
        species = scan.next();
        evolved = pokedex.evolvePokemon(species);

        if (evolved){ //if evolve was successful, print
            System.out.println(species + " has Evolved!");
        }else{ //if Pokemon is not there, print
            System.out.println("Missing");
        }
    }
}


