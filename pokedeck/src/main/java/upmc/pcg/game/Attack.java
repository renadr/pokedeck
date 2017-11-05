package upmc.pcg.game;

import java.util.ArrayList;

/**
 * Created by Adrien on 01/11/2017.
 */
public class Attack {
    private String name;
    private int strenght;
    private ArrayList<String> energy_needed;

    public Attack(String name, int strenght, ArrayList<String> energy_needed){
        this.name=name;
        this.strenght=strenght;
        this.energy_needed=energy_needed;
    }
    public String get_name(){
        return this.name;
    }
    public String get_strenght(){
        return ""+this.strenght;
    }
    public String get_energy_needed(){
        System.out.println("On en a besoin");
        String str="";
        for(int i=0; i<this.energy_needed.size();i++){
            str += this.energy_needed.get(i)+" ";
        }
        return str;
    }

}