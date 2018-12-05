package characters;

import java.util.*;
import exitsAndPlaces.Exit;
import exitsAndPlaces.ExitWithItem;
import items.Item;
import exitsAndPlaces.Place;
import java.io.Serializable;

public abstract class Character implements Serializable{

    protected List<Item> Inventory;
    protected Item currentItem;
    private Place currentPlace;
    private final String NAME;

    /**
    * Set character's name and his location
    * @param characterName
    */
    public Character(String characterName, Place place) {
        this.Inventory = new ArrayList<>();
        this.currentItem = null;
        this.currentPlace = place;
        this.NAME = characterName;
    }

    /**
    * Add the item to the character's inventory
    * @param object
    */
    public void addItemInInventory(Item object) {
        this.Inventory.add(object);
    }

    /**
     * Remove the item to the character's inventory
     * @param item 
     */
    public void removeItemInventory(Item item) {
        this.Inventory.remove(item);
    }

    /**
     * Add if current item is empty, or change with the item as parameter
     * @param item 
     */
    public void changeCurrentItem(Item item) {
        if(this.Inventory.contains(item)){
            this.currentItem = item;
        }else{
            System.out.println("Vous ne possédez pas cet item");
        }
    }

    /**
     * Return character's current place
     * @return Place
     */
    public Place getCurrentPlace() {
        return this.currentPlace;
    }
    
    /**
     * Return character's name
     * @return String
     */
    public String getNAME(){
        return this.NAME;
    }

    /**
    * Take an exit, change character's current place with the exitPlace of the exit as parameter
    * @param destination
    */
    public void changeCurrentPlace(Exit destination) {
        if(destination instanceof ExitWithItem){
            ((ExitWithItem) destination).open((Hero)this);
            if(!(((ExitWithItem)destination).getIsOpen())){
                System.out.println("Il semble vous manquer quelque chose pour passer .. ");
            }
            else
            {
                this.currentPlace.removeCharacter(this);
                this.currentPlace = destination.getEXIT_PLACE();
                destination.getEXIT_PLACE().addCharacter(this);
            }
        }
        else
        {
            this.currentPlace.removeCharacter(this);
            this.currentPlace = destination.getEXIT_PLACE();
            destination.getEXIT_PLACE().addCharacter(this);
        }
    }
    
    /**
     * Return character's current item
     * @return Item
     */
    public Item getCurrentItem() {
        return this.currentItem;
    }
    
    /**
     * Return character's inventory
     * @return List<? extends Item>
     */
    public List<? extends Item> getInventory(){
        return this.Inventory;
    }

    @Override
    public String toString(){
        return this.NAME;
    }
}