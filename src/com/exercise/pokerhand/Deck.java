package com.exercise.pokerhand;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck Class is used to represent the deck from which a 5 card will get created
 * till the deck runs our of cards. Deck can only contain valid Card objects.
 * 
 * @author Deepa Rao
 * 
 */
public class Deck {

	private int size;

	private ArrayList<Card> deck;

	private ArrayList<Card> basicSetOfCards;

	/**
	 * Default constructor to initialize a deck with the number of cards
	 * provided in size field.
	 * 
	 * @param size
	 */
	public Deck(int size) {
		super();
		this.size = size;

		// this is used to initialize basic set of all valid cards that form a
		// deck.
		initializeCards();
		// this is used to initialize a deck with random cards picked from the
		// basic set
		initializeDeck();
	}

	/**
	 * Helper method that allows to add a card to the deck.
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		deck.add(card);

	}

	/**
	 * Helper method that clears all the cards from the deck.
	 * 
	 */
	public void clear() {
		deck.clear();
	}

	/**
	 * Helper method that allows to draw one card from the deck.
	 * 
	 * @return Card
	 */

	public Card drawCardFromDeck() {
		
		Card card = null;
		if (deck.size() > 0) {
			card = deck.get(0);
			deck.remove(0);			
		}	
		return card;
	}

	/**
	 * Helper method that returns the current count of the cards in the deck.
	 * 
	 * @return
	 */
	public int getRemainingCards() {
		return deck.size();
	}

	/**
	 * Returns the initial size of the deck.
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Initialize a basic set of 52 cards (4 suits times 13 ranks) that are
	 * valid to be added to deck.
	 * 
	 */
	private void initializeCards() {
		basicSetOfCards = new ArrayList<Card>();
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 12; j++) {
				basicSetOfCards.add(new Card(Constants.suits[i],
						Constants.values[j], Constants.ranks[j]));
			}
		}
	}

	/**
	 * Initialize a deck with the number of cards equal to its size. These cards
	 * need to be randomly picked from those basic set of 52 valid cards.
	 * 
	 */
	private void initializeDeck() {
		deck = new ArrayList<Card>();
		Random generator = new Random();
		int randomNumber = 0;

		for (int i = 0; i < size; i++) {
			randomNumber = generator.nextInt(basicSetOfCards.size() - 1);

			deck.add(basicSetOfCards.get(randomNumber));

		}

	}

	/**
	 * Checks whether the deck has valid number of cards.
	 * 
	 * @return
	 */
	public boolean isValid(){
		
		if(deck != null && deck.size() >= 5 && this.getRemainingCards() >= 5)
			return true;
		
		return false;
	}

	/**
	 * Sets the initial size of the deck.
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
