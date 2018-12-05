/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author lucqu
 */
public class UnknowItemException extends Exception{
    
    private final String ITEM;
    
    public UnknowItemException(String item){
        this.ITEM = item;
    }
    
    @Override
    public String getMessage(){
        return "L'objet : " + this.ITEM + " est introuvable.";
    }
    
}
