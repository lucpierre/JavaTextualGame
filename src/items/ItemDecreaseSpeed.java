/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import characters.Fighter;
import interfaces.Usable;
import java.io.Serializable;

/**
 *
 * @author Charles
 */
public class ItemDecreaseSpeed extends Item implements Usable, Serializable{
    
    private final int BOOST_SPEED;

    public ItemDecreaseSpeed(String objectName, String objectDescription, int booster) {
        super(objectName, objectDescription);
        this.BOOST_SPEED = booster;
    }

    @Override
    public void equip(Fighter hero) {
        for(int i =0; i> this.BOOST_SPEED; i--)
            hero.decreaseSpeed();
    }

    @Override
    public void unequip(Fighter hero) {
        for(int i =0; i> this.BOOST_SPEED; i--)
            hero.increaseSpeed();
    }
    
}