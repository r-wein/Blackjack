package deckOfCards;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

	/**
	 * Creates the correct number of decks based on input value.
	 * 
	 * @param numOfDecks DeckSize enum, how many decks do we want to create.
	 * @return List The newly created deck
	 */
	public static List<Dealable> buildDeck(DeckSize numOfDecks) {
		List<Dealable> deck = new ArrayList<>();
		for (int i = 0; i < numOfDecks.ordinal() + 1; i++) {
			deck.addAll(generatedDeck());
		}
		return deck;
	}

	// Where we actually create the deck, use CardFactory
	private static List<Dealable> generatedDeck() {
		List<Dealable> cards = new ArrayList<>();
		for (CardSuit theSuits : CardSuit.values()) {
			for (CardRank theRanks : CardRank.values()) {
				cards.add(CardFactory.makeCard(theSuits, theRanks));
			}
		}
		return cards;
	}
}
