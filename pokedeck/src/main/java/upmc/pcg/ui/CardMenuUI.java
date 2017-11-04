package upmc.pcg.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import upmc.pcg.game.Attack;
import upmc.pcg.game.Card;
import upmc.pcg.game.Deck;

public class CardMenuUI {
    private static Deck collection = null;
    private static final Scanner console = new Scanner(System.in);

    //Private constructor
    private CardMenuUI() {}

    /**
     * Set the collection in this class
     */
    public static void setActualCollection(Deck newCollection) {
        collection = newCollection;
    }

    /**
     * Return the card selected by the user in a menu
     */
    public static Card cardConsultMenu(Deck collectionGiven, boolean onlyPokemonCard) {
        int chosenIndex = 1;
        boolean boolIndexOk = false;

        while(!boolIndexOk || collectionGiven.get_size()>1) {
            try {
                System.out.println("Select a card : ");
                chosenIndex = console.nextInt()-1;
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a card number !\n");
                GameUI.clearConsoleBuffer(console);
            }

            if(chosenIndex>=0 && chosenIndex < collection.get_size()) {
                if(!onlyPokemonCard)
                    boolIndexOk = true;
                else {
                    boolIndexOk = checkIfPokemonCard(collectionGiven, chosenIndex);
                    if(!boolIndexOk)
                        System.out.print("(!) Select a pokemon card !\n");
                }
            }
            else
                System.out.println("(!) This card isn't in the collection");
        }

        if(collectionGiven.get_size()<1)
            return null;
        else
            return collectionGiven.get_card(chosenIndex);
    }

    /**
     * Check if the card at the index is a pokemon card
     */
    private static boolean checkIfPokemonCard(Deck collectionGiven, int chosenIndex) {
        boolean isPokemonCard = false;

        if(collectionGiven.get_card(chosenIndex).get_cardType().equals("pokemon"));
        isPokemonCard = true;

        return isPokemonCard;
    }

    /**
     * Ask the value for each attributes of the pokemon card
     */
    public static HashMap<String, Object> ask_pokemonCard_attributes() {
        HashMap<String, Object> valuesForAttributes = new HashMap<>();

        GameUI.clearConsoleBuffer(console);

        valuesForAttributes.put("name", cardAskName());
        valuesForAttributes.put("specialType", cardAskEnergyType());
        valuesForAttributes.put("hp", cardAskHp());
        valuesForAttributes.put("stage", cardAskStage());
        if(!valuesForAttributes.get("stage").equals(0))
            valuesForAttributes.put("evolvesFrom", cardAskEvolvesFrom());
        else
            valuesForAttributes.put("evolvesFrom", null);
        valuesForAttributes.put("attacks", cardAskAttacks());
        valuesForAttributes.put("weaknessType", cardAskWeaknessType());
        valuesForAttributes.put("resistanceType", cardAskResistanceType());
        valuesForAttributes.put("cardNb", cardAskCardNb((String)valuesForAttributes.get("name")));

        return valuesForAttributes;
    }

    /**
     * Explicit
     */
    private static String cardAskName() {
        String result = "Default";

        do {
            System.out.println(" * Name : ");
            result = console.nextLine();
        }while(result.equals(""));

        return result;
    }

    /**
     * Explicit
     */
    private static String cardAskEnergyType() {
        String result = "Default";

        System.out.println(" * Energy type : ");
        MenuUI.printEnergies();
        result = EnergyCard.CARD_TYPES[MenuUI.askEnergy()];

        return result;
    }

    /**
     * Explicit
     */
    private static int cardAskHp() {
        int result = 0;

        do {
            try {
                System.out.println(" * Health Point (hp) : ");
                result = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a number !\n");
                GameUI.clearConsoleBuffer(console);
            }
        } while(result<=0);

        return result;
    }

    /**
     * Explicit
     */
    private static int cardAskStage() {
        int result = 0;

        do {
            try {
                System.out.println(" * Evolution stage (0 for basic Pokemon) : ");
                result = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a number !\n");
                GameUI.clearConsoleBuffer(console);
            }
        } while(result<0);

        return result;
    }

    /**
     * Explicit, collection need to be set
     */
    private static Card cardAskEvolvesFrom() {
        Card result = null;

        collection.list_all_cards();
        if(collection.get_size() < 1)
            result = cardConsultMenu(collection, true);

        return result;
    }

    /**
     * Ask to create attacks for the pokemon
     */
    private static ArrayList<Attack> cardAskAttacks() {
        ArrayList<Attack> result = new ArrayList<>();
        Attack newAttack = null;
        String otherAttack = "n";

        System.out.println(" * Attacks :");

        do {
            newAttack = new Attack(false); //create an attack without autofill
            result.add(newAttack);

            do {
                GameUI.clearConsoleBuffer(console);
                System.out.println("Do you want to add another attack? (y/n) ");
                otherAttack = console.nextLine();
            }while(!otherAttack.equals("n") && !otherAttack.equals("y"));

        }while(otherAttack.equals("y"));

        return result;
    }

    /**
     * Explicit
     */
    private static String cardAskWeaknessType() {
        String result = "Default";

        System.out.println(" * Weakness type : ");
        MenuUI.printEnergies();
        result = EnergyCard.ENERGY_TYPES[MenuUI.askEnergy()];

        return result;
    }

    /**
     * Explicit
     */
    private static String cardAskResistanceType() {
        String result = "Default";

        System.out.println(" * Resistance type : ");
        MenuUI.printEnergies();
        result = EnergyCard.ENERGY_TYPES[MenuUI.askEnergy()];

        return result;
    }

    /**
     * Explicit, verify if the cardNb is available in the collection
     */
    private static int cardAskCardNb(String actualCardName) {
        int result = -1;

        do {
            try {
                System.out.println(" * collector card number : ");
                result = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a positive number !\n");
                GameUI.clearConsoleBuffer(console);
            }
        } while(result<=0 && !collection.nbCardAvailable(actualCardName, result));

        return result;
    }
}
