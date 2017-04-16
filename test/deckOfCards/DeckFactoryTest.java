package deckOfCards;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DeckFactoryTest {
	
	List<Dealable> deck;
	
	@Before
	public void setUp() {
		this.deck = DeckFactory.buildDeck(DeckSize.SINGLEDECK);
	}
	
	@Test
	public void fiftyTwoCard() {
		assertEquals("FAIL - did not make 52 cards", 52, this.deck.size());
	}
	
	@Test
	public void thirteenClubs() {
		assertEquals("FAIL - there were not 13 clubs", 13, this.findNumberOfSuits(CardSuit.CLUBS));
	}
	
	@Test
	public void thirteenHearts() {
		assertEquals("FAIL - there were not 13 hearts", 13, this.findNumberOfSuits(CardSuit.HEARTS));
	}
	
	@Test
	public void thirteenDiamonds() {
		assertEquals("FAIL - there were not 13 diamonds", 13, this.findNumberOfSuits(CardSuit.DIAMONDS));
	}
	
	@Test
	public void thirteenSpades() {
		assertEquals("FAIL - there were not 13 spades", 13, this.findNumberOfSuits(CardSuit.SPADES));
	}
	
	@Test
	public void fourAces() {
		assertEquals("FAIL - there were not 4 aces", 4, this.findNumberOfRanks(CardRank.ACE));
	}
	
	@Test
	public void fourTwos() {
		assertEquals("FAIL - there were not 4 twos", 4, this.findNumberOfRanks(CardRank.TWO));
	}
	
	@Test
	public void fourThrees() {
		assertEquals("FAIL - there were not 4 threes", 4, this.findNumberOfRanks(CardRank.THREE));
	}
	
	@Test
	public void fourFourss() {
		assertEquals("FAIL - there were not 4 fours", 4, this.findNumberOfRanks(CardRank.FOUR));
	}
	
	@Test
	public void fourFivess() {
		assertEquals("FAIL - there were not 4 fives", 4, this.findNumberOfRanks(CardRank.FIVE));
	}
	
	@Test
	public void fourSixes() {
		assertEquals("FAIL - there were not 4 sixes", 4, this.findNumberOfRanks(CardRank.SIX));
	}
	
	@Test
	public void fourSevens() {
		assertEquals("FAIL - there were not 4 sevens", 4, this.findNumberOfRanks(CardRank.SEVEN));
	}
	
	@Test
	public void fourEights() {
		assertEquals("FAIL - there were not 4 eights", 4, this.findNumberOfRanks(CardRank.EIGHT));
	}
	
	@Test
	public void fourNines() {
		assertEquals("FAIL - there were not 4 nines", 4, this.findNumberOfRanks(CardRank.NINE));
	}
	
	@Test
	public void fourTens() {
		assertEquals("FAIL - there were not 4 tens", 4, this.findNumberOfRanks(CardRank.TEN));
	}
	
	@Test
	public void fourJacks() {
		assertEquals("FAIL - there were not 4 jacks", 4, this.findNumberOfRanks(CardRank.JACK));
	}
	
	@Test
	public void fourQueenss() {
		assertEquals("FAIL - there were not 4 queens", 4, this.findNumberOfRanks(CardRank.QUEEN));
	}
	
	@Test
	public void fourKings() {
		assertEquals("FAIL - there were not 4 kings", 4, this.findNumberOfRanks(CardRank.KING));
	}
	
	private int findNumberOfRanks(CardRank desiredRank) {
		
		int counter = 0;
		
		for (Dealable cards : this.deck) {
			
			if (cards.rank().equals(desiredRank.rank())) {
				counter++;
			}
		}
		return counter;
	}
	
	private int findNumberOfSuits(CardSuit desiredSuit) {
		
		int counter = 0;
		
		for (Dealable cards : this.deck) {
			
			if (cards.suit().equals(desiredSuit.toString())) {
				counter++;
			}
		}
		return counter;
	}
}
