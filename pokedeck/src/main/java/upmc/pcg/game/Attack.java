package upmc.pcg.game;

import upmc.pcg.ui.MenuUI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Adrien on 01/11/2017.
 */
public class Attack {

    private String name;
    private int damage;
    private String description;
    private ArrayList<Energy> energies;

    /**
     * Default constructor for a basic attack if autoFill is true, ask the user to fill the fields if false
     */
    public Attack(boolean autoFill) {
        if(autoFill) {
            this.energies = new ArrayList<>();
            this.name = "Basic attack";
            this.energies.add(Energy.Colorness);
            this.damage = 10;
            this.description = "The most basic attack a pokemon can do. Seriously, it's just a slap.";
        }
        else {
            fill_attack();
        }
    }

    /**
     * Ask the user how to fill the attacks
     */
    private void fill_attack() {
        HashMap<String, Object> valuesForAttributes = new HashMap<>();

        valuesForAttributes = MenuUI.attack_ask_all();

        this.name = (String)valuesForAttributes.get("name");
        this.energies = (ArrayList<Energy>)valuesForAttributes.get("neededEnergy");
        this.damage = (int)valuesForAttributes.get("damage");
        this.description = (String)valuesForAttributes.get("description");
    }

}
