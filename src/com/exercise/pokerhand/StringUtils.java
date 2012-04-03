package com.exercise.pokerhand;

import java.util.ArrayList;

/**
 * String utility class that has all the helper methods for string comparison.
 * 
 * @author Deepa Rao
 *
 */
public class StringUtils {

	private String cardRanksAsString = "";
	private String cardSuitsAsString = "";
	private String[] cardRanksAsArray;
	private String allRanksAsString = "";

	private ArrayList<Card> cards;

	public ArrayList<Card> getCards() {
		return cards;
	}

	public StringUtils(ArrayList<Card> cards) {
		super();
		this.cards = cards;
		createCardRanksAsString();
		createCardSuitsAsString();
		createAllRanksAsString();

	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	private void createCardRanksAsString() {

		// comma separated ranks of the cards
		// used for comparison when evaluating hands
		for (int i = 0; i <= 4; i++) {
			if (i < 4)
				cardRanksAsString = cardRanksAsString + cards.get(i).getRank()
						+ ",";
			else
				cardRanksAsString = cardRanksAsString + cards.get(i).getRank();

		}
		cardRanksAsArray = cardRanksAsString.split(",");
	}

	public String getCardRanksAsString() {
		return cardRanksAsString;
	}

	public String getCardSuitsAsString() {
		return cardSuitsAsString;
	}

	public String getAllRanksAsString() {
		return allRanksAsString;
	}

	private void createCardSuitsAsString() {

		// comma separated suits of the cards
		// used for comparison when evaluating hands
		for (int i = 0; i <= 4; i++) {
			if (i < 4)
				cardSuitsAsString = cardSuitsAsString + cards.get(i).getSuit()
						+ ",";
			else
				cardSuitsAsString = cardSuitsAsString + cards.get(i).getSuit();

		}

	}

	private String createAllRanksAsString() {

		for (int i = 0; i < Constants.ranks.length; i++) {
			allRanksAsString = allRanksAsString + Constants.ranks[i] + ",";
		}

		return allRanksAsString;
	}

	public String[] getCardRanksAsArray() {
		return cardRanksAsArray;
	}

	public void setCardRanksAsArray(String[] cardRanksAsArray) {
		this.cardRanksAsArray = cardRanksAsArray;
	}

	public void setCardRanksAsString(String cardRanksAsString) {
		this.cardRanksAsString = cardRanksAsString;
	}

	public void setCardSuitsAsString(String cardSuitsAsString) {
		this.cardSuitsAsString = cardSuitsAsString;
	}

	public void setAllRanksAsString(String allRanksAsString) {
		this.allRanksAsString = allRanksAsString;
	}

}
