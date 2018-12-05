package characters;

import exitsAndPlaces.Place;
import java.io.Serializable;


public class PNJ extends Character implements Serializable{
    
    private final String message; 

    /**
     * Set the PNJ's name, location and script
     * @param characterName
     * @param place
     * @param text 
     */
    public PNJ(String characterName, Place place, String text) {
        super(characterName, place);
        this.message  = text; 
    }

    /**
     * Return what the PNJ says when you talk with him
     * @return String
     */
    public String speak() {
        return this.getNAME() + " vous dit :\n" + message;
    }

    /**
     * PNJ give what he has in his inventory to the character who's passed as parameter
     * @param his 
     */
    public void giveItem(Character his) {
        System.out.println("Vous recevez : " + this.Inventory.get(0).getNAME());
        while(!this.Inventory.isEmpty()){
            his.Inventory.add(this.Inventory.remove(0));
        }
    }

}