package sk.mihacodes.model;

/**
 * This class is responsible for generating random numbers in range from 1 to 6.
 * @author haska
 *
 */
public class RollModel {

	// Returns the integer random number in range 1-6
	public int roll() {
		return (int) ((Math.random() * 6) + 1);
	}

}
