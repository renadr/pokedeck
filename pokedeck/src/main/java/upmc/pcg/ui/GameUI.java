// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg.ui;

import java.util.*;
import upmc.pcg.game.Game;

public class GameUI {
  private final Game game = new Game();
  private final Scanner console = new Scanner(System.in);

  public void start() {
    print_welcome_msg();
    ArrayList<String> names = ask_players_names();
    game.initialize(names);
    game.play();
  }

  private ArrayList<String> ask_players_names() {
    ArrayList<String> names = new ArrayList<String>();
    boolean boolAskName = true;

    System.out.println("****************************");
    System.out.println("Prof. Oak : This is the first time i see you here !");

    while(boolAskName) {
      names.add(ask_name());
      boolAskName = menu_other_name();
    }

    System.out.println("Prof. Oak : Ok, so let's see your collection now !");
    return names;
  }

  private String ask_name() {
    String playerName = "";

    while(playerName.equals("")) {
      System.out.println("Prof. Oak : What's your name ? ");
      playerName = console.nextLine();
    }
    System.out.println("Prof. Oak : "+playerName+", what a beautiful name ! ");

    return playerName;
  }

  /**
   * Display a menu that ask if it needs another name
   */
  private boolean menu_other_name() {
    boolean boolOtherName = false;
    String response = "";

    while(response.equals("") || (!response.equals("y") && !response.equals("n"))) {
      System.out.println("Prof. Oak : Do you have another friend with you ? (y/n)");
      response = console.nextLine();
    }

    if(response.equals("y"))
      boolOtherName = true;

    return boolOtherName;
  }

  private void print_welcome_msg() {
    System.out.println("****************************");
    System.out.println("* POKEDECK *");
    System.out.println("****************************");
    System.out.println("Welcome in the pokedeck !\nHere you can create your own cards,");
    System.out.println("save, modify and manage your collection !\n");
  }

  public static void clear_console_buffer(Scanner parConsole) {
    if(parConsole.hasNextLine())
      parConsole.nextLine();
  }
}
