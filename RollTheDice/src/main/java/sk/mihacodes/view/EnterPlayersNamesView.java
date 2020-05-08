package sk.mihacodes.view;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sk.mihacodes.controller.StartGameControl;
import sk.mihacodes.view.iservice.IButton;
import sk.mihacodes.view.iservice.ILabel;

/**
 * This class contains the method responsible for creating a first GUI window of app.
 * Where users set their names and proceed to game play by clicking on button start game
 * @author haska
 *
 */
public class EnterPlayersNamesView implements IButton, ILabel{
	
	private StartGameControl addPlayersNames;
	
	private ImageView introImage;
	
	private Label playerName1;
	private Label playerName2;
	
	private TextField playerNameField1;
	private TextField playerNameField2;
	
	private MigPane loginPane;
	
	private Scene scene;

	public void login(Stage stage) {
		
		
		loginPane = new MigPane("center, insets 20 0 0 0"); // object responsible for layout
		loginPane.setId("LoginPane"); // setting ID for css file
		
		scene = new Scene(loginPane, 550, 450);	// creating the window with root and dimensions
		scene.getStylesheets().add("styles.css"); // calling the css file
		
		introImage = new ImageView("rollTheDice.png"); // image that appears in first GUI Window
		
		// Entering the name for the Player1
		playerName1 = new Label("Enter Player 1 Name:");
		playerName1.setId("PlayerName1"); // setting ID for css file
		playerNameField1 = new TextField();
		
		// Entering the name for the Player1
		playerName2 = new Label("Enter Player 2 Name:");
		playerName2.setId("PlayerName2"); // setting ID for css file
		playerNameField2 = new TextField();
		
		// Creating an object that takes 2 TextFields as parameters 
		addPlayersNames = new StartGameControl(playerNameField1, playerNameField2);

		
		
		// Setting action the button, addPlayersNames object is called
		startGame.setOnAction(addPlayersNames);
		
		// Adding fields to the GUI window
		loginPane.add(introImage, "span 2, align center, wrap");
		loginPane.add(playerName1, "align center");
		loginPane.add(playerNameField1, "align center, wrap");
		loginPane.add(playerName2, "align center");
		loginPane.add(playerNameField2, "align center, wrap");
		loginPane.add(startGame, "span 2, align center, wrap");
		errorMessage.setId("ErrorMessage");
		loginPane.add(errorMessage, "span 2, align center");

		
		stage.setTitle("Roll the Dice");
		stage.setScene(scene);
		stage.show();
	}
}
