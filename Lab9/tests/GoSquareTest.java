import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author schramm
 */
public class GoSquareTest {
    
    public GoSquareTest() {
    }
    
    @Before
    public void setUp() {
        @SuppressWarnings("unused")
		Player p = new Player("purple", null);  // Don't need Square for GoSquare testing
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of name method, of class GoSquare.
     */
    @Test
    public void testName() {
        GoSquare instance = new GoSquare(0);    // Any number is fine.
        Assert.assertEquals(instance.getName(), "Go");
        Assert.assertEquals(instance.getNumber(), 0);        
    }
    /**
     * Test of landOn method, of class GoSquare.
     */
    @Test
    public void testLandOn() {
        Player p = new Player("purple", null);  // Don't need Square for GoSquare testing
        GoSquare instance = new GoSquare(0);    // Any number is fine.
        instance.landOn(p);
        Assert.assertEquals(p.netWorth(), 1500+200);    
        Assert.assertEquals(p.getLocation(), instance);
    }
    
}
