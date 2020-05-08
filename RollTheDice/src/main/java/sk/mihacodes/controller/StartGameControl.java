package sk.mihacodes.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sk.mihacodes.model.PlayerModel;
import sk.mihacodes.view.RollTheDiceView;
import sk.mihacodes.view.iservice.IButton;
import sk.mihacodes.view.iservice.ILabel;

/**
 * This class is event handler for Start Game button. 
 * The object takes two parameters which are passed to the list after button is clicked.
 * The Game main window is opened and Login window is closed after condition is met.
 * @author haska
 *
 */
public class StartGameControl implements EventHandler<ActionEvent>, IButton, ILabel {

	private PlayerModel players = new PlayerModel();
	private RollTheDiceView dv = new RollTheDiceView();

	private TextField player1TF = new TextField();
	private TextField player2TF = new TextField();

	public StartGameControl(TextField player1TF, TextField player2TF) {
		this.player1TF = player1TF;
		this.player2TF = player2TF;
	}

	@Override
	public void handle(ActionEvent event) {
		
		// Adding players names to the list
		players.setPlayerList(player1TF.getText());
		players.setPlayerList(player2TF.getText());
		
		// If player have set names the game will start and Login window will close otherwise 
		// message will appear to tell user to set the names
		if (!(players.getPlayersList().get(0).isBlank()) && !(players.getPlayersList().get(1).isBlank())) {

			// Calling the method with main game window
			dv.game(players.getPlayersList());
			
			// Closing the Login window
			Stage stage = (Stage) startGame.getScene().getWindow();
			stage.close();
			
		} else {
			
			// sets text to the message label 
			errorMessage.setText("Please enter the name for all Players");
			// clear list the so it can be set again properly
			players.getPlayersList().clear();
		}
		

	}

}
