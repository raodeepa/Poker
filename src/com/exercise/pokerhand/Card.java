package com.exercise.pokerhand;

/**
 * Card class is used to represent a single card in the hand.
 * There will only be one instance of each card type.
 * 
 * @author Deepa Rao
 *
 */
public class Card implements Comparable<Object> {

	private String suit;
	private String value;
	private int rank;

	/**
	 * Default constructor to initialize a card.
	 * 
	 * @param suit
	 * @param value
	 * @param rank
	 */
	public Card(String suit, String value, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}

	/**
	 * Method to compare two cards based on their ranks. Returns 0 when equal,
	 * -1 when less, 1 when greater.
	 * 
	 */
	public int compareTo(Object object) {

		if (this.rank == ((Card) object).rank)
			return 0;
		else if (this.rank < ((Card) object).rank)
			return -1;
		else
			return 1;
	}

	/**
	 * Helper method to display card's value and suit.
	 * 
	 */
	public void displayCard() {

		System.out.print(value + suit + " ");

	}

	/**
	 * Returns the rank of the card.
	 * 
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns the suit of the card.
	 * 
	 * @return suit
	 */

	public String getSuit() {
		return suit;
	}

	/**
	 * Returns the value of the card.
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the rank of the card.
	 * 
	 * @param rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Set the suit of the card.
	 * 
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Set the value of the card.
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
