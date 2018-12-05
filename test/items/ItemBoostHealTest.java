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
public class ItemBoostHealTest {
    
    private ItemHeal item;
    private Fighter fighter;
    private Place place;
    
    @Before
    public void setUp() {
        item = new ItemHeal("itemName", "itemDescription", 5);
        place = new Place("placeName", Weather.DEFAULT, "placedescription");
        fighter = new Fighter("name", place, 10,10,10);
    }
    
    @Test
    public void testEquip(){
        for(int i = 0; i < 5; i++)
            fighter.increaseMaxLifePoints();
        
        item.equip(fighter);
        assertSame(fighter.getLifePoints(), 15);
    }
    
    @Test
    public void testUnequip(){
        item.unequip(fighter);
        assertSame(fighter.getLifePoints(), 10);
    }
}
