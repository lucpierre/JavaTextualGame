/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exitsAndPlaces;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucqu
 */
public class ExitTest {
    
    private Place place;
    private Exit exit;
    
    @Before
    public void setUp() {
        place = new Place("placeName", Weather.DEFAULT, "descriptionPlace");
        exit = new Exit("exitName", place);
    }
    
    @Test
    public void testGetExitPlace(){
        assertSame(exit.getEXIT_PLACE(), place);
    }
    
    @Test
    public void testGetExitPlaceName(){
        assertSame(exit.getExitPlaceName(), place.getNAME());
    }
    
    @Test
    public void testGetName(){
        assertSame(exit.getNAME(), "exitName");
    }
}
