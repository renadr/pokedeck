package upmc.pcg.game;

/**
 * Created by Adrien on 01/11/2017.
 */
public abstract class Card {

    protected String name = "Default";
    protected String cardType;
    protected String specialType; //Pokemon type, Trainer type or Energy type
    protected int cardNb;
    public static String CARD_TYPES[] = {"pokemon", "trainer", "energy"};

    /**
     * Return the name of the card in the form of a string
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the cardType in the form of a string
     */
    public String getCardType() {
        return this.cardType;
    }

    /**
     * Return the cardNb
     */
    public int getCardNb() {
        return this.cardNb;
    }

    /**
     * Create a card (pokemon, trainer or energy) with every attributes
     */
    public abstract void create();
}
