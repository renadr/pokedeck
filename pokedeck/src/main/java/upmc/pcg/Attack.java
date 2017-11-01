package upmc.pcg;

import java.util.ArrayList;

/**
 * Created by Adrien on 01/11/2017.
 */
public class Attack {

    private String name;
    private String description;
    private int damage;
    private ArrayList<Energy> energies;

    public Attack(String name, String description, int damage, ArrayList<Energy> energies) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.energies = energies;
    }

}
