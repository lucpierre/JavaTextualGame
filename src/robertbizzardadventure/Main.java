/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robertbizzardadventure;


/**
 *
 * @author lucqu
 */
public class Main{
    
    public Game g;
    
    public static void main(String args[]){
        Game g = new Game();
        
        Command.startGame(g);
        
    }
}