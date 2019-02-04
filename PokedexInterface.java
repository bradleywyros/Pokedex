public interface PokedexInterface{

	//STUDENTS:  DO NOT ALTER.  THIS WILL BE USED TO TEST YOUR CODE


	//	Return all the names of the Pokemon species in the Pokedex
	public String[] listPokemon();


	/*	
		Add a Pokemon to the Pokedex and return true if it was
		successful. If not, return false.
	*/
	public boolean addPokemon(String species);


 	/*
		Return the stats of a certain Pokemon that you are  
 		searching for. The stats will be attack, defense, then speed
 		in that order within the array that will be returned.
	 */
	public int[] checkStats(String species);


	//	Sort Pokedex in lexical order (alphabetical) according to the species names.
	public void sortPokedex();
	

	/*
		Evolve a certain Pokemon by tripling the speed stat,
		doubling the attack stat, and quadrupling the defense stat.
		Return true if the evolve was successful.
		If not, return false.
	*/
	public boolean evolvePokemon(String species);


}