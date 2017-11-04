package upmc.pcg.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import upmc.pcg.EnergyCard;
import upmc.pcg.game.*;

public final class MenuUI {
    private static final Scanner console = new Scanner(System.in);

    //Private constructor
    private MenuUI() {}

    /**
     * Display the main choice menu that ask what the player want to do with his collection
     */
    public static int collectionMainMenu(String playerName) {
        int choiceMenu = -1;

        printCollectionMenuMsg(playerName);
        choiceMenu = askCollectionMenu();

        return choiceMenu;
    }

    /**
     * Print messages at the beginning of the collection main menu
     */
    private static void printCollectionMenuMsg(String playerName) {
        System.out.println("****************************");
        System.out.println("* "+playerName+"'s Collection");
        System.out.println("****************************");
        System.out.println("What do you want to do with your collection ?");
        System.out.println(" 1. Add a card");
        System.out.println(" 2. Consult");
        System.out.println(" 3. Search cards by criteria");
        System.out.println(" 4. Quit the game");
    }

    /**
     * Ask the player what choice he want to do in the collection main menu
     */
    private static int askCollectionMenu() {
        int choice = 0;

        do {
            try {
                System.out.println("\nYour choice ?");
                choice = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a number !\n");
                GameUI.clearConsoleBuffer(console);
            }
        }while(!(choice>=1 && choice <=4));

        return choice;
    }

    /**
     * Display the creation card menu
     * return the created card
     */
    public static Card addCardMenu() {
        Card createdCard = null;

        //ask what type of card
        createdCard = askTypeCard();
        //run create() method from card
        createdCard.create();

        return createdCard;
    }

    /**
     * Ask the type of the card and return a card of this type (pokemon, trainer, energy)
     */
    private static Card askTypeCard() {
        String chosenType = "";
        Card card = null;

        chosenType = printTypeCardMsg();
        card = switchCardType(chosenType);

        return card;
    }

    /**
     * Print the message at the beginning of the menu to add a card
     * return the chosen type by the player
     */
    private static String printTypeCardMsg() {
        String choice = "";

        System.out.println("****************************");
        System.out.println("Card creation :");
        choice = printOptionTypeCard();

        if(choice == null)
            choice = printTypeCardMsg();

        return choice;
    }

    /**
     * Print the 3 types of card for the creation card menu
     * return the choice of the player
     */
    private static String printOptionTypeCard() {
        String tabTypes[] = Card.CARD_TYPES;
        int choice = 0;

        System.out.println("What type of card do you want ? ");
        for(int i=0; i<tabTypes.length; i++) {
            System.out.println(" "+(i+1)+". "+tabTypes[i]);
        }

        while(choice == 0 && !(choice >= 1 && choice <= tabTypes.length)) {
            try {
                System.out.println("\nYour choice ? ");
                choice = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a number !\n");
                GameUI.clearConsoleBuffer(console);
            }
        }

        return tabTypes[choice-1];
    }

    /**
     * Create a card following the given type
     */
    private static Card switchCardType(String chosenType) {
        Card card = null;

        switch(chosenType) {
            case "pokemon":
                card = new PokemonCard();
                break;
            case "trainer":
                card = new TrainerCard();
                break;
            case "energy":
                card = new EnergyCard();
                break;
            default:
                System.out.println("(!) Unknown card type");
                break;
        }

        return card;
    }

    /**
     * Do all the actions when the user want to consult the collection
     * in the main menu
     */
    public static void actionConsultMenu(Deck currentCollection) {
        Card currentCard = null;

        currentCard = collectionConsultMenu(currentCollection);

        if(currentCard != null)
            System.out.println("card : "+currentCard.toString());
        else
            System.out.println("(!) Pas de carte à afficher");
    }

    /**
     * Display the content of the collection and ask the user which card he wants to consult
     * return the chosen card
     */
    public static Card collectionConsultMenu(Deck collection) {
        Card chosenCard = null;
        String userConsultCard = "";

        System.out.println("****************************");
        System.out.println("Collection content :\n");
        collection.list_all_cards();

        GameUI.clearConsoleBuffer(console);
        while(userConsultCard.equals("") || (!userConsultCard.equals("n") && !userConsultCard.equals("y"))) {
            System.out.println("Do you want to consult a card ? (y/n)");
            userConsultCard = console.nextLine();
        }

        if(userConsultCard.equals("y")) {
            if(collection.get_size() != 0)
                chosenCard = CardMenuUI.cardConsultMenu(collection, false);
            else
                System.out.println("(!) You don't have cards in your collection yet");
        }

        return chosenCard;
    }

    /**
     * Display the messages at the beginning of the creation of a card step by step
     */
    public static void printCreateCardMsg(String cardType) {
        System.out.println("****************************");
        System.out.println("Create your "+cardType+" card :\n");
        System.out.println("Prof. Oak : Here you can create your card step by step ! Let's Go !\n");
    }

    /**
     * Ask the user to fill every attributes of an attack
     */
    public static HashMap<String, Object> attackAskAll() {
        HashMap<String, Object> valuesForAttributes = new HashMap<>();

        System.out.println("****************************");
        System.out.println("Attack creation : \n");
        valuesForAttributes.put("name", askName());
        valuesForAttributes.put("neededEnergy", askNeededEnergy());
        valuesForAttributes.put("damage", ask_dmg());
        valuesForAttributes.put("description", ask_description());
        System.out.println("****************************");

        return valuesForAttributes;
    }

    /**
     * Explicit
     */
    private static String askName() {
        String result = "";

        GameUI.clearConsoleBuffer(console);

        while(result.equals("")) {
            System.out.println(" * Name : ");
            result = console.nextLine();
        }

        return result;
    }

    /**
     * Explicit
     */
    private static ArrayList<String> askNeededEnergy() {
        ArrayList<String> result = new ArrayList<>();
        String otherEnergy = "n";
        int chosenEnergyIndex = 0;

        System.out.println(" * Needed energy : ");

        printEnergies();
        do {
            chosenEnergyIndex = askEnergy();
            result.add(Energy.valueOf(chosenEnergyIndex));

            do {
                GameUI.clearConsoleBuffer(console);
                System.out.println("Do you want to add another energy ? (y/n) ");
                otherEnergy = console.nextLine();
            }while(!otherEnergy.equals("n") && !otherEnergy.equals("y"));

        }while(otherEnergy.equals("y"));

        return result;
    }

    /**
     * Print all energies in the form of a list
     */
    public static void printEnergies() {
        final int MAX_ENERGY = Energy.values().length;

        for(int i=1; i<=MAX_ENERGY; i++) {
            /**
             * FIX IT : je veux récupérer une valeur uniquement à chaque fois
             */
            System.out.println(" "+i+". "+Energy.CARD_TYPES[i-1]);
        }
        System.out.println("");
    }

    /**
     * Ask the user what type of energy he want to pick, return the index of the chosen energy
     */
    public static int askEnergy() {
        int result = 0;

        do {
            try {
                System.out.println("What type of energy do you want to pick ? ");
                result = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Select a number in the list\n");
                GameUI.clearConsoleBuffer(console);
            }
            if(result> Energy.values().length) {
                System.out.print("(!) This number is too high\n");
            }
        } while(result<=0 || result>Energy.values().length);

        return result-1;
    }

    /**
     * Ask the user how many damage an attack is going to do
     */
    public static int ask_dmg() {
        int result = 0;

        do {
            try {
                System.out.println(" * Damage : ");
                result = console.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("(!) Chose a positive number\n");
            }
        } while(result<=0);

        return result;
    }

    /**
     * Ask the user to fill a description field
     */
    public static String ask_description() {
        String result = "";

        GameUI.clearConsoleBuffer(console);

        do {
            System.out.println(" * Description : ");
            result = console.nextLine();
        }while(result.equals(""));

        return result;
    }
}
