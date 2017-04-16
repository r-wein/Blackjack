package deckOfCards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AcesTest {
	
	Ace anAce;
	
	@Before
	public void setUp() {
		this.anAce = new Ace(CardSuit.CLUBS);
	}
	
	@Test
	public void startsAt11() {
		assertEquals("FAIL - card value not 11", 11, this.anAce.value());
	}
	
	@Test
	public void correctRank() {
		assertEquals("FAIL - wrong rank", "A", this.anAce.rank());
	}
	
	@Test
	public void correctSuit() {
		assertEquals("FAIL - wrong suit", CardSuit.CLUBS.toString(), this.anAce.suit());
	}
	
	@Test
	public void flipTo1() {
		this.anAce.flip();
		assertEquals("FAIL - did not flip", 1, this.anAce.value());
	}
	
	@Test
	public void flipBackTo11() {
		this.anAce.flip();
		this.anAce.flip();
		assertEquals("FAIL - did not flip back", 11, this.anAce.value());
	}
}
