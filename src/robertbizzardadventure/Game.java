package robertbizzardadventure;

import characters.*;
import exitsAndPlaces.Exit;
import exitsAndPlaces.Place;
import fixtures.*;
import items.Item;
import java.util.HashMap;
import characters.Character;
import java.io.Serializable;






public class Game implements Serializable {
    private final HashMap<String, Character> CHARACTERS_GAME;
    private final HashMap<String, Exit> EXITS_GAME;
    private final HashMap<String, Item> ITEMS_GAME;
    private final HashMap<String, Place> WORLD_MAP;
    public final Character HERO;

    public Game() {
        
        Places places = new Places();                                               // Creation places
        Items items = new Items();                                                  // Creation items
        Exits exits = new Exits(places.getPlaces(), items.getItems());              // Creation exits
        characters characters = new characters(places.getPlaces());                 // Creation characters

        places.setExits(exits.getExits());
        places.setItems(items.getItems());
        places.setCharacters(characters.getCHARACTERS_LIST());
        characters.setItems(items.getItems());

        this.ITEMS_GAME = items.getItems();
        this.WORLD_MAP = places.getPlaces();
        this.EXITS_GAME = exits.getExits();
        this.CHARACTERS_GAME = characters.getCHARACTERS_LIST();

        this.HERO = new Hero("Robert", this.WORLD_MAP.get("Cellule"), 50, 200, 100);
    }
    

    public boolean endGame() {
        return ((Fighter)this.CHARACTERS_GAME.get("boss")).isDead() || ((Fighter)this.HERO).isDead();
    }

    public void runGame(){
        
        while(!endGame()){
            if( !(this.HERO.getCurrentPlace().getCHARACTERS_LIST().isEmpty()) &&  !(this.HERO.getCurrentPlace().getCHARACTERS_LIST().get(0).getNAME().equals("Robert"))){
                if(this.HERO.getCurrentPlace().getCHARACTERS_LIST().get(0) instanceof Fighter){
                    System.out.println( "Vous vous faites attaquer par : " + this.HERO.getCurrentPlace().getCHARACTERS_LIST().get(0).getNAME());
                    this.HERO.getCurrentPlace().fight( ((Hero)HERO), ((Fighter)this.HERO.getCurrentPlace().getCHARACTERS_LIST().get(0)) );
                }
            }
            
            if( !((Fighter)this.HERO).isDead())
                Command.OneStep(this, this.HERO, this.EXITS_GAME);
            
        }
        
        if( ((Fighter)this.HERO).isDead() ){
            System.out.println("GAME OVER");
        }
        else
        {
            System.out.println("Dans un dernier soupir, Chaf lui plaça un ippon mortel, le soleil se couchait alors sur\n"
                    + " les deux adversaires gisant sur le sol, ainsi se terminait l'histoire de Robert le cowboy et de Chaf\n"
                    + " l'homme au savoir éternel, dont les intentions demeureront à jamais inconnues ...");
            System.out.println("FIN");
        }
    }
    
    public Fighter getHERO() {
        return (Fighter)this.HERO;
    }
}
