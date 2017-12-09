package upmc.pcg.game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    public void save_deck() {
        try {
            FileOutputStream fos= new FileOutputStream("src/main/java/upmc/pcg/game/tmp/deck_"+this.name+".ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(this.deck.get_cards());
            oos.close();
            fos.close();
            System.out.println("Save is done !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_deck() {
        
    }
}

