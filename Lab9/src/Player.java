import java.util.Observable;

public class Player extends Observable implements Comparable<Object>{
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
		setChanged();
		notifyObservers();
	}

	public int getCash() {
		return cash;
	}

	public int netWorth() {
		return cash;
	}

	public void increaseCash(int amount) {
		cash += amount;
		setChanged();
		notifyObservers();
	}	

	public void decreaseCash(int amount) throws BankruptException {
		cash -= amount;
		if (cash<0) {
			cash = 0;
			throw new BankruptException(-cash);
		}
		setChanged();
		notifyObservers();
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(netWorth(), ((Player) o).netWorth());
	}
}
