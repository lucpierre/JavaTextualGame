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
public class CreationPlaceException extends Exception{
    
    private final String PLACE_NAME;
    
    public CreationPlaceException(String placeName){
        this.PLACE_NAME = placeName;
    }
    
    @Override
    public String getMessage(){
        return "Erreur lors de la creation du lieu : " + this.PLACE_NAME;
    }
    
}
