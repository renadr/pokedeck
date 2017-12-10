package upmc.pcg.game;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 10/12/2017.
 */
public class PlayerTest {

    private Player p1;

    public PlayerTest() {
        this.p1 = new Player("Adrien");
    }

    @Test
    public void test_get_deck() throws Exception {
//        String input = "1";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        this.p1.add_card("ENERGY");
//        System.setIn(System.in);
//        assertEquals(this.p1.get_deck(),this.p1.get_deck());
//        this.p1.add_card("POKEMON");
//        this.p1.add_card("TRAINER");
//        this.p1.add_card("DIGIMON");

    }

    @Test
    public void test_get_password() throws Exception {
        String pwd = "hello";
        this.p1.set_password(pwd);
        assertEquals(this.p1.get_password(),pwd);
    }

    @Test
    public void test_save_deck() throws Exception {
        assertEquals(this.p1.save_deck(),"Save is done !");
    }

    @Test
    public void test_load_deck() throws Exception {
        assertEquals(this.p1.load_deck(),"Success !");
    }

}