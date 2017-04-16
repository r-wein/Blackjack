package deckOfCards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumberCardTest {
	NumberCard aTwo;
	
	@Before
	public void setUp() {
		this.aTwo = new NumberCard(CardSuit.CLUBS, CardRank.TWO);
	}
	
	@Test
	public void startsAt11() {
		assertEquals("FAIL - card value not 2", 2, this.aTwo.value());
	}
	
	@Test
	public void correctRank() {
		assertEquals("FAIL - wrong rank", "2", this.aTwo.rank());
	}
	
	@Test
	public void correctSuit() {
		assertEquals("FAIL - wrong suit", CardSuit.CLUBS.toString(), this.aTwo.suit());
	}
	
	@Test
	public void didNotflip() {
		this.aTwo.flip();
		assertEquals("FAIL - should not have flipped", 2, this.aTwo.value());
	}
	
}
