package upmc.pcg;

/**
 * Created by Adrien on 01/11/2017.
 */
public class PokemonCard extends Card {

    private Energy energyType;
    private int hp;
    private int stage;
    private PokemonCard evolutionOf;

    public PokemonCard(String name, String description, Energy energyType, int hp, int stage, PokemonCard evolutionOf) {
        super(name, description);
        this.energyType = energyType;
        this.hp = hp;
        this.stage = stage;
        this.evolutionOf = evolutionOf;
    }
}
