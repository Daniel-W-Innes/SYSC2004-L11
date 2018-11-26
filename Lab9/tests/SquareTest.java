import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schramm
 */
public class SquareTest {
    
    public SquareTest() {
    }

    /**
     * Test of name method, of class Square.
     */
    @Test
    public void testName() {
        System.out.println("name");
        Square instance = new SquareImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of number method, of class Square.
     */
    @Test
    public void testNumber() {
        System.out.println("number");
        Square instance = new SquareImpl();
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of landOn method, of class Square.
     */
    @Test
    public void testGoSquare() throws Exception {
        Player p = null;
        Square instance = new SquareImpl();
        instance.landOn(p);
    }

    public class SquareImpl extends Square {

        public SquareImpl() {
            super("", 0);
        }

        public void landOn(Player p) throws BankruptException{
        }
    }
    
}
