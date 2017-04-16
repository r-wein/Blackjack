package blackjack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import helpers.InputHelper;
import helpers.MenuBuilder;

/**
 * This class brings everything together. It combines the Blackjack class with
 * MenuBuilder. Here, the user is able to decide whether they want to play, look
 * at their stats, see how to play blackjack, or exit the game. The stats screen
 * also allows the player to reset their stats for whatever reason.
 * 
 * @author RossWeinstein
 */

public class BlackjackGame {

	private Blackjack blackjack;
	private MenuBuilder gameMenu;
	private InputHelper input;

	/**
	 * Constructs a new BlackjackGame with a menu that includes the word Blackjack in a banner with the options of 'play
	 * game', 'show stats', 'game rules', and 'exit'
	 */
	public BlackjackGame() {
		this.blackjack = new Blackjack();
		this.gameMenu = new MenuBuilder("Blackjack", "Play Game", "Show Stats", "Game Rules", "Exit");
		this.input = new InputHelper();
	}

	/** The main game loop for the blackjack application */
	public void playBlackjack() {

		boolean wantsToPlay = true;

		while (wantsToPlay) {

			wantsToPlay = this.gameMenu();
		}
	}

	/**
	 * Prints the game menu to the console and gets the users selection
	 * 
	 * @return boolean returns true if user selects play game, show stats, or
	 *         game rules; false if they select exit
	 */
	private boolean gameMenu() {

		System.out.println(gameMenu.displayMenuWithBanner());
		return this.gameChoices(this.input.askForSelection(this.gameMenu.getMenuItems()));
	}

	/**
	 * Governs where the player goes after they have made their selection
	 * 
	 * @param choice
	 *            takes as an int, the option that the use chose from the menu
	 * @return boolean returns true if user selects play game, show stats, or
	 *         game rules; false if they select exit
	 */
	private boolean gameChoices(int choice) {

		System.out.println();
		boolean playGame = true;

		if (choice == 1) {
			this.blackjack.playGame();

		} else if (choice == 2) {
			this.gameStatsMenu();

		} else if (choice == 3) {
			this.printBasicsOfBlackjack();

		} else {
			playGame = false;
		}

		System.out.println();
		return playGame;
	}

	/** Calls the different pieces required for the game stats menu selection */
	private void gameStatsMenu() {
		showCurrentStats();
		asksToResetStats();
	}

	/** Prints to the console the current stats of the player */
	private void showCurrentStats() {
		System.out.println("GAME STATISTICS:\n");
		this.blackjack.showStats();
		System.out.println();
	}

	/** Gathers if the player is interested in resetting their stats */
	private void asksToResetStats() {

		if (this.input.askBinaryQuestion("Reset Stats (y/n)", "y", "n")) {

			this.blackjack.resetGame();
			// formatting
			System.out.println();
			// shows the stats being restored to default
			this.blackjack.showStats();
		}
	}

	/**
	 * Prints the basic of blackjack to the console
	 * 
	 * @throws IOException
	 */
	private void printBasicsOfBlackjack() {

		try (Stream<String> readLines = Files.lines(Paths.get("src/Blackjack_Rules.txt"))){

			readLines.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error. Could Not Find File");
		}
	}
}
