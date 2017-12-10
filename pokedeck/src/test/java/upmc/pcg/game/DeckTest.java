package upmc.pcg.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 09/12/2017.
 */
public class DeckTest extends TestCase {

    private Deck theDeck;
    private ArrayList<Card> cards;

    public DeckTest() {
        this.theDeck = new Deck();
        this.cards = new ArrayList(Arrays.asList(new Card(),new Card(),new Card()));
        this.theDeck.set_cards(this.cards);
    }

    @Test
    public void test_get_cards() throws Exception {
        assertEquals(this.theDeck.get_cards(),this.cards);
    }

}