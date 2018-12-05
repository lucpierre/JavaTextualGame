/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

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
public class PNJTest {
    
    private PNJ pnj;
    private Hero hero;
    private Place place;
    private ItemBasic item;
    
    @Before
    public void setUp() {
        place = new Place("placeName", Weather.DEFAULT, "descriptionPlace");
        pnj = new PNJ("pnjName", place, "talk");
        hero = new Hero("heroName", place, 1,1,1);
        item = new ItemBasic("itemName", "description");
        pnj.addItemInInventory(item);
    }
    
    @Test
    public void testGiveItem(){
        pnj.giveItem((Character)hero);
        assertSame(hero.Inventory.contains(item), true);
        assertSame(pnj.Inventory.contains(item), false);
    }
}
