package items;

import interfaces.Usable;
import java.io.Serializable;


public abstract class Item implements Usable, Serializable{

    private final String NAME;
    private final String DESCRIPTION; 

    public Item(String objectName, String objectDescription) {
        this.NAME = objectName; 
        this.DESCRIPTION = objectDescription;
    }

    /**
    * 
    */
    public String printDescription() {
        return this.DESCRIPTION;
    }

    /**
    * 
    * @return String 
    */
    public String getNAME() {
        return this.NAME; 
    }

}