package upmc.pcg.game;

import java.util.ArrayList;

/**
 * Created by Adrien on 01/11/2017.
 */
public class PokemonCard extends Card {

    private Energy energyType;
    private int hp;
    private int stage;
    private PokemonCard evolutionOf;
    private ArrayList<EnergyCard> energiescardsList;
    private ArrayList<Attack> attacksList;

    public PokemonCard(String name, String description, Energy energyType, int hp, int stage, PokemonCard evolutionOf, ArrayList<Attack> attacksList) {
        super(name, description);
        this.energyType = energyType;
        this.hp = hp;
        this.stage = stage;
        this.evolutionOf = evolutionOf;
        this.attacksList = attacksList;
        this.energiescardsList = new ArrayList<>();
    }
}
