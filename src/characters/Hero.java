package characters;

import java.util.List;
import exitsAndPlaces.Exit;
import items.*;
import exitsAndPlaces.Place;
import exitsAndPlaces.Weather;
import java.io.Serializable;


public class Hero extends Fighter implements Serializable{

    /**
     * Constructor, take character's name, his place, his power, his life points at the begining and his speed
     * @param characterName
     * @param place
     * @param power
     * @param lifePoints
     * @param speed 
     */
    public Hero(String characterName, Place place, int power, int lifePoints, int speed) {
        super(characterName, place, power, lifePoints, speed );
    }
    
    /**
     * Add the item in the hero's inventory if it's allows
     * @param object 
     */
    public void takeItem(Item object) {
       if(this.getCurrentPlace().getITEMS().contains(object)){
            this.Inventory.add(object);
            this.getCurrentPlace().removeItem(object);
            System.out.println("Vous venez de ramasser l'objet : " + object.getNAME());
       }else{
           System.out.println("Mais....il n'y a pas d'objets?!"); 
       }
    
    }
    
    /**
     * Add the item in the hero's inventory if it's allows
     * @param item 
     */
    public void takeItem(String item){
        for(int i = 0; i < this.getCurrentPlace().getITEMS().size(); i++){
            if(this.getCurrentPlace().getITEMS().get(i).getNAME().equals(item)){
                takeItem(this.getCurrentPlace().getITEMS().get(i));
                break;
            }
        }
    }
    
    /**
     * Use the item if it's in hero's inventory
     * @param item 
     */
    public void useItem(String item){
        for(int i = 0; i < this.Inventory.size(); i++){
            if(this.Inventory.get(i).getNAME().equals(item)){
                useItem(this.Inventory.get(i));
                break;
            }
        }
    }
    
    
    /**
     * Use the item if it's in hero's inventory
     * @param item 
     */
    public void useItem(Item item){
        if(item instanceof ItemBasic){
            ((ItemBasic)item).printDescription();
        }else if(item instanceof ItemBoostPower){
            ((ItemBoostPower)item).printDescription();
            if(! (this.getCurrentItem() == null)){
                ItemBoostPower booster = ((ItemBoostPower)this.getCurrentItem());
                booster.unequip( (Fighter)this );
            }
            this.changeCurrentItem((ItemBoostPower)item);
            ((ItemBoostPower)item).equip(this);
            
        }else if(item instanceof ItemBoostMaxLifePoints){
            item.printDescription();
            ((ItemBoostMaxLifePoints)item).equip(this);
            this.Inventory.remove(item);
            
        }else if(item instanceof ItemBoostSpeed){    
            ((ItemBoostSpeed)item).printDescription();
            ((ItemBoostSpeed)item).equip(this);
            this.Inventory.remove(item);
            
        }else if(item instanceof ItemHeal){    
            ((ItemHeal)item).printDescription();
            ((ItemHeal)item).equip(this);
            this.Inventory.remove(item);
            
        }else{
            item.printDescription();
            item.equip(this);
            this.Inventory.remove(item);
        }
        System.out.println("Vous utilisez l'objet : " + item.getNAME());
    }
    
    /**
     * Return true if hero's inventory contains the item, else return false
     * @param item
     * @return boolean
     */
    public boolean haveItem(String item){
        for(int i = 0; i < this.Inventory.size(); i++){
            if( ( this.Inventory.get(i).getNAME().equals(item)) ) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return place's list of items
     * @return < ? extends Item>
     */
    public List<? extends Item> examinePlaceItems(){
        if(this.getCurrentPlace().getITEMS().isEmpty()){
            System.out.println("Aucun objet dans le coin");
        }
        return this.getCurrentPlace().getITEMS();
    }
    
    /**
     * Return place's exits
     * @return <? extends Exit>
     */
    public List<? extends Exit> examinePlaceExits(){
        if(this.getCurrentPlace().getEXITS().isEmpty()){
            System.out.println("Pas de sortie...Dommage!");
        }
        return this.getCurrentPlace().getEXITS();
    }
    
    /**
     * Return place's characters
     * @return <? extends Character>
     */
    public List<? extends Character> examinePlaceCharacters(){
        if(this.getCurrentPlace().getCHARACTERS_LIST().size() < 2){
            System.out.println("Personne à l'horizon... à part vous");  
        }
        return this.getCurrentPlace().getCHARACTERS_LIST();
        
    }

    /**
     * Print what the hero's inventory contains
     */
    public void printInventory(){
        if(this.Inventory.isEmpty()){
            System.out.println("Vide");
        }
        this.Inventory.forEach(x -> System.out.println(x.getNAME() + " : " + x.printDescription()));
    }
    
    /**
     * Print the hero's state
     */
    public void printCurrentState(){
        System.out.println("Voici vos stats actuelles : "); 
        System.out.println("POWER : " + this.getPower());
        System.out.println("SPEED : " + this.getSpeed());
        System.out.println("MAX LIFE POINTS : " + this.getMaxLifePoints()); 
        System.out.println("CURRENT LIFEPOINTS : " + this.getLifePoints());
        
    }
    
    /**
     * Hurt hero according to the weather
     * @param falsard 
     */
    public void hurtByMeteo(Item falsard) {
        if(this.Inventory.contains(falsard)){
            if(this.getCurrentPlace().getWEATHER() == Weather.FROZE){
                System.out.println("Le froid vous fait perdre de la vitesse !");
                int nbHurt = this.getSpeed()*20/100;
                for(int i = 0; i < nbHurt; i ++)
                    this.decreaseSpeed();
            }else if(this.getCurrentPlace().getWEATHER() == Weather.HEAT){
                System.out.println("La chaleur vous fait perdre de la force !");
                int nbHurt = this.getPower()*20/100;
                for(int i = 0; i < nbHurt; i ++)
                    this.decreasePower();
            }
        }
    }
}