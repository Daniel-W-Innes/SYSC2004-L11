import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schramm
 */
public class GoToJailSquareTest {
    
    public GoToJailSquareTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of landOn method, of class GoToJailSquare.
     */
    @Test
    public void testLandOn() {
        Player p = new Player("purple", null); // Start anywhere.
        Square imaginaryJailSquare = new GoSquare(0);
        GoToJailSquare instance = new GoToJailSquare(5, imaginaryJailSquare);  
            // Should be Jail square but for test, doesn't matter, as long as that's where Player ends up
    
        instance.landOn(p);
        assertEquals(p.getLocation(), imaginaryJailSquare);
    }
    
}
