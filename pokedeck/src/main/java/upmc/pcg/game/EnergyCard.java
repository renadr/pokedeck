package upmc.pcg.game;

/**
 *
 * @author Raphaël Bretzner
 */

public class EnergyCard extends Card{


    @SuppressWarnings("unchecked")
    public EnergyCard(){
        this.map_card.put("card_type", this.type="ENERGY");
        this.energy_type=set_energy();
        report();
    }

    @Override
    public String toString(){
        String str;
        str=("ENERGY : "+this.energy_type);
        return str;
    }
    @Override
    public void set_argument(String argument) {
        switch (argument){
            case "energy" :
                this.energy_type=set_energy();
                break;
        }
    }


}
