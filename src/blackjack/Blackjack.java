package blackjack;

import deckOfCards.DeckSize;
import deckOfCards.PlayableDeck;
import helpers.InputHelper;
import player.Dealer;
import player.Gambler;
import player.Hand;
import player.Player;

/**
 * The Blackjack class brings together all the logic required to play the game
 * 
 * @author RossWeinstein
 */
public class Blackjack {

	private Gambler playerHand;
	private Dealer dealerHand;
	private PlayableDeck deckOfCards;
	private InputHelper input;

	/**
	 * Constructs a new Blackjack object consisting of a Gambler, a Dealer, and
	 * a Deck
	 */
	public Blackjack() {
		this.playerHand = new Gambler();
		this.dealerHand = new Dealer();
		this.deckOfCards = new PlayableDeck(DeckSize.SINGLEDECK);
		this.input = new InputHelper();
	}

	/*
	 * -------------------------------------------------------------------------
	 * --------------------------MAIN BLACKJACK MEHTODS-------------------------
	 * -------------------------------------------------------------------------
	 */

	/** Gives the dealer and player both two cards to start the game. */
	private void openingDeal() {

		for (int x = 0; x < 2; x++) {

			this.playerHand.hit(this.deckOfCards.getNextCard());
			this.dealerHand.hit(this.deckOfCards.getNextCard());
		}

		this.showOpeningDeal();
	}

	/**
	 * Prints the dealer's second card, the first is concealed, and player's
	 * hands to the console
	 */
	private void showOpeningDeal() {

		// formatting for console to aid in readability
		this.separator();
		System.out.println("OPENING DEAL:\n");

		// shows both the player's and dealer's cards and their total
		this.printOpeningHands();
	}

	/** Main game loop for Blackjack Class */
	public void playGame() {

		this.deckOfCards.shuffle();

		boolean gameOn = true;
		while (gameOn) {

			// Does the player have enough money to place a bet?
			if (this.hasPlaceBet()) {

				this.playBlackjack();
				gameOn = wantsToPlayMore();

			} else {

				System.out.println("\nYOU ARE OUT OF MONEY. YOU MUST RESET GAME IN 'SHOW STATS' MENU TO PLAY AGAIN.\n");
				gameOn = false;
			}
		}
	}

	/**
	 * Directs the order of the game starting with the opening deal and then
	 * into the Gambler's and Dealer's turn
	 */
	private void playBlackjack() {

		this.openingDeal();
		this.playTheGame();
	}

	/**
	 * Determines whether we have a blackjack before its the Gambler's turn to
	 * hit or stand
	 */
	private void playTheGame() {

		if (this.testForBlackjack(this.playerHand, this.dealerHand)) {
			this.showWhoWon();

		} else {
			this.deal();
		}
	}

	/**
	 * Governs who is able to currently hit or stand. Will either be the Gambler
	 * or the Dealer
	 */
	private void deal() {

		this.playerThenDealer();
		this.showWhoWon();
	}

	/*
	 * -------------------------------------------------------------------------
	 * -------------------------PLACE YOUR BETS METHODS-------------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Has the Gambler placed a valid bet
	 * 
	 * @return boolean returns true if Gambler has placed a valid bet between 1
	 *         and the total amount of money they possess. Returns false if the
	 *         Gambler is out of money and is unable to place any valid bet.
	 */
	private boolean hasPlaceBet() {

		// Makes sure the player has something to bet
		if (this.playerHand.hasMoney()) {

			this.placeYourBets();
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Prints to the console the Gambler's total money and asks for a bet amount
	 */
	private void placeYourBets() {
		this.printPlayerPurse();
		this.askForBet();
	}

	/** Prints to the console the current value of the Gambler's money */
	private void printPlayerPurse() {
		this.separator(); // formatting
		System.out.println("PLACE BET:");
		System.out.println("Money: " + this.playerHand.getTotalMoneyAmount());
	}

	/**
	 * Asks the Gambler to place a bet within their means. Will continue to
	 * prompt Gambler until a valid integer between 1 and their total money
	 * amount is given.
	 */
	private void askForBet() {

		boolean validBet = false;

		while (!validBet) {

			if (this.playerHand.placeBet(this.input.askForInteger("Bet: "))) {
				validBet = true;
			} else {
				System.out.println("Invalid Bet. You Must Enter An Integer Between 1 and "
						+ this.playerHand.getTotalMoneyAmount() + ".");
			}
		}
	}

	/*
	 * -------------------------------------------------------------------------
	 * ------------------BLACKJACK PLAYER/DEALER TURN MEHTODS-------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Allows the Gambler to take their turn first, and if they player has not
	 * bust, allows the dealer to then take their turn
	 */
	private void playerThenDealer() {

		this.turn(this.playerHand);

		if (!this.playerHand.hasPlayerBust()) {
			this.turn(this.dealerHand);
		}
	}

	/**
	 * Controls the Gambler's, or Dealer's, ability to hit as many times as they
	 * desire or stops them once they bust
	 * 
	 * @param thePlayer
	 *            takes the Player object whose turn it is
	 */
	private void turn(Player thePlayer) {

		boolean stillHitting = true;
		while (stillHitting) {

			if (!thePlayer.getHand().isHandOver21()) {

				stillHitting = this.doesPlayerWantToHit(thePlayer);

			} else {

				stillHitting = false;
				thePlayer.hasBust();
			}
		}
	}

	/**
	 * Adds a card to the Gambler or Dealer's hand if they decide to hit and
	 * prints their action to the console
	 * 
	 * @param thePlayer
	 *            takes the Player object whose turn it is
	 * @return boolean returns true if the Player has decided to take another
	 *         card from the deck; false otherwise
	 */
	private boolean doesPlayerWantToHit(Player thePlayer) {

		boolean anotherCard = true;

		if (this.playerWantsToHit(thePlayer)) {

			System.out.println("HITTING");

			thePlayer.hit(this.deckOfCards.getNextCard());

		} else {

			System.out.println("STANDING");
			anotherCard = false;
		}

		return anotherCard;
	}

	/**
	 * Governs whether we are dealing with a Gambler or Dealer and makes sure
	 * the correct action is taken. If we are passed a Dealer, a subtype of
	 * Player, this method will call the dealerTakeCard method which decides
	 * whether it is appropriate for the dealer to hit or stand. If a Gambler is
	 * passed, a subtype of Player, it will first check if they Gambler can
	 * double down before asking the user if they want to hit
	 * 
	 * @param thePlayer
	 *            takes the Player object whose turn it is
	 * @return boolean returns true if the Player decides to hit; false
	 *         otherwise
	 */
	private boolean playerWantsToHit(Player thePlayer) {

		// for console formatting
		this.turnSeparator(thePlayer);

		if (thePlayer instanceof Dealer) {

			// print hands
			this.printHands();

			// cast Player as Dealer to see if appropriate if Dealer hits
			Dealer theDealer = (Dealer) thePlayer;
			return theDealer.dealerHits();

		} else {

			// if it's the player's turn, we do not want to show both of the
			// dealer's cards
			this.printOpeningHands();
			return !this.playerHand.hasDoubleDowned() ? this.playersTurn((Gambler) thePlayer) : false;
		}
	}

	/**
	 * Controls the Gambler's turns in the game. If the Gambler can double down,
	 * it will call the correct methods and update the bet accordingly. If they
	 * cannot double down, it will just ask if they want to hit.
	 * 
	 * @param gambler
	 *            takes a Gambler object
	 * @return boolean returns true if the can double down and they want to
	 *         double down, or if just want to hit; false otherwise
	 */
	private boolean playersTurn(Gambler gambler) {

		if (gambler.getHand().canDoubleDown()) {

			return this.askForDoubleDown(gambler);

		} else {
			return this.input.askBinaryQuestion("HIT or STAND (h/s)", "h", "s");
		}
	}

	/**
	 * Asks if they player wants to double down or not. If they do double down,
	 * they can only receive one more card, if they do not double down, they
	 * will be able to continue playing as normal
	 * 
	 * @param gambler
	 *            takes a Gambler object
	 * @return boolean returns true if the Gambler wants to double down; false
	 *         otherwise
	 */
	private boolean askForDoubleDown(Gambler gambler) {

		if (this.input.askBinaryQuestion("DOUBLE DOWN (y/n)", "y", "n")) {

			// checks if player has enough money to double down
			if (!gambler.doubleDowns()) {
				System.out.println("PLAYER DOES NOT HAVE ENOUGH FUNDS TO DOUBLE DOWN.");
			} else {
				this.playerHand.playedDoubleDownHand();
			}
		}
		return true;
	}

	/*
	 * -------------------------------------------------------------------------
	 * ------------------END OF GAME: WON, LOST, PUSH METHODS-------------------
	 * -------------------------------------------------------------------------
	 */

	/** Prints to the console who won the game */
	private void showWhoWon() {

		this.separator();
		this.printHands();

		if (this.playerHand.getHandTotal() == this.dealerHand.getHandTotal()) {

			this.handPushed();

		} else if (this.wonHand(playerHand, dealerHand)) {

			this.handWon();

		} else {

			this.handLost();
		}
	}

	/**
	 * Determines whether the gambler beat the dealer
	 * 
	 * @param gambler
	 *            Takes a gambler object
	 * @param dealer
	 *            takes a Dealer object
	 * @return boolean returns true if the Gambler won the hand or false if the
	 *         Dealer won the hand
	 */
	private boolean wonHand(Gambler gambler, Dealer dealer) {

		return gambler.getHand().getHandTotal() > dealer.getHand().getHandTotal()
				&& gambler.getHand().getHandTotal() <= 21
				|| gambler.getHand().getHandTotal() <= 21 && dealer.getHand().getHandTotal() > 21;
	}

	/** Handles the outcomes if a player loses the hand */
	private void handLost() {

		System.out.println("---YOU LOST!---");
		this.playerHand.lostBet();
	}

	/** Handles the outcomes if a player wins the hand */
	private void handWon() {

		System.out.println("---YOU WON!---");
		this.playerHand.wonBet();
	}

	/** Handles the outcomes if a player pushes the hand */
	private void handPushed() {

		System.out.println("---PUSH!---");
		this.playerHand.pushedHand();
	}

	/**
	 * Determines whether the opening deal has resulted in a blackjack for the
	 * player, the dealer, or both resulting in a push
	 * 
	 * @param gambler
	 *            takes a Gambler object
	 * @param dealer
	 *            takes a Dealer object
	 * @return boolean returns true if either Player has a blackjack; false
	 *         otherwise
	 */
	private boolean testForBlackjack(Gambler gambler, Dealer dealer) {

		return this.blackjackWin(gambler.getHand()) || this.blackjackWin(dealer.getHand());
	}

	/**
	 * Determine whether there is blackjack
	 * 
	 * @param handToCheck
	 *            takes a Player's Hand object
	 * @return boolean returns true if the Hand is a blackjack, consisting of 2
	 *         cards and has a total of 21; false otherwise
	 */
	private boolean blackjackWin(Hand handToCheck) {
		return handToCheck.getCardsDealt().size() == 2 && handToCheck.getHandTotal() == 21;
	}

	/*
	 * -------------------------------------------------------------------------
	 * ---------------------END OF GAME: PLAY AGAIN MEHTODS---------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Determines if the player wants to play more blackjack
	 * 
	 * @return boolean returns true if the Player wants to play another hand of
	 *         blackjack; false otherwise
	 */
	private boolean wantsToPlayMore() {

		boolean morePlease = false;

		if (this.input.askBinaryQuestion("Play Again? (y/n)", "y", "n")) {

			morePlease = true;
			this.getReadyForNextHand();
		}

		return morePlease;
	}

	/*
	 * -------------------------------------------------------------------------
	 * -------------END OF GAME: GET READY FOR NEXT HAND MEHTODS----------------
	 * -------------------------------------------------------------------------
	 */

	/** Resets the game and prepares for the next hand */
	private void getReadyForNextHand() {
		this.clearHands();
		this.checkIfTimeToShuffle();
	}

	/** Clears both Gambler's and Dealer's hand */
	private void clearHands() {
		this.playerHand.clearHand();
		this.dealerHand.clearHand();
	}

	/** Checks whether it is time to shuffle the cards or not */
	private void checkIfTimeToShuffle() {
		if (this.deckOfCards.getCardPosition() > 35) {
			this.deckOfCards.shuffle();
		}
	}

	/*
	 * -------------------------------------------------------------------------
	 * -------------------------------STATS METHODS-----------------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Prints the Gambler's statistics for the most recent session of blackjack
	 * to the console
	 */
	public void showStats() {
		System.out.println("Money:\t\t" + this.playerHand.getTotalMoneyAmount() + "\n" + this.playerHand.getStats());
	}

	/**
	 * Clears all the Gambler's game play statistics and sets their bank roll to
	 * $100
	 */
	public void resetGame() {
		this.playerHand = new Gambler();
		this.dealerHand = new Dealer();
		this.deckOfCards = new PlayableDeck(DeckSize.SINGLEDECK);
	}

	/*
	 * -------------------------------------------------------------------------
	 * ----------------------------FORMATTING METHODS---------------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Divides up the console to better separate whose turn it is
	 * 
	 * @param thePlayer
	 *            takes a Player object
	 */
	private void turnSeparator(Player thePlayer) {

		this.separator();

		// prints the appropriate title depending on who we are dealing with
		if (thePlayer instanceof Dealer) {
			System.out.println("DEALER'S TURN:\n");
		} else {
			System.out.println("PLAYER'S TURN:\n");
		}
	}

	/** Prints to lines of '*' to the console */
	private void separator() {
		System.out.println("************************************************");
		System.out.println("************************************************");
	}

	/** Prints both the dealer's and the player's hand to the console */
	private void printHands() {
		this.dealerHand.printHandInfo();
		this.playerHand.printHandInfo();
	}

	/** Prints the dealer's second card and the player's hand to the console */
	private void printOpeningHands() {
		System.out.println(this.dealerHand.openingHand() + "\n");
		this.playerHand.printHandInfo();
	}

}
