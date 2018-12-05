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
public class ItemBoostPower extends Item implements Usable, Serializable{
    
    private final int BOOST_POWER;

    public ItemBoostPower(String objectName, String objectDescription, int booster) {
        super(objectName, objectDescription);
        this.BOOST_POWER = booster;
    }

    @Override
    public void equip(Fighter hero) {
        for(int i =0; i< this.BOOST_POWER; i++)
            hero.increasePower();       
    }

    @Override
    public void unequip(Fighter hero) {
        for(int i =0; i< this.BOOST_POWER; i++)
            hero.decreasePower();
    }
    
}