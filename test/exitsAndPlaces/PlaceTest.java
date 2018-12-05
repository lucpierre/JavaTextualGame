/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exitsAndPlaces;

import characters.Hero;
import characters.Character;
import items.ItemBasic;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucqu
 */
public class PlaceTest {
    
    private Place place;
    private Exit exit;
    private ItemBasic item;
    private Hero hero;
    
    @Before
    public void setUp() {
        place = new Place("placeName", Weather.DEFAULT ,"placeDescritpion");
        exit = new Exit("exitName", place);
        item = new ItemBasic("itemName", "itemDescription");
        hero = new Hero("heroName", place, 1,1,1);
    }
    
    @Test
    public void testGetCharactersEmpty(){
        assertSame(place.getCHARACTERS_LIST().isEmpty(), true);
    }
    
    @Test
    public void testGetItemsEmpty(){
        assertSame(place.getITEMS().isEmpty(), true);
    }
    
    @Test
    public void testGetExitsEmpty(){
        assertSame(place.getEXITS().isEmpty(), true);
    }
    
    @Test
    public void testAddCharacter(){
        place.getCHARACTERS_LIST().clear();
        place.addCharacter(hero);
        assertSame(place.getCHARACTERS_LIST().contains(hero), true);
    }
    
    @Test
    public void testAddItem(){
        place.getITEMS().clear();
        place.addItem(item);
        assertSame(place.getITEMS().contains(item), true);
    }
    
    @Test
    public void testAddExit(){
        place.getEXITS().clear();
        place.addExit(exit);
        assertSame(place.getEXITS().contains(exit), true);
    }
    
    @Test
    public void testGetCharacterByName(){
        place.getCHARACTERS_LIST().clear();
        place.addCharacter(hero);
        assertSame(place.getCHARACTERS_LIST().contains(hero), true);
        Character c = place.getCharacterByName("heroName");
        assertSame(c, hero);
    }
    
    @Test
    public void testGetCharacterListName(){
        place.getCHARACTERS_LIST().clear();
        place.addCharacter(hero);
        assertSame(place.getCHARACTERS_LIST().contains(hero), true);
        List<String> names = place.getCharactersNames();
        assertSame(names.contains(hero.getNAME()), true);
    }
    
    @Test
    public void testGetItemListName(){
        place.getITEMS().clear();
        place.addItem(item);
        assertSame(place.getITEMS().contains(item), true);
        List<String> names = place.getItemsNames();
        assertSame(names.contains(item.getNAME()), true);
    }
    
    @Test
    public void testGetExitListName(){
        place.getEXITS().clear();
        place.addExit(exit);
        assertSame(place.getEXITS().contains(exit), true);
        List<String> names = place.getExitsNames();
        assertSame(names.contains(exit.getNAME()), true);
    }
    
    @Test
    public void testGetName(){
        assertSame(place.getNAME(), "placeName");
    }
    
    @Test
    public void testGetWeather(){
        assertSame(place.getWEATHER(), Weather.DEFAULT);
    }
    
    @Test
    public void testRemoveCharacter(){
        place.getCHARACTERS_LIST().clear();
        place.addCharacter(hero);
        assertSame(place.getCHARACTERS_LIST().contains(hero), true);
        place.removeCharacter(hero);
        assertSame(place.getCHARACTERS_LIST().contains(hero), false);
    }
    
    @Test
    public void testRemoveItem(){
        place.getITEMS().clear();
        place.addItem(item);
        assertSame(place.getITEMS().contains(item), true);
        place.removeItem(item);
        assertSame(place.getITEMS().contains(item), false);
    }
}
