package sk.mihacodes.view;

import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sk.mihacodes.model.RollModel;
import sk.mihacodes.view.iservice.IButton;
/**
 * Class that contains View methods of the applications
 * @author haska
 *
 */

public class RollTheDiceView extends Application implements IButton {

	@Override
	public void start(Stage stage) throws Exception {
		EnterPlayersNamesView lc = new EnterPlayersNamesView();
		lc.login(stage);

	}

	// this method creates the game play GUI window
	public void game(List<String> playerList) {

		Stage gameStage = new Stage();

		MigPane gameRoot = new MigPane("center, insets 20 0 0 0");
		gameRoot.setId("GameRoot"); // setting ID for css file

		Scene scene = new Scene(gameRoot, 550, 450);
		scene.getStylesheets().add("styles.css");

		RollModel rollTheDice = new RollModel();
		
		// initialization of images on no start of the window
		ImageView img1 = new ImageView((rollTheDice.roll() + ".png"));
		ImageView img2 = new ImageView((rollTheDice.roll() + ".png"));
		
		// getting string from list and displaying name of player 1
		Label player1 = new Label(playerList.get(0).toString());
		player1.setId("Player1"); // setting ID for css file

		// getting string from list and displaying name of player 2
		Label player2 = new Label(playerList.get(1).toString());
		player2.setId("Player2"); // setting ID for css file

		// setting new random images after click on button
		playButton.setOnAction(event -> {
			img1.setImage(new Image(rollTheDice.roll() + ".png"));
			img2.setImage(new Image(rollTheDice.roll() + ".png"));
		});
		playButton.setId("PlayButton"); // setting ID for css file

		// Adding fields to the GUI window
		gameRoot.add(player1, "align center");
		gameRoot.add(player2, "align center, wrap");
		gameRoot.add(img1);
		gameRoot.add(img2, "wrap");
		gameRoot.add(playButton, "align center, span 2");

		gameStage.setTitle("Roll the Dice");
		gameStage.setScene(scene);
		gameStage.show();
	}
}
