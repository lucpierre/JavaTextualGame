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
public class ItemBasic extends Item implements Usable, Serializable{

    public ItemBasic(String objectName, String objectDescription) {
        super(objectName, objectDescription);
    }

    @Override
    public void equip(Fighter hero) {
        System.out.println("Bah voilà");
    }
    
    @Override
    public void unequip(Fighter hero) {
        System.out.println("Ne peut être retiré ou diminué");
    }
    
}