
import java.util.HashMap;

/**
 * The game board for a simulated game of Monopoly.
 * 
 * @author D.L. Bailey, SCE, Carleton University 
 * @version 1.01 February 28, 2006
 */

    
public class Board
{   
    public static final int GO_SQUARE = 0;
    private static final int SIZE = 38;    
    
    private Square[] squares;
    private HashMap<Integer,Player> owners;
   
    public Board()
    {
        squares = new Square[SIZE];
        buildSquares();
        owners = new HashMap<Integer, Player>();
    }
    
    /**
     * Populates the board with Squares.
     */
    private void buildSquares()
    {
        int i = GO_SQUARE;
        squares[i] = new GoSquare(i++);
        int commonPrice = 40;
        int commonRent = 40;
        squares[i] = new PropertySquare( "Duckworth Street", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Community Chest", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Signal Hill", i++, commonPrice, commonRent);
        squares[i] = new IncomeTaxSquare(i);
        squares[i] = new PropertySquare( "CN Rail", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Waterloo Row", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Chance", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "King Street", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Queen Street", i++, commonPrice, commonRent);
        PropertySquare jailSquare = new PropertySquare( "Jail", i, 0, 0); // Need another subclass
        squares[i++] = jailSquare;
        squares[i] = new PropertySquare( "University Avenue", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Telephone Company", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Barrington Street", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Spring Garden Road", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Ontario Northland", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Rue St-Jean", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Community Chest", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Rue Ste-Catherine", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Rue St-Jacques", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Free Parking", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Sussex Drive", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Chance", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Yonge Street", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Bay Street", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "CP Rail", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Portage & Main", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Victoria Avenue", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Gas Company", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Albert Street", i++, commonPrice, commonRent);
        squares[i] = new GoToJailSquare(i, jailSquare);
        squares[i] = new PropertySquare( "Jasper Avenue", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "St. Albert Trail", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Community Chest", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "MacLeod Trail", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "B.C. Rail", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Chance", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Granville Street", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Luxury Tax", i++, commonPrice, commonRent);
        squares[i] = new PropertySquare( "Douglas Street", i++, commonPrice, commonRent);  
    }
    
    /**
     * Returns the Square located "distance" squares
     * after Square aSquare.
     */
    public Square getNextSquare(Square aSquare, int distance)
    {
        /* Assumes that squares are numbered consecutively, starting
         * from GO_SQUARE, and that the square numbered "n" is stored
         * in squares[n]. See buildSquares().
         */
        int i = (aSquare.getNumber() + distance) % (SIZE);
        return squares[i]; 
    }

    /**
     * Returns the Square where all players are
     * located at the start of the game.
     */
    public Square startingSquare()
    {
        return squares[GO_SQUARE];
    }   
    
    public void addOwner(Square square, Player p) throws Exception {
        if (owners.containsKey(square.getNumber())) throw new Exception ( p + "already owns " + square );
        
        owners.put( square.getNumber(), p);
    }
    
    public Player getOwner(Square square) {
        return owners.get(square.getNumber());
    }
    
    // Later, removeOwner
    
}