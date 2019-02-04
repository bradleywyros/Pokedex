/*This class names and sets the level of a particular Pokemon object. This
  class only interacts with the Pokedex class.*/

public class Pokemon {

    private String species; // Type of Pokemon
    private int attack; // Attack level
    private int defense; // Defense level
    private int speed; // Speed level

    public Pokemon(){ // default constructor
        setAttack(0);
        setDefense(0);
        setSpeed(0);
    }

    public Pokemon(String pokemon){ // constructor used when a Pokemon is added to the Pokedex
        setSpecies(pokemon);
        setAttack((species.length() * 7) + 9);
        setDefense((species.length() * 5)+ 17);
        setSpeed((species.length() * 6)+ 13);
    }

    public void setAttack(int newAttack){ // Sets the attack level
        attack = newAttack;
    }

    public void setDefense(int newDefense){ // Sets the defense level
        defense = newDefense;
    }

    public void setSpeed(int newSpeed){ // Sets the speed level
        speed = newSpeed;
    }

    public void setSpecies(String newSpecies){ // Names the Pokemon
        species = newSpecies;
    }

    public int getAttack(){ // Returns the attack level value
        return attack;
    }

    public int getDefense(){// Returns the defense level value
        return defense;
    }

    public int getSpeed(){ // Returns the speed level value
        return speed;
    }

    public String getSpecies(){ // Returns the Pokemon name
        return species;
    }


}
