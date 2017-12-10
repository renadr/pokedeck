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

    Deck theDeck;

    public DeckTest() {
        theDeck = new Deck();
        this.theDeck.set_cards(new ArrayList(Arrays.asList(new Card(),new Card(),new Card())));
    }

    @Test
    public void test_get_cards() throws Exception {

    }

}