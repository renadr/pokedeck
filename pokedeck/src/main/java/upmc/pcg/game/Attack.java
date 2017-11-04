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

    public Attack(String name, int damage, String description,ArrayList<Energy>energies) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.energies = energies;
    }


}
