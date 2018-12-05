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
public class CreationCharacterException extends Exception{
    
    private final String name;
    
    public CreationCharacterException(String name){
        this.name = name;
    }
    
    @Override
    public String getMessage(){
        return "Le personnage : " + this.name + " n'a pas pu être créé."; 
    }
    
    
}
