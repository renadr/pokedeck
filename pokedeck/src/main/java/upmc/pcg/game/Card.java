package upmc.pcg.game;

/**
 * Created by Adrien on 01/11/2017.
 */
public abstract class Card {

    protected String name;
    protected String cardType;
    protected String description;

    public Card(String name,String description,String cardType) {
        this.name = name;
        this.description = description;
        this.cardType = cardType;
    }

    public String getName() {
        return this.name;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getDescription() {
        return description;
    }

}