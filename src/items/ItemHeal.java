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
public class ItemHeal extends Item implements Usable, Serializable{
    
    private final int HEAL;

    public ItemHeal(String objectName, String objectDescription, int heal) {
        super(objectName, objectDescription);
        this.HEAL = heal;
    }

    @Override
    public void equip(Fighter hero) {
        for(int i =0; i< this.HEAL; i++)
            hero.increaseLifePoints();
    }
    
    @Override
    public void unequip(Fighter hero) {
        System.out.println("Ne peut être retiré ou diminué");
    }
}