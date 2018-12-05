/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Charles
 */
public interface Gameplay {
    
    public abstract void bag();
    
    public abstract void go();
    
    public abstract void help();
    
    public abstract void look();
    
    public abstract void take();
    
    public abstract void quit();
    
    public abstract void use();
    
    public abstract void loadGame();
    
    public abstract void startGame();
    
    public abstract void exitGame();
    
    public abstract void askUser();
    
    public abstract void askWhatWeDo();
    
    public abstract void talk();
    
    public abstract void oneStep();
    
}
