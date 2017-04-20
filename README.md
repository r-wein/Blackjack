# BLACKJACK
Command Line Blackjack Game

## Sample Output
![Blackjack Demo](Blackjack.gif)

## Sample Code
```java
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
```
## About this Project
### Origin
In one of my classes I was given the option to either refactor a piece of exsiting code or write a program from scratch.  I chose the latter and thought it would be fun to write a Blackjack game.

### Installation
Currently, the only way to get this code is to clone this repository.
```
$ git clone https://github.com/rossweinstein/Blackjack
```
### How The Game Words
If you are unfamiliar with blackjack, read [this](https://en.wikipedia.org/wiki/Blackjack) first.
  
For my game, the player starts out with a balance of $100.  They can bet before each hand and double down if their initial deal is 11 (and they have enough money to place that bet).  As they play, their stats will be recorded (games, wins, losses, etc.).  If they lose all their money, they will be prompted to reset their stats and their balance returns to $100.

### Testing
I used JUnit to test all my code in this project.  Those tests can be seen [here](https://github.com/rossweinstein/Blackjack/tree/master/test).

### Future Improvements
1. Give the player the opportunity to select how many decks they want to play with.  Currrently, they can only play with a single deck.
1. Give the player the opportunity to split their hand.  At the moment they can only double down.
1. Give the player the opportunity for insurance if the dealer's initial hand shows an ace.

## Resources
I used no outside resources for this project.

## License
[MIT License](https://en.wikipedia.org/wiki/MIT_License)
