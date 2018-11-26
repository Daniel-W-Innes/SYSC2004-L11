
public class BankruptException extends Exception {
	private static final long serialVersionUID = 3534431530504524730L;
	private int deficit;
	
	BankruptException(int deficit){
		this.deficit = deficit;
	}
	
	public int getDeficit(){
		return deficit;
	}
}
