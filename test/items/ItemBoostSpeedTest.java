/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;


import characters.Fighter;
import exitsAndPlaces.Place;
import exitsAndPlaces.Weather;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucqu
 */
public class ItemBoostSpeedTest {
    
    private ItemBoostSpeed item;
    private Fighter fighter;
    private Place place;
    
    @Before
    public void setUp() {
        item = new ItemBoostSpeed("itemName", "itemDescription", 5);
        place = new Place("placeName", Weather.DEFAULT, "placedescription");
        fighter = new Fighter("name", place, 10,10,10);
    }
    
    @Test
    public void testEquip(){
        item.equip(fighter);
        assertSame(fighter.getSpeed(),15);
    }
    
    @Test
    public void testUnequip(){
        item.unequip(fighter);
        assertSame(fighter.getSpeed(), 5);
    }
}
