package upmc.pcg.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Adrien on 01/11/2017.
 */
public class Deck {

    private String owner;
    private List<Card> cards = new ArrayList<Card>();

    /**
     * Constructor that create a collection for the player with his name
     */
    public Deck(String name) {
        this.owner = name;
    }

    /**
     * Display all cards in the collection in the form of a list
     */
    public void listAllCards(){
        Iterator<Card> cardIterator = cards.iterator();

        if(this.getSize() < 1)
            System.out.println("(!) The collection is empty for the moment");

        for(int cardIndex = 0; cardIterator.hasNext(); cardIndex++) {
            Card card = cardIterator.next();
            System.out.println((cardIndex+1)+". "+card.getName());
        }
    }

    /**
     * Add a card in the collection
     */
    public void addCard(Card newCard){
        cards.add(newCard);
    }

    /**
     * Return the card saved at index position in the list
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * Return the size of the collection
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * Verify if a cardNb already exists in the collection
     * if it doesn't exist : return true
     * if it already exist but it have the same cardName : return true
     * if it already exist and don't have the same cardName : return false
     */
    public boolean nbCardAvailable(String cardName, int cardNb) {
        boolean boolVerify = true;
        Card currentCard = null;
        Iterator<Card> cardsIterator = this.cards.iterator();

        while(cardsIterator.hasNext() && boolVerify!=false) {
            currentCard = cardsIterator.next();

            if(currentCard.getCardNb()==cardNb)
                if(currentCard.getName()!=cardName)
                    boolVerify = false;
        }

        return boolVerify;
    }
}
