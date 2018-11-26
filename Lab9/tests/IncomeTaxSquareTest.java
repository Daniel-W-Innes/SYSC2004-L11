// NOTE: Did not finish ??  There are compiler errors
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author schramm
 */
public class IncomeTaxSquareTest {
    
    public IncomeTaxSquareTest() {
    }
    
    /**
     * Test of name method, of class GoSquare.
     */
    @Test
    public void testName() {
        IncomeTaxSquare instance = new IncomeTaxSquare(0);    // Any number is fine.
        Assert.assertEquals(instance.getName(), "Income Tax");
        Assert.assertEquals(instance.getNumber(), 0);        
    }
    
    @Test
    public void testLandOnMinimum() {
        Player p = new Player("purple", null);  // Don't need Square for testing
        IncomeTaxSquare instance = new IncomeTaxSquare(0);    // Any number is fine.
        try {
            instance.landOn(p);
        } catch(BankruptException e) { 
            Assert.fail("Bankrupt exception should not have occurred"); 
        }
        
        Assert.assertEquals(p.netWorth(), 1500-(1500/10));    
        Assert.assertEquals(p.getLocation(), instance);
    }
    
    @Test
    public void testLandOnMaximum() {
        Player p = new Player("purple", null);  // Don't need Square for testing
        p.increaseCash(3000);
        IncomeTaxSquare instance = new IncomeTaxSquare(0);    // Any number is fine.
        try {
            instance.landOn(p);
        } catch(BankruptException e) { 
            Assert.fail("Bankrupt exception should not have occurred"); 
        }
        Assert.assertEquals(p.netWorth(), 1500+3000-200);    
        Assert.assertEquals(p.getLocation(), instance);
    }
}
