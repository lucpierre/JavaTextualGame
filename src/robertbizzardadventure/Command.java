package robertbizzardadventure;

import exitsAndPlaces.Exit;
import characters.Character;
import characters.Hero;
import characters.PNJ;
import java.util.HashMap;
import java.util.Scanner;
import exceptions.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public enum Command {
        GO,
        HELP,
        TAKE,
        QUIT,
        USE,
        LOOK,
        TALK,
        PROFIL,
        SAVE,
        LOAD,
        BAG;
        
        
    public void execSave(Game g){
        ObjectOutputStream oos = null;
        
        try{
            final FileOutputStream fichier = new FileOutputStream("save.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(g);
            oos.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public void execLoad(Game g){
        ObjectInputStream ois = null;
        
        try {
            final FileInputStream fichier = new FileInputStream("save.ser");
            ois = new ObjectInputStream(fichier);
            g = (Game) ois.readObject();
            g.runGame();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
        
        
    public void execGo(String useExit, Character hero, HashMap<String, Exit> exitsGame) throws UnknowExitException{
        if(hero.getCurrentPlace().getExitsNames().contains(useExit))
        {
            hero.changeCurrentPlace(exitsGame.get(useExit));
            System.out.println("Vous prenez la direction : " + useExit);
        }
        else
        {
            throw new UnknowExitException(useExit);
        }
    }
    
    public void execHelp(){
        System.out.println(" Vous pouvez saisir :\n"
                + "- GO : suivi d'une sortie\n"
                + "- TAKE : suivi d'un objet\n"
                + "- LOOK : regardez autour de vous\n "
                + "- TALK : suivi d'un personnage\n "
                + "- PROFILE : affiche vos stats\n "
                + "- HELP : affiche l'aide\n"
                + "- USE : suivi d'un objet\n"
                + "- BAG : affiche votre inventaire\n"
                + "- SAVE : sauvegarde votre partie et quitte le jeu\n"
                + "- QUIT : quitte le jeu\n "
        );
    }
    
    public void execLook(Hero hero){
        System.out.println("Vous regardez autour de vous ");
        System.out.println("Objet(s) : ");
        hero.examinePlaceItems().forEach(x-> System.out.println(x.getNAME()));
        System.out.println("Exits : ");
        hero.getCurrentPlace().getEXITS().forEach(x-> System.out.println(x.getNAME()));
        System.out.println("Character(s) : ");
        hero.examinePlaceCharacters().forEach(x-> System.out.println(x.getNAME()));
    }
    
    public void execTake(Hero hero, String wordObject) throws UnknowItemException{
        if(hero.getCurrentPlace().getItemsNames().contains(wordObject)){
            hero.takeItem(wordObject);
        }
        else
        {
            throw new UnknowItemException(wordObject);
        }
    }
    
    public void execQuit(){
        System.out.println("A bientot");
        System.exit(0);
    }
    
    public void execBag(Hero hero){
        System.out.println("Votre sac contient : ");
        hero.printInventory();
    }
    
    public void execUse(Hero hero, String wordItem) throws UnknowItemException{
        if(hero.haveItem(wordItem)){
            hero.useItem(wordItem);
        }
        else
        {
            throw new UnknowItemException(wordItem);
        }
    }
    
    public void execTalk(Character hero, String pnjname){
        if(((Character)hero).getCurrentPlace().getCharactersNames().contains(pnjname)){
            Character pnj = ((Character)hero).getCurrentPlace().getCharacterByName(pnjname);
            System.out.println(((PNJ)pnj).speak());
            if( !((Character)pnj).getInventory().isEmpty() ){
                ((PNJ)pnj).giveItem(hero);
            }
       }else{
            System.out.println("Il ni y'a personne a qui parler");
        }
    }
    
    public void execProfil(Hero hero){
        hero.printCurrentState(); 
    }
    
    public static void OneStep(Game g, Character hero, HashMap<String, Exit> exitsGame){ 
            
        Scanner scanCommand = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------------------------------");
        System.out.println("Vous etes dans le lieu : " + hero.getCurrentPlace().getNAME());
        System.out.println(hero.getCurrentPlace().printDescription());
        System.out.println("Que voulez-vous faire ?");
        System.out.println("-------------------------------------------------");
        String phraseATaper = scanCommand.nextLine(); 
        String [] keywords = phraseATaper.split(" ");
        keywords[0] = keywords[0].toUpperCase();
        
        try{
            switch(keywords[0].toUpperCase()){
                case "GO":
                    try{ 
                        Command.GO.execGo(keywords[1].toLowerCase(), hero, exitsGame);
                    }
                    catch (UnknowExitException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HELP":
                    Command.HELP.execHelp();
                    break;
                case "TAKE" :
                    try{ 
                        Command.TAKE.execTake((Hero)hero, keywords[1].toLowerCase());
                    }
                    catch (UnknowItemException e){
                        System.out.println(e.getMessage());
                    }
                    break;  
                case "QUIT" : 
                    System.out.println("A bientot ou lance une sauvegarde");
                    System.exit(0);
                    break; 
                case "SAVE" : 
                    Command.SAVE.execSave(g);
                    System.out.println("A bientot !");
                    System.exit(0);
                    break; 
                case "USE" :
                    try{ 
                        Command.USE.execUse((Hero)hero, keywords[1].toLowerCase()); 
                    }
                    catch (UnknowItemException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "LOOK" :
                    Command.LOOK.execLook((Hero)hero);
                break;
                case "BAG" :
                    Command.BAG.execBag((Hero)hero);
                    break;
                case "TALK" : 
                    Command.TALK.execTalk((Hero)hero, keywords[1].toLowerCase());
                    break;
                case "PROFIL" : 
                    Command.PROFIL.execProfil((Hero)hero);
                    break;
                default : 
                    throw new UnknowCommandException(keywords[0]);
                }
        }
        catch(UnknowCommandException e ){
            e.getMessage();
        }
        catch( ArrayIndexOutOfBoundsException e){
            System.out.println("Mauvais nombre de parametres.");
        }
    }
    
    public static void startGame(Game g){
        Scanner scanCommand = new Scanner(System.in);
        
        System.out.println("-------------------------------------");
        System.out.println("------------- Bienvenue -------------");
        System.out.println("-------------------------------------");
        System.out.println("Que voulez-vous faire :");
        System.out.println("new : lance une nouvelle partie");
        System.out.println("load : charge la dernière partie");
        g = new Game();
        String phraseATaper = scanCommand.nextLine(); 
        String [] keywords = phraseATaper.split(" ");
        keywords[0] = keywords[0].toUpperCase();
        
        try{
            switch(keywords[0].toUpperCase()){
                case "NEW" :
                    System.out.println("Sur une planete lointaine ... très lointaine, Robert un ancien Cowboy de Zetorah, inculpé à tord ,\n"
                    + "serait responsable des nombreuses catastrophes de sa planete. Enfermé dans une prisons de haute sécurité sur\n"
                    + "une île au beau milieu de nul part, on dit qu'il préparerait son retour pour prouver son innocence et retrouver\n"
                    + " le véritable coupable ...");                   
                    g.runGame();
                    break;
                case "LOAD" :
                    Command.LOAD.execLoad(g);
                    break;
            }
        }
        catch(Exception e){
        }
    }
}