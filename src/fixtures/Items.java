/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

import java.util.HashMap;
import items.*;
import java.io.Serializable;
/**
 *
 * @author lucqu
 */
public class Items implements Serializable{
    
    private final HashMap<String, Item> ITEMS_LIST;
    
    public Items(){
        
        this.ITEMS_LIST = new HashMap();
        
        //Objets de quètes
        this.ITEMS_LIST.put("chaine", new ItemBasic("chaine", "C'est peut-être utile pour enchainer les gens"));
        this.ITEMS_LIST.put("badge", new ItemBasic("badge","Y'a comme un truc écrit dessus...Il faudra arrêter le whisky pour parvenir à le lire"));
        this.ITEMS_LIST.put("masque_de_plonge", new ItemBasic("masque_de_plonge", "A moi le liberté !"));
        this.ITEMS_LIST.put("falsar", new ItemBasic("falsar", "Un vieux pantalon, qui semble bien protéger de la météo."));
        this.ITEMS_LIST.put("behelit", new ItemBasic("behelit", "Un objet mystérieux."));
        this.ITEMS_LIST.put("magic_stick", new ItemBasic("magic_stick", "C'est un bâton magique qui produit de l'éléctricité, il pourra surement servir à l'avenir !"));
        
        
        //++Power
        this.ITEMS_LIST.put("cuillere", new ItemBoostPower("cuillere","(+2 Power) Prévue pour creuser un trou et s'échapper...on la garde quand même!", 2));
        this.ITEMS_LIST.put("couteau", new ItemBoostPower("couteau","(+8 Power) Un couteau quoi",8));
        this.ITEMS_LIST.put("arc", new ItemBoostPower("arc", "(+30 Power) Vous avez quand même dépouillé une statue de son arc",30));
        this.ITEMS_LIST.put("lance_flamme", new ItemBoostPower("lance_flamme","(+100 Power) A ne pas utiliser pour griller sa viande",100));
        this.ITEMS_LIST.put("sabre", new ItemBoostPower("sabre","(+50 Power ) Attention, ça coupe",50));
        this.ITEMS_LIST.put("ancre", new ItemBoostPower("ancre","(+100 Power) Ils ont l'air bons avec un peu de beurre", 100));
        
        //++PV Max
        this.ITEMS_LIST.put("potion", new ItemBoostMaxLifePoints("potion","(+200 Max Life Points) La drogue, c'est mal...mais là, il le faut!", 200));
        this.ITEMS_LIST.put("tenue", new ItemBoostMaxLifePoints("tenue","(+100 Max Life Points) Voici de quoi vous couvrir un minimum", 100));
        this.ITEMS_LIST.put("tenue_sup", new ItemBoostMaxLifePoints("tenue_sup","(+200 Max Life Points) Le vent ne vous chatouillera plus le ventre avec ça!",200));
        this.ITEMS_LIST.put("tenue_blindee", new ItemBoostMaxLifePoints("tenue_blindee","(+300 Max Life Points) Vous semblez enfin habillé", 300));
        
        //++life
        this.ITEMS_LIST.put("poisson", new ItemHeal("poisson","(+10 Life Points) Il est frais", 10));
        this.ITEMS_LIST.put("tacos", new ItemHeal("tacos","(+500 Life Points) Pourquoi ne pas en prendre un deuxième?", 500));
        this.ITEMS_LIST.put("champignon", new ItemHeal("champignon","(+50 Life Points) Attention à ne pas halluciner", 50));
        this.ITEMS_LIST.put("poulet", new ItemHeal("poulet","(+100 Life Points) Cuit, ça doit être bon",100));
        this.ITEMS_LIST.put("oeuf", new ItemHeal("oeuf","(+30 Life Points) On dirait que ça se mange",30));
        this.ITEMS_LIST.put("fruits", new ItemHeal("fruits","(+1 Life Points) A manger avec modération",1));
        this.ITEMS_LIST.put("whisky", new ItemHeal("whisky","(+200 Life Points) Attention à ne pas le noyer",200));
        
        //++Speed
        this.ITEMS_LIST.put("chaussures", new ItemBoostSpeed("chaussures", "(+100 Life Points) Voilà des chaussures qui courent vite", 100));
        this.ITEMS_LIST.put("tongues", new ItemDecreaseSpeed("tongues", "Essaie dont de courir avec ça twa !", -100));
       
        //Inutile mais fun
        this.ITEMS_LIST.put("canne_a_peche", new ItemBasic("canne_a_peche","On peut s'en servir pour attraper du poisson, ou des gens"));
        this.ITEMS_LIST.put("chapeau", new ItemBasic("chapeau","Il vous donne vraiment l'air classe"));
        this.ITEMS_LIST.put("livre", new ItemBasic("livre","Trop de choses à lire"));
    }
    
    public HashMap<String, Item> getItems(){
        return this.ITEMS_LIST;
    }
}