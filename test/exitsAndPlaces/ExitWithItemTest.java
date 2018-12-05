/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exitsAndPlaces;

import characters.Hero;
import items.Item;
import items.ItemBasic;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucqu
 */
public class ExitWithItemTest {
    
    ExitWithItem exit;
    Place place, destinationPlace;
    ItemBasic item;
    Hero character, character2;
    
    @Before
    public void setUp(){
        item = new ItemBasic("itemName", "itemDescription");
        place = new Place("placeName", Weather.DEFAULT, "placeDescription");
        destinationPlace = new Place("destinationPlaceName", Weather.DEFAULT, "destinationPlaceDescription");
        exit = new ExitWithItem(item, "exitName", destinationPlace);
        character = new Hero("characterName", place, 1, 1, 1);
        character2 = new Hero("characterName2", place, 1, 1, 1);
        character.addItemInInventory(item);
        place.addExit(exit);
    }

    @Test
    public void testGetItem(){
        assertSame(exit.getITEM(), item);
    }
    
    @Test
    public void testIsOpen(){
        assertSame(exit.getIsOpen(), false);
    }
    
    @Test
    public void testOpenCharacterWithoutItem(){
        exit.open(character2);
        assertSame(exit.getIsOpen(), false);
    }
    
    @Test
    public void testOpenCharacterWithItem(){
        exit.open(character);
        assertSame(exit.getIsOpen(), true);
    }
}
