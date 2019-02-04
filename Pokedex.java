/*This class is for the Pokedex, which will be an array of objects created
 by the Pokemon class. This class interacts with both Main and Pokemon class.*/

public class Pokedex implements PokedexInterface {

    private Pokemon[] pokemons; // Array of Pokemons objects
    private Pokemon m; // Pokemon object

    public Pokedex() { // Default constructor
        pokemons = null;
    }

    public Pokedex(int size) { // Constructor, sets size of Pokemon object array
        pokemons = new Pokemon[size];
    }

    public String[] listPokemon() { // Return all the names of the Pokemon species in the Pokedex
        String speciesName = ""; // value for

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] != null) //if index is not empty, add Pokemon to the Pokedex
                speciesName += pokemons[i].getSpecies() + " ";
        }
        if (speciesName.equals("")) // if there is no Pokemon, return null
            return null;
        return speciesName.trim().split(" ");
    }

    public boolean addPokemon(String species) { // Adds a Pokemon to the Pokedex
        m = new Pokemon(species); // Creates a specific Pokemon
        int arrlen = pokemons.length; // size of the Pokedex

        if (arrlen == 0 || pokemons[arrlen - 1] != null) { // if Array is full or has length of 0, it's Maxed out
            System.out.println("Max");
            return false;
        }

        for (int i = 0; i < arrlen; i++) { // may need to change logical order
            if (pokemons[i] == null) { // if spot is empty, add pokemon, break loop
                pokemons[i] = m;
                break;
            } else if (pokemons[i].getSpecies().toLowerCase().equals(species.toLowerCase())) { // if Pokemon already exist in the Pokedex, print "Duplicate"
                System.out.println("Duplicate");
                return false;
            }
        }
        return true;
    }

    public int[] checkStats(String species) { // Returns the power levels of a Pokemon

        for (int i = 0; i < pokemons.length; i++) { // Finds the Pokemon in the Pokedex
            if (pokemons[i] != null && pokemons[i].getSpecies().toLowerCase().equals(species.toLowerCase())) { // if pokemon is there, return stats
                int[] stats = {pokemons[i].getAttack(), pokemons[i].getDefense(), pokemons[i].getSpeed()};

                return stats;
            }
        }
        return null;
    }

    public void sortPokedex() {// Sort Pokedex in lexical order according to the species names
        Pokemon temp; // temporary Pokemon, used for swapping

        if (pokemons.length == 0) { // if the array is length 0 or 1, break out of the method
            return;
        } else if (pokemons.length == 1) {
            return;
        }
        // Bubble sorting, method learned from https://mathbits.com/MathBits/Java/arrays/ABCSort.htm
        for (int i = 0; i < pokemons.length - 1; i++) {
            for (int j = i + 1; j < pokemons.length; j++) {
                if (pokemons[j] != null) { // if the next value is not empty, swap the objects
                    if (pokemons[i].getSpecies().compareToIgnoreCase(pokemons[j].getSpecies()) > 0) {                                             // ascending sort
                        temp = pokemons[i];
                        pokemons[i] = pokemons[j];// swapping
                        pokemons[j] = temp;
                    }
                }
            }
        }
    }

    public boolean evolvePokemon(String species) { // evolve the Pokemon by increasing their power levels

        for (int i = 0; i < pokemons.length; i++) { // Loop that finds a Pokemon and evolves them
            if (pokemons[i] != null && pokemons[i].getSpecies().toLowerCase().equals(species.toLowerCase())) { // if pokemon is there, evolve
                pokemons[i].setAttack(2 * pokemons[i].getAttack()); // Doubles attack
                pokemons[i].setDefense(4 * pokemons[i].getDefense()); // Quadruples Defense
                pokemons[i].setSpeed(3 * pokemons[i].getSpeed()); // Triples speed

                return true;
            }
        }
        return false; // if Pokemon is not in Pokedex, return false
    }
}
