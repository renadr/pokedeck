package upmc.pcg.game;

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
}

