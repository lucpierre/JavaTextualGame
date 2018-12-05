/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

import java.util.HashMap;
import exitsAndPlaces.Place;
import exitsAndPlaces.Exit;
import exitsAndPlaces.ExitWithItem;
import items.Item;
import exceptions.CreationExitException;
import java.io.Serializable;

/**
 *
 * @author lucqu
 */
public class Exits implements Serializable{
    
    private final HashMap<String, Exit> EXITS_LIST;
    
    public Exits(HashMap<String, Place> lPlaces, HashMap<String, Item> lItems){
        this.EXITS_LIST = new HashMap();
        
        this.addExit("bureau_du_geolier", lPlaces.get("Bureau_du_geolier"));
        this.addExit("cuisine", lPlaces.get("Cuisine"));
        this.addExit("plaine", lPlaces.get("Plaine"));
        this.addExit("silo", lPlaces.get("Silo"));
        this.addExit("ferme", lPlaces.get("Ferme"));
        this.addExit("verger", lPlaces.get("Verger"));
        this.addExit("foret", lPlaces.get("Foret"));
        this.addExit("statue", lPlaces.get("Statue"));
        this.addExit("fontaine", lPlaces.get("Fontaine_des_fees"));
        this.addExit("ville_fantome", lPlaces.get("Ville_fantome"));
        this.addExit("caverne", lPlaces.get("Caverne"));
        this.addExit("verger", lPlaces.get("Verger"));
        this.addExit("flazzard_froid", lPlaces.get("Flazzard_froid"));
        this.addExit("usine", lPlaces.get("Usine"));
        this.addExit("flazzard_chaud", lPlaces.get("Flazzard_chaud"));
        this.addExit("forge", lPlaces.get("Forge"));
        this.addExit("mont_chemine", lPlaces.get("Mont_chemine"));
        this.addExit("lac", lPlaces.get("Lac"));
        this.addExit("cabane", lPlaces.get("Cabane"));
        this.addExit("mer", lPlaces.get("Mer"));
        this.addExit("plage", lPlaces.get("Plage"));
        this.addExit("epave", lPlaces.get("Epave"));
        this.addExit("ville1", lPlaces.get("Ville1"));
        this.addExit("egout", lPlaces.get("Egout"));
        this.addExit("temple", lPlaces.get("Temple"));
        this.addExit("police", lPlaces.get("Police"));
        this.addExit("ville2", lPlaces.get("Ville2"));
        this.addExit("marche", lPlaces.get("Marche"));
        this.addExit("port", lPlaces.get("Port"));
        this.addExit("saloon", lPlaces.get("Saloon"));
        // -----------------------------------------------------------------------------------------------
        this.addExit("chemin_sylvestre", lPlaces.get("Foret"));
        this.addExit("sentier", lPlaces.get("Caverne"));
        this.addExit("chemin_sombre", lPlaces.get("Foret"));
        this.addExit("tunnel_gele", lPlaces.get("Caverne"));
        this.addExit("chemin_lumineux", lPlaces.get("Flazzard_froid"));
        this.addExit("chenal_asseche", lPlaces.get("Flazzard_chaud"));
        this.addExit("banc_de_sable", lPlaces.get("Lac"));
        this.addExit("marecage", lPlaces.get("Ville1"));
        this.addExit("cascade", lPlaces.get("Lac"));
        this.addExit("route_pavee", lPlaces.get("Ville1"));
        this.addExit("route_du_whisky", lPlaces.get("Ville2"));
        this.addExit("chemin_boueux", lPlaces.get("Ville2"));
        this.addExit("route_sinueuse", lPlaces.get("Plaine"));
        this.addExit("pont", lPlaces.get("Mer"));
        this.addExit("embarcadere", lPlaces.get("Ville2"));
        this.addExit("riviere", lPlaces.get("Lac"));
        this.addExit("rapides", lPlaces.get("Mer"));
        //-------------------------------------------------------------------------------------------------
        this.addExitWithItem("chemin_de_la_liberte", lPlaces.get("Plaine"), lItems.get("masque_de_plonge"));
        this.addExitWithItem("grande_porte", lPlaces.get("Ville1"), lItems.get("magic_stick"));
        this.addExitWithItem("sortie_principale", lPlaces.get("Plaine"), lItems.get("magic_stick"));
        this.addExitWithItem("telepherique_monte", lPlaces.get("Flazzard_chaud"), lItems.get("magic_stick"));
        this.addExitWithItem("telepherique_descente", lPlaces.get("Ville1"), lItems.get("magic_stick"));
        this.addExitWithItem("teleporteur", lPlaces.get("Zone"), lItems.get("behelit"));
    }
    
    public HashMap<String, Exit> getExits(){
        return this.EXITS_LIST;
    }
    
    public final void addExit(String exitName, Place place){
        try{
            if (this.EXITS_LIST.put(exitName, new Exit(exitName, place)) == null)
            {
                throw new CreationExitException(exitName);
            }
        }
        catch(CreationExitException e){
            e.getMessage();
        }
    }
    
    public final void addExitWithItem(String exitName, Place place, Item item){
        try{
            if (this.EXITS_LIST.put(exitName, new ExitWithItem(item, exitName, place)) == null)
            {
                throw new CreationExitException(exitName);
            }
        }
        catch(CreationExitException e){
            e.getMessage();
        }
    }
}
