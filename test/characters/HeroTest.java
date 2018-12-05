/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import exitsAndPlaces.*;
import items.ItemBasic;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucqu
 */
public class HeroTest {
    
    private Hero hero;
    private Place place;
    private Exit exit;
    private ItemBasic item, item2, item3;
    
    @Before
    public void setUp() {
        place = new Place("placeName", Weather.DEFAULT, "descriptionPlace");
        hero = new Hero("heroName", place, 10,20,30);
        item = new ItemBasic("itemName", "itemDescription");
        item2 = new ItemBasic("itemName2", "itemDescription2");
        item3 = new ItemBasic("itemName3", "itemDescription2");
        exit = new Exit("exitName", place);
        place.addItem(item);
        place.addItem(item2);
        place.addItem(item3);
        place.addExit(exit);
        place.addCharacter(hero);
        
        hero.takeItem(item3);
    }
    
    @Test
    public void testTakeItemItem(){
        hero.takeItem(item2.getNAME());
        assert(hero.Inventory.contains(item2));
    }
    
    @Test
    public void testHaveItem(){
        assertSame(hero.haveItem(item3.getNAME()), true);
        assertSame(hero.haveItem(item.getNAME()), false);
    }
    
    @Test
    public void testExaminePlaceItems(){
        assert(hero.examinePlaceItems().contains(item));
    }
    
    @Test
    public void testExaminePlaceExits(){
        assert(hero.examinePlaceExits().contains(exit));
    }
    
    @Test
    public void testExaminePlaceCharacters(){
        assert(hero.examinePlaceCharacters().contains(hero));
    }
    
    
}
