package exitsAndPlaces;

import java.io.Serializable;

public class Exit implements Serializable{

    private final Place EXIT_PLACE;
    private final String NAME;
    
    /**
     * Set the exit's name and destination place
     * @param exitName
     */
    public Exit(String exitName, Place exitPlace) {
        this.EXIT_PLACE = exitPlace;
        this.NAME = exitName;         
    }
    
    /**
     * Return destination place
     * @return Place destinationPlace 
     */
    public Place getEXIT_PLACE() {
         return this.EXIT_PLACE;
    }
    
    /**
     * Return destination place's name
     * @return String destinationPlaceName
     */
    public String getExitPlaceName(){
        return this.EXIT_PLACE.getNAME();
    }
    
    /**
     * Return the exit's name
     * @return String exitName
     */
    public String getNAME(){
        return this.NAME;
    }

    @Override
    public String toString(){
        return this.NAME;
    }

}