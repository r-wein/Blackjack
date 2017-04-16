package gameMain;

import blackjack.BlackjackGame;

/**
 * PROJECT: Blackjack
 * 
 * CLASS: SEIS 602.01 (THURSDAY) - Intermediate Software Development
 * 
 * PRESENTATION / DUE DATE: 12.15.2017
 * 
 * @author Ross Weinstein
 *
 *         For my project I chose Option A to 'Code, Test, Evaluate and Refactor
 *         an Original Java Application'. For this I wrote my own blackjack
 *         program with one player against the dealer. My game has a single
 *         deck, and the player is able to place bets before each hand and
 *         double down where appropriate. I have included the ability for the
 *         player to see their game statistics (such as games played, games won, etc.).
 */

public class BlackjackMain {

	public static void main(String[] args) {

		// runs the blackjack application
		BlackjackGame theGame = new BlackjackGame();
		theGame.playBlackjack();
	}
}
