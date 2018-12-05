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
public class UnknowExitException extends Exception{
    
    private final String EXIT;
    
    public UnknowExitException(String exit){
        this.EXIT = exit;
    }
    
    @Override
    public String  getMessage(){
        return "La sortie : " + this.EXIT + " n'existe pas.";
    }
}
