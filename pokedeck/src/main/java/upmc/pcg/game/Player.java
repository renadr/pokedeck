package upmc.pcg.game;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Raphaël Bretzner
 */
public class Player {
    private String name;
    private String password;
    private Deck deck=new Deck();

    public Player(){
        this.name="Player 1";
    }
    public Player(String name){
        this.name=name;
    }

    public void add_card(String card_type){
        this.deck.create_card(card_type);
    }

    public Deck get_deck(){
        return this.deck;
    }

    public String toString(){
        return this.name;
    }

    public void set_password(String pwd) {
        this.password = pwd;
    }

    protected String get_password() {
        return password;
    }

    public String save_deck() {
        String msg;
        try {
            FileOutputStream fos= new FileOutputStream("src/main/java/upmc/pcg/game/tmp/deck_"+this.name+".ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(this.deck.get_cards());
            oos.close();
            fos.close();
            msg = "Save is done !";
        } catch (IOException e) {
            msg = "Error during saving your deck.";
        }
        return msg;
    }

    public String load_deck() {
        ArrayList<Card> load_deck= new ArrayList<Card>();
        String msg;
        try {
            FileInputStream fis = new FileInputStream("src/main/java/upmc/pcg/game/tmp/deck_"+this.name+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            load_deck = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            msg = "Success !";
        } catch(IOException ioe){
            ioe.printStackTrace();
            msg = "Error";
        } catch(ClassNotFoundException c){
            c.printStackTrace();
            msg = "Error during the load your previous deck";
        }
        this.deck.set_cards(load_deck);
        return msg;
    }
}

