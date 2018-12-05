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
import exitsAndPlaces.Exit;
import items.Item;
import characters.Character;
import exceptions.CreationPlaceException;

import exitsAndPlaces.Place;
import exitsAndPlaces.Weather;
import java.io.Serializable;

/**
 *
 * @author lucqu
 */
public class Places implements Serializable{
    
    private final  HashMap<String, Place> PLACES_LIST;
    
    public Places(){
        this.PLACES_LIST = new HashMap();
        
        this.addPlace("Cellule", Weather.DEFAULT, "Quel trou pourri !");
        this.addPlace("Bureau_du_geolier", Weather.DEFAULT, "Un bureau mal rangé...et un vieux carton avec un objet rare!");
        this.addPlace("Cuisine", Weather.DEFAULT,"Il y assez pour nourrir un régiment ici !  On peut voir un étrange plongeoir");
        this.addPlace("Plaine", Weather.DEFAULT, "Une vaste plaine");
        this.addPlace("Silo", Weather.DEFAULT, "Un grand truc métallique qui se voit de loin se dresse devant vous");
        this.addPlace("Plaine", Weather.DEFAULT, "Une vaste plaine");
        this.addPlace("Ferme", Weather.DEFAULT, "On voit d'apétissant animaux d'élévage");
        this.addPlace("Verger", Weather.DEFAULT, "Des fruits de haut en bas...rudement protégés");
        this.addPlace("Foret", Weather.DEFAULT, "On entend une douce melodie venir du fond de la foret");
        this.addPlace("Statue", Weather.DEFAULT,"Une statue imposante et mystérieuse");
        this.addPlace("Fontaine_des_fees", Weather.DEFAULT,"Une magnifique fee qui chante (horriblement faux) au bord d'une fontaine");
        this.addPlace("Caverne", Weather.DEFAULT,"Cette caverne est sombre et lugubre...Vous ne distinguez à peine vos pieds");
        this.addPlace("Flazzard_froid", Weather.DEFAULT,"Une vaste etendue de glace et de neige s'offre à vous");
        this.addPlace("Ville_fantome", Weather.DEFAULT, "Des hurlements se font entendre ! Ne vous attardez pas trop ici!");
        this.addPlace("Usine", Weather.DEFAULT, "Des cadavres jonches le sol devant ce qui semble être une usine désafectées");
        this.addPlace("Flazzard_chaud", Weather.DEFAULT, "Il fait chaud...votre sueur s'évapore avant même de toucher sol");
        this.addPlace("Forge", Weather.DEFAULT, "Un sympathique village de petits habitants qui semble manier le fer et l'acier");
        this.addPlace("Mont_chemine", Weather.DEFAULT,  "Un fier et immense Dragon se tient face à vous...il semble parler le language des hommes, et avoir déjà mangé aujourd'hui");
        this.addPlace("Lac", Weather.DEFAULT,  "Un taudis sur un coin d'eau...une envie de repos et de peche vous trotte dans la tête");
        this.addPlace("Cabane", Weather.DEFAULT, "La cabane semble abandonnée de l'extérieur, mais il y a bien une vieille dame qui y vit...elle insiste pour que vous mangiez de la confiture");
        this.addPlace("Mer", Weather.DEFAULT,"Il fait beau...le sable est fin, des surfeurs s'élancent au loin sur les vagues. Vous trainez vos pieds dans le sable en longeant la côte");
        this.addPlace("Plage", Weather.DEFAULT,"Du sable...partout...et des détritus et objets en tout genre");
        this.addPlace("Epave", Weather.DEFAULT,"Vous ressentez une impressionante aura et un pouvoir magique...il serait plus prudent de se préparer au pire");
        this.addPlace("Ville1", Weather.DEFAULT,"Il semble régner dans cette ville un climat de peur. Les villageois sont tendues et vous regarde bizzarement");
        this.addPlace("Egout", Weather.DEFAULT,"Un lieu puant et déséagréable. Un gang de mafieux semble y avoir installé son repaire");
        this.addPlace("Temple", Weather.DEFAULT,"Un samourai garde son vieux temple de toute attaque extérieur. Il semble sociable et très puissant.");
        this.addPlace("Police", Weather.DEFAULT,"De quoi s'armer ici, quand vous aurez mit hors de nuire ceux qui on participé à votre arrestation");
        this.addPlace("Ville2", Weather.DEFAULT,"Voici une ville riche et calme");
        this.addPlace("Marche", Weather.DEFAULT,"Peut-être trouverez vous chaussures à votre pieds dans ce marché");
        this.addPlace("Port", Weather.DEFAULT,"Un homme fort se tient face à la mer");
        this.addPlace("Saloon", Weather.DEFAULT,"Allez donc boire un verre! Il faut bien s'hydrater");
        this.addPlace("Zone", Weather.DEFAULT,"Néant ...");
    }
    
    public HashMap<String, Place> getPlaces(){
        return this.PLACES_LIST;
    }
    
    public final void addPlace (String placeName, Weather weather, String description){
        try{
            if(this.PLACES_LIST.put(placeName, new Place(placeName, weather, description)) == null){
                throw new CreationPlaceException(placeName);
            }
        }
        catch(CreationPlaceException e){
            e.getMessage();
        }
    }
    
    public void setExits(HashMap<String, Exit> listOfExits){
        Set<Entry<String, Place>> setHm = this.PLACES_LIST.entrySet();
        Iterator<Entry<String, Place>> it = setHm.iterator();
        while(it.hasNext()){
            Entry<String, Place> place = it.next();
            switch(place.getValue().getNAME()){
                //Prison
                case "Cellule" : place.getValue().addExit(listOfExits.get("bureau_du_geolier"));
                break;
                case "Bureau_du_geolier" : place.getValue().addExit(listOfExits.get("cuisine"));
                break;
                case "Cuisine" : place.getValue().addExit(listOfExits.get("chemin_de_la_liberte"));
                place.getValue().addExit(listOfExits.get("bureau_du_geolier"));
                break;
                //----------------------------------------------------------------------
                //Foret
                case "Foret" : place.getValue().addExit(listOfExits.get("statue"));
                place.getValue().addExit(listOfExits.get("fontaine"));
                place.getValue().addExit(listOfExits.get("plaine"));
                break;
                case "Statue": place.getValue().addExit(listOfExits.get("foret"));
                break;
                case "Fontaine_des_fees": place.getValue().addExit(listOfExits.get("foret"));
                place.getValue().addExit(listOfExits.get("sentier"));
                break;
                //-----------------------------------------------------------------------
                // Plaine
                case "Plaine" : place.getValue().addExit(listOfExits.get("ferme"));
                place.getValue().addExit(listOfExits.get("silo"));
                place.getValue().addExit(listOfExits.get("verger"));
                break;
                case "Ferme" : place.getValue().addExit(listOfExits.get("plaine"));
                place.getValue().addExit(listOfExits.get("grande_porte"));
                break;
                case "Silo" : place.getValue().addExit(listOfExits.get("plaine"));
                break;
                case "Verger" : place.getValue().addExit(listOfExits.get("plaine"));
                place.getValue().addExit(listOfExits.get("chemin_sylvestre"));
                place.getValue().addExit(listOfExits.get("chemin_boueux"));
                break;
                //-----------------------------------------------------------------------
                //Caverne
                case "Caverne" : place.getValue().addExit(listOfExits.get("chemin_lumineux"));
                place.getValue().addExit(listOfExits.get("chemin_sombre"));
                break;
                //-----------------------------------------------------------------------
                // Flazzard-froid
                case "Usine" : place.getValue().addExit(listOfExits.get("flazzard_froid"));
                break;
                case "Ville_fantome" : place.getValue().addExit(listOfExits.get("flazzard_froid"));
                place.getValue().addExit(listOfExits.get("tunnel_gele"));
                break;
                case "Flazzard_froid" : place.getValue().addExit(listOfExits.get("ville_fantome"));
                place.getValue().addExit(listOfExits.get("flazzard_chaud"));
                break;
                //-----------------------------------------------------------------------
                // Flazzard-chaud
                case "Forge" : place.getValue().addExit(listOfExits.get("flazzard_chaud"));
                break;
                case "Mont_chemine" : place.getValue().addExit(listOfExits.get("flazzard_chaud"));
                break;
                case "Flazzard_chaud" : place.getValue().addExit(listOfExits.get("banc_de_sable"));
                place.getValue().addExit(listOfExits.get("forge"));
                place.getValue().addExit(listOfExits.get("mont_chemine"));
                break;
                //-----------------------------------------------------------------------
                // Lac
                case "Lac" : place.getValue().addExit(listOfExits.get("marecage"));
                place.getValue().addExit(listOfExits.get("rapides"));
                place.getValue().addExit(listOfExits.get("cabane"));
                break;
                case "Cabane" : place.getValue().addExit(listOfExits.get("lac"));
                place.getValue().addExit(listOfExits.get("chenal_asseche"));
                break;
                //-----------------------------------------------------------------------
                //Mer
                case "Mer" : place.getValue().addExit(listOfExits.get("embarcadere"));
                place.getValue().addExit(listOfExits.get("plage"));
                place.getValue().addExit(listOfExits.get("epave"));
                break;
                case "Plage" : place.getValue().addExit(listOfExits.get("mer"));
                place.getValue().addExit(listOfExits.get("riviere"));
                break;
                case "Epave" : place.getValue().addExit(listOfExits.get("mer"));
                place.getValue().addExit(listOfExits.get("teleporteur"));
                break;
                //-------------------------------------------------------------------------
                //Ville1
                case "Ville1" : place.getValue().addExit(listOfExits.get("sortie_principale"));
                place.getValue().addExit(listOfExits.get("route_du_whisky"));
                place.getValue().addExit(listOfExits.get("police"));
                place.getValue().addExit(listOfExits.get("egout"));
                place.getValue().addExit(listOfExits.get("temple"));
                break;
                case "Police" : place.getValue().addExit(listOfExits.get("ville1"));
                place.getValue().addExit(listOfExits.get("telepherique_monte"));
                break;
                case "Egout" : place.getValue().addExit(listOfExits.get("cascade"));
                place.getValue().addExit(listOfExits.get("ville1"));
                break;
                case "Temple" : place.getValue().addExit(listOfExits.get("ville1"));
                break;
                //--------------------------------------------------------------------------
                //Ville2   
                case "Ville2" : place.getValue().addExit(listOfExits.get("route_pavee"));
                place.getValue().addExit(listOfExits.get("saloon"));
                place.getValue().addExit(listOfExits.get("marche"));
                place.getValue().addExit(listOfExits.get("port"));
                break;
                case "Marche" :  place.getValue().addExit(listOfExits.get("ville2"));
                place.getValue().addExit(listOfExits.get("route_sinueuse"));
                break;
                case "Port" :  place.getValue().addExit(listOfExits.get("ville2"));
                place.getValue().addExit(listOfExits.get("pont"));
                break;
                case "Saloon" : place.getValue().addExit(listOfExits.get("ville2"));
                break;
                default: System.out.print("");
            }
        }
    }
    
    public void setItems(HashMap<String, Item> listOfItems){
        Set<Entry<String, Place>> setHm = this.PLACES_LIST.entrySet();
        Iterator<Entry<String, Place>> it = setHm.iterator();
        while(it.hasNext()){
            Entry<String, Place> place = it.next();
            switch(place.getValue().getNAME()){
                case "Cuisine" : place.getValue().addItem(listOfItems.get("cuillere"));
                place.getValue().addItem(listOfItems.get("couteau"));
                break;
                case "Cellule" : place.getValue().addItem(listOfItems.get("livre"));
                break;
                case "Bureau_du_geolier" : place.getValue().addItem(listOfItems.get("masque_de_plonge"));
                place.getValue().addItem(listOfItems.get("chaine"));
                break;
                case "Foret" : place.getValue().addItem(listOfItems.get("champignon"));
                break;
                case "Statue": place.getValue().addItem(listOfItems.get("arc"));
                break;
                case "Ferme" : place.getValue().addItem(listOfItems.get("poulet"));
                place.getValue().addItem(listOfItems.get("oeuf"));
                break;
                case "Silo" : place.getValue().addItem(listOfItems.get("tenue"));
                break;
                case "Verger" : place.getValue().addItem(listOfItems.get("fruits"));
                break;
                case "Caverne" : place.getValue().addItem(listOfItems.get("falsar"));
                break;
                case "Usine" : place.getValue().addItem(listOfItems.get("tenue_sup"));
                break;
                case "Cabane" : place.getValue().addItem(listOfItems.get("canne_a_peche"));
                break;
                case "Plage" : place.getValue().addItem(listOfItems.get("chapeau"));
                break;
                case "Epave" : place.getValue().addItem(listOfItems.get("behelit"));
                break;
                case "Police" : place.getValue().addItem(listOfItems.get("tenue_blindee"));
                break;
                case "Marche" :  place.getValue().addItem(listOfItems.get("chaussures"));
                place.getValue().addItem(listOfItems.get("poisson"));
                break;
                case "Saloon" : place.getValue().addItem(listOfItems.get("whisky"));
                place.getValue().addItem(listOfItems.get("tacos"));
                place.getValue().addItem(listOfItems.get("badge"));
                break;
                default:
                    System.out.print("");
            }
        }
    }
    
    public void setCharacters(HashMap<String, Character> listOfCharacters){
        Set<Entry<String, Place>> setHm = this.PLACES_LIST.entrySet();
        Iterator<Entry<String, Place>> it = setHm.iterator();
        while(it.hasNext()){
            Entry<String, Place> place = it.next();
            switch(place.getValue().getNAME()){
                case "Bureau_du_geolier" : place.getValue().addCharacter(listOfCharacters.get("geolier"));
                break;
                case "Fontaine_des_fees": place.getValue().addCharacter(listOfCharacters.get("fee"));
                break;
                case "Ferme" : place.getValue().addCharacter(listOfCharacters.get("fermier"));
                break;
                case "Verger" : place.getValue().addCharacter(listOfCharacters.get("corbeaux"));
                break;
                case "Caverne" : place.getValue().addCharacter(listOfCharacters.get("vieil_homme_mysterieux"));
                break;
                case "Forge" : place.getValue().addCharacter(listOfCharacters.get("nain"));
                break;
                case "Mont_chemine" : place.getValue().addCharacter(listOfCharacters.get("dragon"));
                break;
                case "Usine" : place.getValue().addCharacter(listOfCharacters.get("cadavre"));
                break;
                case "Ville_fantome" : place.getValue().addCharacter(listOfCharacters.get("spectre"));
                break;
                case "Cabane" : place.getValue().addCharacter(listOfCharacters.get("vieille_femme"));
                break;
                case "Plage" : place.getValue().addCharacter(listOfCharacters.get("surfeuse"));
                break;
                case "Egout" : place.getValue().addCharacter(listOfCharacters.get("parrain"));
                break;
                case "Temple" : place.getValue().addCharacter(listOfCharacters.get("samourai"));
                break;
                case "Police" : place.getValue().addCharacter(listOfCharacters.get("sherif"));
                break;
                case "Port" : place.getValue().addCharacter(listOfCharacters.get("popeye"));
                break;
                case "Saloon" : place.getValue().addCharacter(listOfCharacters.get("barman"));
                break;
                case "Zone" : place.getValue().addCharacter(listOfCharacters.get("boss"));
                break;
                default:
                  
                    System.out.print("");
            }
        }
    }
}