
public class GoSquare extends Square {

	GoSquare(int number) {
		super("Go", number);
	}

	@Override
	public void landOn(Player p) {
		p.setLocation(this);
		p.increaseCash(200);
	}

}
