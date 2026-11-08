package cs112.ud2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/** Connects the High Card controls to the Player model from UD1. */
public class HelloController {
    @FXML
    private TextField playerNameField;
    @FXML
    private Label playerNameLabel;
    @FXML
    private Label playerScoreLabel;
    @FXML
    private Label computerScoreLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Button dealButton;

    private Player player;
    private Player computer;

    /** Creates both players from valid input and shows their starting scores. */
    @FXML
    private void onNewGame() {
        try {
            Player newPlayer = new Player(playerNameField.getText(), 0);
            Player newComputer = new Player("Computer", 0);
            player = newPlayer;
            computer = newComputer;
            playerNameLabel.setText(player.getName());
            playerScoreLabel.setText("Score: " + player.getScore());
            computerScoreLabel.setText("Score: " + computer.getScore());
            statusLabel.setText("New game started. Ready to deal.");
            dealButton.setDisable(false);
        } catch (IllegalArgumentException exception) {
            statusLabel.setText(exception.getMessage());
        }
    }

    /** Handles Deal clicks while the full game logic is planned for UD3. */
    @FXML
    private void onDeal() {
        statusLabel.setText("Deal selected.");
        System.out.println("Deal clicked.");
    }
}
