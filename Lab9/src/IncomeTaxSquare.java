
public class IncomeTaxSquare extends Square {
	private int maximumTax;

	IncomeTaxSquare(int maxTax) {
		super("Income Tax", 0);
		maximumTax = maxTax;
	}

	@Override
	public void landOn(Player p) throws BankruptException {
		p.setLocation(this);
		p.decreaseCash(p.netWorth() / 10 > maximumTax ? maximumTax : p.netWorth() / 10);
	
	}
}
