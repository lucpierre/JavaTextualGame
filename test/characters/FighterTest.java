/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import exitsAndPlaces.Exit;
import exitsAndPlaces.Place;
import exitsAndPlaces.Weather;
import items.ItemBasic;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucqu
 */
public class FighterTest {
    
    private Fighter fighter;
    private Fighter opponent;
    private Place place;
    private Place newPlace;
    private ItemBasic item;
    private Exit exit;
    
    @Before
    public void setUp() {
        place = new Place("placeName", Weather.DEFAULT, "descriptionPlace");
        newPlace = new Place("newPlaceName", Weather.DEFAULT, "newDescriptionPlace");
        fighter = new Fighter("fighterName", place, 1,2,3);
        opponent = new Fighter("opponentName", place, 1,2,3);
        exit = new Exit("exitName", newPlace);
    }
    
    @Test
    public void testGetPower(){
        assertSame(fighter.getPower(), 1);
    }
    
    @Test
    public void testGetMaxLifePoints(){
        assertSame(fighter.getMaxLifePoints(), 2);
    }
    
    @Test
    public void testGetSpeed(){
        assertSame(fighter.getSpeed(), 3);
    }
    
    @Test
    public void testIncreaseMaxLifePoints(){
        fighter.increaseMaxLifePoints();
        assertSame(fighter.getMaxLifePoints(), 3);
    }
    
    @Test
    public void testIncreaseLifePoints(){
        fighter.increaseLifePoints();
        assertSame(fighter.getLifePoints(), fighter.getMaxLifePoints());
    }
    
    @Test
    public void testDecreaseLifePoints(){
        fighter.decreaseLifePoints();
        assertSame(fighter.getLifePoints(), fighter.getMaxLifePoints()-1);
    }
    
    @Test
    public void testCurrentPlace(){
        assertSame(fighter.getCurrentPlace(), place);
    }
    
    @Test
    public void testAttack(){
        int lp = opponent.getLifePoints();
        fighter.attack(opponent);
        assertSame(opponent.getLifePoints(), lp - fighter.getPower());
    }
    
    @Test
    public void testGetCurrentPlace(){
        assertSame(fighter.getCurrentPlace(), place);
    }
    
    @Test
    public void testAddItem(){
        fighter.addItemInInventory(item);
        assert(fighter.Inventory.contains(item));
    }
    
    @Test
    public void testChangeCurrentItem(){
        fighter.changeCurrentItem(item);
        assertSame(fighter.currentItem, item);
    }
    
    @Test
    public void testGetName(){
        assertSame(fighter.getNAME(), "fighterName");
    }
    
    @Test
    public void testChangeCurrentPlace(){
        fighter.changeCurrentPlace(exit);
        assertSame(fighter.getCurrentPlace(), newPlace);
    }
    
    @Test
    public void testIsDeasFalse(){
        assertSame(fighter.isDead(), false);
    }
    
    @Test
    public void testIsDeadTrue(){
        while(fighter.getLifePoints() != 0){
            fighter.decreaseLifePoints();
        }
        assertSame(fighter.isDead(), true);
    }
}
