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
public class CreationExitException extends Exception{
    
    private final String EXIT_NAME;
    
    public CreationExitException(String exitName){
        this.EXIT_NAME = exitName;
    }
    
    @Override
    public String getMessage(){
        return "Impossible de créer la sortie : " + this.EXIT_NAME;
    }
    
}
