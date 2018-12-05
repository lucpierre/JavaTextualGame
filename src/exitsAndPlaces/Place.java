package exitsAndPlaces;

import items.Item;
import characters.Fighter;
import characters.Character;
import characters.Hero;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



public class Place implements Serializable{
    private final String DESCRIPTION;
    private final Weather WEATHER;
    private final String NAME;
    private final List<Character> CHARACTERS_LIST;
    private final List<Exit> EXITS;
    private final List<Item> ITEMS;

    /**
     * Set place's name, weather and description
     * @param placeName
     * @param weather
     * @param description 
     */
    public Place(String placeName, Weather weather, String description) {
        this.NAME = placeName;
        this.WEATHER = weather;
        this.DESCRIPTION = description;
        this.CHARACTERS_LIST = new ArrayList<>();
        this.EXITS = new ArrayList<>();
        this.ITEMS = new ArrayList<>();
    }

    /**
     * Return place's name
     * @return 
     */
    public String getNAME() {
        return this.NAME;
    }
    
    /**
     * Return place's items
     * @return List Items
     */
    public List<? extends Item> getITEMS() {
        return this.ITEMS;
    }
    
    /**
     * Return place's characters
     * @return List Character
     */
    public List<Character> getCHARACTERS_LIST() {
        return CHARACTERS_LIST;
    }
    
    /**
     * Return place's character who's name match with parameter if it's possible.
     * @param name
     * @return character
     */
    public Character getCharacterByName(String name){
        for(int i = 0; i < this.CHARACTERS_LIST.size(); i++){
            if(this.CHARACTERS_LIST.get(i).getNAME().equals(name)){
                return this.CHARACTERS_LIST.get(i);
            }
        }
        return null;
    }
    
    /**
     * Return place's exits
     * @return List Exit
     */
    public List<Exit> getEXITS() {
        return EXITS;
    }
    
    /**
     * Return place's weather
     * @return weather
     */
    public Weather getWEATHER() {
        return this.WEATHER;
    }
    
    /**
     * Return place exits's name
     * @return List String
     */
    public List<String> getExitsNames(){
        List<String> names = new ArrayList<>();
        this.EXITS.forEach(x -> names.add(x.toString()));
        return names;
    }
    
    /**
     * Return place items's name
     * @return List String
     */
    public List<String> getItemsNames(){
        List<String> names = new ArrayList<>();
        this.ITEMS.forEach(x -> names.add(x.getNAME()));
        return names;
    }
    
    /**
     * Return place characters's name
     * @return List String
     */
    public List<String> getCharactersNames(){
        List<String> names = new ArrayList<>(); 
        this.CHARACTERS_LIST.forEach(x->names.add(x.getNAME())); 
        return names; 
    }

    /**
     * Print place's description
     */
    public String printDescription() {
        return this.DESCRIPTION;
    }
    
    /**
     * Print place's content
     */
    public void printContains(){
         this.CHARACTERS_LIST.forEach(x -> System.out.println(x.toString()));
         this.EXITS.forEach(x -> System.out.println(x.toString()));
         this.ITEMS.forEach(x -> System.out.println(x.getNAME()));
    }
    
    /**
     * Add character to place's characters list
     * @param character 
     */
    public void addCharacter(Character character) {
        this.CHARACTERS_LIST.add(character);
    }
        
    /**
     * Remove character to place's characters list
     * @param character
     */
    public void removeCharacter(Character character) {
        if(this.CHARACTERS_LIST.contains(character))
            this.CHARACTERS_LIST.remove(character);
    }

    /**
     * Add item to place's items list
     * @param object
     */
    public void addItem(Item object) {
        this.ITEMS.add(object);
    }

    /**
     * Remove item to place's items list
     * @param object
     */
    public void removeItem(Item item) {
        if(this.ITEMS.contains(item))
            this.ITEMS.remove(item);
    }

    /**
     * Add exit to place's exits list
     * @param exit
     */
    public void addExit(Exit exit) {
        this.EXITS.add(exit);
    }
    
    /**
     * Described what the hero can do during a fight
     * @param hero
     * @param opponent
     */
    public void fightLapHero(Hero hero,Fighter opponent){
        System.out.println("Que voulez vous faire :");
        System.out.println("    - attaquer");
        System.out.println("    - sac");
        Scanner scanObject = new Scanner(System.in); 
        String choice = scanObject.nextLine();
        
        switch (choice) {
            case "attaquer":
                System.out.println("Vous attaquez votre adversaire :");
                hero.attack(opponent);
                if(opponent.getLifePoints() < 0){
                    System.out.println("Votre adversaire n'a plus de points de vie");
                }else{
                    System.out.println("Il reste " + opponent.getLifePoints() + "pdv à votre adversaire.");
                }
                break;
            case "sac":
                System.out.println("Inventaire :");
                hero.getInventory().forEach(x -> System.out.println("   - " + x.getNAME()));
                                   
                if(hero.getInventory().isEmpty()){
                    System.out.println("Pas d'objet dans votre inventaire... ");
                }else{
                    String phraseATaper = scanObject.nextLine(); 
                    String [] nameObject = phraseATaper.split(" ");
                    if(hero.haveItem(nameObject[0])){
                            hero.useItem(nameObject[0]);
                    }
                    break;
                }
             default:
                    this.fightLapHero(hero, opponent);
                   break;
        }
        
    }
        
    /**
     *Described a fight
     * @param hero
     * @param opponent
     */
    public void fight(Hero hero, Fighter opponent) {
        boolean actionLap  = false;
        
        if(hero.getSpeed() > opponent.getSpeed()){
            actionLap = true;
        }
        
        while( hero.getLifePoints() > 0 && opponent.getLifePoints() > 0 ){
            if (!actionLap)
            {
                System.out.println("L'adversaire vous frappe !");
                opponent.attack(hero);
                if(hero.getLifePoints() < 0){
                    System.out.println("Vous n'avez plus de points de vie");
                }else{
                    System.out.println("Il vous reste " + hero.getLifePoints()+ "pdv.");
                }
                actionLap = true;
            }
            else{
                fightLapHero(hero, opponent);
                actionLap = false;
            }
        }
        System.out.println("Fin du combat ");
        this.CHARACTERS_LIST.remove(opponent);
    }
}