package upmc.pcg;

import upmc.pcg.game.Card;
import upmc.pcg.game.Energy;

/**
 * Created by Adrien on 01/11/2017.
 */
public class EnergyCard extends Card {

    private Energy energyType;

    public EnergyCard(String name, String description,Energy energyType) {
        super(name, description,"energy");
        this.energyType = energyType;
    }

}
