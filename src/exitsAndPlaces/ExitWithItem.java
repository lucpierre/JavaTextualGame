package exitsAndPlaces; 

import items.Item;
import characters.Hero;
import java.io.Serializable;

public class ExitWithItem extends Exit implements Serializable{

	private final Item ITEM;
        private boolean isOpen;
        
        /**
	 * Set the exit's name, place destination and necessary item to open it
	 * @param object
         * @param name
	 */
	public ExitWithItem(Item item, String name, Place exitPlace) {
		super(name, exitPlace); 
                this.ITEM = item; 
                this.isOpen = false;
	}
        
        
        /**
         * Return the necessary item to open the exit
         * @return Item
         */
	public Item getITEM() {
		return this.ITEM;
	}
        
        /**
         * Return true if the exit is reachable, else false
         * @return boolean
         */
	public boolean getIsOpen() {
		return this.isOpen;
	}

        /**
         * Set isOpen to true if the Hero as the necessary item in his inventory, else stay at false.
         * @param H 
         */
	public void open(Hero H) {
            if( H.getInventory().contains(this.ITEM) == true){
                this.isOpen = true; 
            }else{
                System.out.println("Vous n'avez pas encore l'objet nécessaire pour dévérouiller la sortie");
            }
	}

}