/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schr
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
     @Test
    public void testComparable() {
        @SuppressWarnings("unused")
		int amount = 0;
        Player p1 = new Player("purple", null);
        Player p2 = new Player("red", null);
        Assert.assertEquals(0, p1.compareTo(p2));
        p1.increaseCash(100);
        Assert.assertEquals(1, p1.compareTo(p2));        
        Assert.assertEquals(-1, p2.compareTo(p1));
        try {
            p1.compareTo(null);
            fail();
        } 
        catch( NullPointerException e) {}
        catch(Exception e) { fail(); }
        try {
            p1.compareTo( new Integer(10));
            fail();
        }
        catch( ClassCastException e) {}
        catch(Exception e) { fail(); }
        
    }
    
}
