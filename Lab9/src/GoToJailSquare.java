
public class GoToJailSquare extends Square {

	private Square jailSquare;

	GoToJailSquare(int number, Square jailSquare) {
		super("Go To Jail", number);
		this.jailSquare = jailSquare;
	}

	@Override
	public void landOn(Player p) {
		p.setLocation(jailSquare);
	}
}