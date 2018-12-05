package characters;

import exitsAndPlaces.Place;
import java.io.Serializable;


public class Fighter extends Character implements Serializable{

    private int power;
    private int maxLifePoints;
    private int lifePoints;
    private int speed;

    /**
     * 
     * @param characterName
     * @param place 
     */
    public Fighter(String characterName, Place place, int power, int lifePoints, int speed) {
        super(characterName, place);
        this.power = power;
        this.maxLifePoints = lifePoints;
        this.lifePoints = lifePoints;
        this.speed = speed;
    }

    
    /**
     * Return the fighter's power
     * @return int
     */
    public int getPower() {
        return power;
    }
    
    /**
     * Return the fighter's max life points
     * @return int
     */
    public int getMaxLifePoints() {
        return maxLifePoints;
    }

    /**
     * Return the fighter's life points
     * @return int
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Return the fighter's speed
     * @return int
     */
    public int getSpeed() {
        return this.speed;
    }
    
   /**
    * Fighter attack opponent who's as parameter
    * @param perso
    */
    public void attack(Fighter perso) {
        perso.lifePoints = perso.lifePoints - this.power;
    }

    /**
     * Increase fighter's life points
     */
    public void increaseLifePoints() {
        if(this.lifePoints + 1 <= this.maxLifePoints)
        this.lifePoints++;
    }

    /**
     * Decrease fighter's life points
     */
    public void decreaseLifePoints() {
        if(this.lifePoints -1 >= 0)
        this.lifePoints--;
    }
    
    /**
     * Increase fighter's speed
     */
    public void increaseSpeed() {
        this.speed++;
    }

    /**
     * Decrease fighter's speed
     */
    public void decreaseSpeed() {
        if(this.speed -1 >= 0)
        this.speed--;
    }

    /**
     * Increase fighter's power
     */
    public void increasePower() {
        this.power++;
    }

    /**
     * Decrease fighter's power
     */
    public void decreasePower() {
        if(this.lifePoints -1 >= 0)
        this.power--;
    }

    /**
     * Increase fighter's max life points
     */
    public void increaseMaxLifePoints() {
        this.maxLifePoints++;
    }
    
    /**
     * Says if the fighter is dead
     * @return 
     */
    public boolean isDead(){
        return this.lifePoints <= 0;
    }
}