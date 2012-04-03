package com.exercise.pokerhand;

/**
 * Main Class that will generate hands from the deck and evaluate the rank of
 * each hand.
 * 
 * @author Deepa Rao
 * 
 */
public class Poker {

	public static void main(String[] args) {

		// Initialize a deck with 100 cards
		Deck deck = new Deck(200);

		// Run a poker game that will randomly generate 5-card hands till the
		// deck runs out of cards
		if (deck.getSize() < 5) {
			System.out
					.println("The initial size of the deck should be greater than 4 so that at least one hand can be drawn");
		} else {
			// draw hand and evaluate
			while (deck.getRemainingCards() >= 5) {
				Hand hand = new Hand(deck);
				System.out.println();
				hand.displayHand();
				System.out.println();
				hand.evaluateHand();
				System.out.println("Rank:" + hand.getRank());

			}
		}
	}
}
