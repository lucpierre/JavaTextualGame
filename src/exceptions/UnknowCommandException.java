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
public class UnknowCommandException extends Exception{
    
    private final String COMMAND;
    
    public UnknowCommandException(String command){
        this.COMMAND = command;
    }
    
    @Override
    public String getMessage(){
        return "La commande : " + this.COMMAND + " n'existe pas.";
    }
    
}
