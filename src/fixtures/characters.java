/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import characters.Character;
import characters.Fighter;
import characters.PNJ;
import exceptions.CreationCharacterException;
import items.Item;
import exitsAndPlaces.Place;
import java.io.Serializable;
/**
 *
 * @author lucqu
 */
public class characters implements Serializable{
    
    private final HashMap<String, Character> CHARACTERS_LIST;

    
    
    public characters(HashMap<String, Place> lPlaces){
        
        this.CHARACTERS_LIST = new HashMap();
        
        // Fighter
        this.addFighter("geolier", lPlaces.get("Bureau_du_geolier"), 20, 50, 150);
        this.addFighter("sherif", lPlaces.get("Police"), 40, 300, 120);
        this.addFighter("fermier", lPlaces.get("Ferme"), 10, 100, 80);
        this.addFighter("corbeaux", lPlaces.get("Verger"), 30, 75, 200);
        this.addFighter("vieil_homme_mysterieux", lPlaces.get("Caverne"), 40, 200, 80);
        this.addFighter("spectre", lPlaces.get("Ville_fantome"), 10, 300, 100);
        this.addFighter("boss", lPlaces.get("Zone"), 100, 1000, 200);
        this.addFighter("parrain", lPlaces.get("Egout"), 60, 600, 100);
        
        // PNJ
        this.CHARACTERS_LIST.put("fee", new PNJ("fee", lPlaces.get("Fontaine_des_fees"), "J'espere que ma potion te seras utile !"));
        this.CHARACTERS_LIST.put("nain", new PNJ("nain", lPlaces.get("Forge"), "Avec cet engrenage tu pourras surement relancer l'usine et donc le courant !"));
        this.CHARACTERS_LIST.put("dragon", new PNJ("dragon", lPlaces.get("Mont_chemine"), "Toi un jour je te crame ta famille, toi."));
        this.CHARACTERS_LIST.put("cadavre", new PNJ("cadavre", lPlaces.get("Usine"), "Avec l'engrenage on pourra relancer l'usine, et creer de nouveaux ces magic-stiks"));
        this.CHARACTERS_LIST.put("popeye", new PNJ("popeye", lPlaces.get("Port"), "Dans la vie, j'avais deux ennemis : le vocabulaire et les épinards"));
        this.CHARACTERS_LIST.put("barman", new PNJ("barman", lPlaces.get("Saloon"), "Est-ce qu'il ferait pas soif ?!"));
        this.CHARACTERS_LIST.put("surfeuse", new PNJ("surfeuse", lPlaces.get("Plage"), "J'ai besoin d'un bouche à bouche car je viens de me noyer dans ton regard, classe le chapia !"));
        this.CHARACTERS_LIST.put("samourai", new PNJ("samourai", lPlaces.get("Temple"), "Robert .. c'est ça que tu cherches ?!"));
        this.CHARACTERS_LIST.put("vieille_femme", new PNJ("vieille_femme", lPlaces.get("Cabane"), "Z'auriez pas vu mon mari ?"));

    }
    
    public HashMap<String, Character> getCHARACTERS_LIST() {
        return this.CHARACTERS_LIST;
    }
    
    public final void addFighter(String characterName, Place place, int pow, int lP, int speed){
        try{
            if (this.CHARACTERS_LIST.put(characterName, new Fighter(characterName, place, pow, lP, speed)) == null)
            {
                throw new CreationCharacterException(characterName);
            }
        }
        catch(CreationCharacterException e){
            e.getMessage();
        }
    }
    
    
    public void setItems(HashMap<String, Item> listOfItems){
        Set<Entry<String, Character>> setHm = this.CHARACTERS_LIST.entrySet();
        Iterator<Entry<String, Character>> it = setHm.iterator();
        while(it.hasNext()){
            Entry<String, Character> character = it.next();
            switch(character.getValue().getNAME()){
                case "samourai" : character.getValue().addItemInInventory(listOfItems.get("sabre"));
                break;
                case "nain" : character.getValue().addItemInInventory(listOfItems.get("tongues"));
                break;
                case "fee" : character.getValue().addItemInInventory(listOfItems.get("potion"));
                break;
                case "dragon" : character.getValue().addItemInInventory(listOfItems.get("lance_flamme"));
                break;
                case "popeye" : character.getValue().addItemInInventory(listOfItems.get("ancre"));
                break;
                case "cadavre" : character.getValue().addItemInInventory(listOfItems.get("magic_stick"));
                break;
                default :
                    System.out.print("");
            }
        }
    }
    
    
}