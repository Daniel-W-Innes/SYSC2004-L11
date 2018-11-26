import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schramm
 */
public class PropertySquareTest {
    
    public PropertySquareTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 
    /**
     * Test of name method, of class PropertySquare.
     */
    @Test
    public void testAttributes() {
        PropertySquare instance = new PropertySquare("Broadway", 39, 1500, 300);
        Assert.assertEquals(instance.getName(), "Broadway");
        Assert.assertEquals(instance.getNumber(), 39);  
    }

    @Test
    public void testLandOnSquareAvailable() {
        Player p = new Player("purple", null);  // Don't need Square for GoSquare testing
       
        PropertySquare instance = new PropertySquare("Broadway", 39, 750, 300);
        try {
            instance.landOn(p);
            Assert.assertEquals(p.netWorth(), 1500-750);
            Assert.assertEquals(p.getLocation(), instance);  
        }
        catch (Exception e) { fail(); }        
    }
 
    @Test
    public void testLandOnSquareAvailableButTooExpensive() {
        Player p = new Player("purple", null);  // Don't need Square for GoSquare testing
        
        PropertySquare instance = new PropertySquare("Broadway", 39, 1750, 300);
          // Cost is more than starting bank of player
        try {
            instance.landOn(p);
            Assert.assertEquals(p.netWorth(), 1500);
            Assert.assertEquals(p.getLocation(), instance);  
        }
        catch (Exception e) { fail(); }        
    }  
    
       @Test
    public void testLandOnSquareOwnedWithCheapRent() {

        Player first = new Player("red", null);
        Player second = new Player("purple", null);  // Don't need Square for PropertySquare testing
        
        PropertySquare instance = new PropertySquare("Broadway", 39, 750, 300);
          // Rent is less than starting bank of player
        try {
            instance.landOn(first);
            instance.landOn(second);
            Assert.assertEquals(first.netWorth(), 1500-750+300);
            Assert.assertEquals(first.getLocation(), instance);  
            Assert.assertEquals(second.netWorth(), 1500-300);
            Assert.assertEquals(second.getLocation(), instance);  
        }
        catch (Exception e) { fail(); }        
    }
    
           @Test
    public void testLandOnSquareOwnedWithExpensiveRent() {

        Player first = new Player("red", null);
        Player second = new Player("purple", null);  // Don't need Square for PropertySquare testing
        
        PropertySquare instance = new PropertySquare("Broadway", 39, 750, 1800);
          // Rent is MORE than starting bank of player
        try {
            instance.landOn(first);
            instance.landOn(second);
            fail();
        }
        catch (Exception e) { 
            //Assert.assertNotEquals(mockBoard.getOwner(instance), second);
            //Assert.assertEquals(mockBoard.getOwner(instance), first); // Overkill
            Assert.assertEquals(first.netWorth(), 1500-750+1500);
            Assert.assertEquals(first.getLocation(), instance);  
            Assert.assertEquals(second.netWorth(), 0);
            Assert.assertEquals(second.getLocation(), instance);  
        }        
    }
}

/* A Mock Board object to see if PropertySquare updates it properly,
 * without having a full-blown Board object developed
*/
class MockBoard extends Board {
    private Player owner;
    @SuppressWarnings("unused")
	private Square square;
    
    public MockBoard () {
        this.owner = null;
    }
    
    public void addOwner(Square square, Player p) throws Exception {
        owner = p;
    }
    
    public Player getOwner(Square square) {
        return owner;
    }
    
}