package upmc.pcg.game;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by Adrien on 01/11/2017.
 */
public class Deck {
    protected ArrayList<Card> cards=new ArrayList<Card>();


    public void create_card(String card_type){
        Card c=null;
        switch(card_type){
            case "ENERGY":
                c = new EnergyCard();
                break;
            case "POKEMON":
                c =new PokemonCard();
                break;
            case "TRAINER":
                c = new Trainer();
                break;
        }
        cards.add(c);
    }
    public ArrayList<Card> get_cards(){
        return this.cards;
    }

    @Override
    public String toString() {
        StringBuffer sb =  new StringBuffer() ;
        return sb.append(this.cards).toString() ;
    }
}
