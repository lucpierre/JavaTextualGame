/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import characters.Fighter;

/**
 *
 * @author Charles
 */
public interface Usable{
    
    public abstract void equip(Fighter hero);
    
    public abstract void unequip(Fighter hero);
    
}
