import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Player implements Comparable<Object>,Observable {
	private String name;
	private Square location;
	private int cash;

	Player(String name, Square startSquare) {
		this.name = name;
		location = startSquare;
		cash = 1500;
	}

	public String getName() {
		return name;
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

	public int getCash() {
		return cash;
	}

	public int netWorth() {
		return cash;
	}

	public void increaseCash(int amount) {
		cash += amount;
	}

	public void decreaseCash(int amount) throws BankruptException {
		cash -= amount;
		if (cash<0) {
			throw new BankruptException(-cash);
		}
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(netWorth(), ((Player) o).netWorth());
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {

	}

}
