package sk.mihacodes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating ArrayList of players names and
 * for getting the names from list.
 * @author haska
 *
 */
public class PlayerModel {

	// Creates the list object
	private List<String> playersList = new ArrayList<String>();

	// Adds String value from methods parameter to the ArrayList
	public void setPlayerList(String playerName) {
			playersList.add(playerName);
	}
	
	// Returns a list of players names
	public List<String> getPlayersList() {
		return playersList;
	}

}
