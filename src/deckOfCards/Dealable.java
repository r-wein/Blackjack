package deckOfCards;

public interface Dealable {
	
	// cards numeric value
	public int value();
	
	// card's rank: (i.e) A, 2, 10, or Q
	public String rank();
	
	// card's suit: (i.e.) Hears or Spades
	public String suit();
	
	// these last two will only apply to ace cards
	// allows us to flip value from 11 to 1 and back.
	public void flip();
}
