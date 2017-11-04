package upmc.pcg.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Adrien on 01/11/2017.
 */
public class Deck {

    private String owner;
    private ArrayList<Card> cards;

    public Deck(String name) {
        this.owner = name;
        this.cards = new ArrayList<Card>();
    }

    public void listAllCards(){
        System.out.println("Your deck : ");
        for(Card c : this.cards) {
            System.out.println(c.getName());
        }
    }

    public void addCard(Card newCard){
        cards.add(newCard);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int getSize() {
        return cards.size();
    }

}
