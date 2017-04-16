package deckOfCards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayableDeckTest {
	
	PlayableDeck deck;
	
	@Before
	public void setUp() {
		this.deck = new PlayableDeck(DeckSize.SINGLEDECK);
	}
	
	@Test
	public void madeCorrectDeck() {
		assertEquals("FAIL - did not make single deck", 52, this.deck.getDeck().size());
	}
	
	@Test
	public void correctCardPosition() {
		assertEquals("FAIL - did not start at 0", 0, this.deck.getCardPosition());
	}
	
	@Test
	public void incrementDeckPosition() {
		this.deck.getNextCard();
		assertEquals("FAIL - did not get the next card", 1, this.deck.getCardPosition());
	}
	
	@Test
	public void didShuffleDeck() {
		List<Dealable> unshuffledDeck = this.deck.getDeck();
		this.deck.shuffle();
		
		assertTrue("FAIL - deck did not shuffle", this.deckDidShuffle(unshuffledDeck, this.deck.getDeck()));
	}
	
	private boolean deckDidShuffle(List<Dealable> unshuffledList, List<Dealable> shuffledList) {
		
		// first make sure they're the same size
		if (unshuffledList.size() != shuffledList.size()) {
			return false;
		}
		
		// for keeping track of cards in the same position
		int counter = 0;
		
		for (int i = 0; i < unshuffledList.size(); i++) {
			
			// get out of the loop if we have any cards that are different
			if (!unshuffledList.get(i).equals(shuffledList.get(i))) {
				return true;
			} else {
				counter++;
			}
		}
		// see if any cards have changed position
		return counter == 52;
	}

}
