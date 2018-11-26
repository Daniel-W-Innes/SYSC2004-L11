import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MonopolyGame  extends Application implements Observer{
	private int rounds;
	private Board board;
	private Dice dice;
	private ArrayList<Player> players;
	private HashMap<String,TextField> playersTFs;
	private Alert alert;
	
	public MonopolyGame(){
		rounds = 100;
		board = new Board();
		dice = new Dice();
		playersTFs = new HashMap<String,TextField>();
		players = new ArrayList<Player>();
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Monopoly Game");
		alert.setHeaderText("Game Over");
	}
	
	@Override
	public void start(Stage primaryStage) {
		addPlayer("purple");
		addPlayer("red");
		Pane root = new VBox();
		Pane rollbranch = new HBox();
		Button rollButton = new Button("Roll");
		rollButton.setOnAction(e -> this.playRound());
		rollbranch.getChildren().add(rollButton);
		root.getChildren().add(rollbranch);
		for (int i=0; i<players.size(); ++i) {
			playersTFs.put(players.get(i).getName(), new TextField(players.get(i).getLocation().getName() + " : $" + players.get(i).getCash()));
			Pane branch = new HBox();
			branch.getChildren().add(new Label(players.get(i).getName()));
			branch.getChildren().add(playersTFs.get(players.get(i).getName()));
			root.getChildren().add(branch);
		}
		Scene scene = new Scene(root);
		primaryStage.setTitle("Monopoly");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void addPlayer(String name) {
		Player p = new Player(name, board.startingSquare());
		p.addObserver(this);
		players.add(p);	
	}
	
	private void playRound() {
		for (int i=0; i<players.size(); ++i) {
			try {
				Player p = players.get(i);
				Square location = p.getLocation();
				Square nextSquare = board.getNextSquare(location, dice.roll());
				System.out.println(p.getName());
				System.out.println(location.getName());
				System.out.println(nextSquare.getName());
				nextSquare.landOn(p);
			} catch (BankruptException e) {
				alert.setContentText(getWinner() + " wins!");
				alert.showAndWait();
				System.exit(0);
			}
		}
		if (--rounds == 0) {
			alert.setContentText(getWinner() + " wins!");
			alert.showAndWait();
			System.exit(0);
		}
	}
	
	private String getWinner() {
		Player max = players.get(0);
		for (int i=1; i<players.size(); ++i) {
			if (players.get(i).netWorth() > max.netWorth()) {
				max = players.get(i);
			}
		}
		return max.getName();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Player p = (Player)arg0;
		playersTFs.get(p.getName()).setText(p.getLocation().getName() + " : $" + p.getCash());
	}

}
