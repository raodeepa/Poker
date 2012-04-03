package com.exercise.pokerhand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hand Class is used to represent a set of 5 cards. Each card in the hand will
 * be a unique instance of the class card. All the cards are stored in a array
 * list and are randomly generated.
 * 
 * @author Deepa Rao
 * 
 */
public class Hand {

	private ArrayList<Card> cards;

	private StringUtils strUtils;

	String rank = "Nothing";

	/**
	 * Default constructor that initializes a hand with 5 cards chosen from the
	 * deck.
	 * 
	 * @param deck
	 */
	public Hand(Deck deck) {
		super();

		cards = new ArrayList<Card>();

		if (deck.isValid()) {

			// initialize
			for (int i = 0; i <= 4; i++) {
				cards.add(deck.drawCardFromDeck());
			}

		} else {
			// if deck is not valid then there is no point in continuing
			// further.
			System.out.println("Deck is not initialized properly.");
			System.exit(0);
		}

	}

	/**
	 * Check the hand for flush. Check if all 5 cards have the same suit.
	 * Returns true if exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForFlush() {

		if (strUtils.getCardSuitsAsString()
				.contains(Constants.clubsFlushFormat)
				|| strUtils.getCardSuitsAsString().contains(
						Constants.diamondsFlushFormat)
				|| strUtils.getCardSuitsAsString().contains(
						Constants.heartsFlushFormat)
				|| strUtils.getCardSuitsAsString().contains(
						Constants.spadesFlushFormat)) {
			return true;
		}
		return false;
	}

	/**
	 * Check the hand for four of a kind. Check that 4 cards have the same rank.
	 * Returns true if exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForFourofaKind() {
		boolean exists = false;

		for (int i = 0; i < 4; i++) {
			if (strUtils.getCardRanksAsString().contains(
					strUtils.getCardRanksAsArray()[i] + ","
							+ strUtils.getCardRanksAsArray()[i] + ","
							+ strUtils.getCardRanksAsArray()[i] + ","
							+ strUtils.getCardRanksAsArray()[i])) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	/**
	 * Check the hand for full house. Check that 3 cards have the same rank AND
	 * the remaining 2 cards have the same rank. i.e check for three of a kind
	 * and one pair Returns true if exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForFullHouse() {
		String cardRanks = strUtils.getCardRanksAsString();
		boolean isThreeofKind = false;
		boolean isOnePair = false;
		for (int i = 0; i < 4; i++) {
			String toCheck = strUtils.getCardRanksAsArray()[i] + ","
					+ strUtils.getCardRanksAsArray()[i] + ","
					+ strUtils.getCardRanksAsArray()[i];
			if (cardRanks.contains(toCheck)) {
				cardRanks = cardRanks.replace(toCheck, " ");
				isThreeofKind = true;
			} else {
				toCheck = strUtils.getCardRanksAsArray()[i] + ","
						+ strUtils.getCardRanksAsArray()[i];
				if (cardRanks.contains(toCheck)) {
					cardRanks = cardRanks.replace(toCheck, "");
					isOnePair = true;
				}
			}
		}
		cardRanks = null;
		if (isThreeofKind && isOnePair)
			return true;
		return false;
	}

	/**
	 * Check the hand for High card. Check that there is at least 1 card whose
	 * rank is either 0 or greater than 9 but less than 13. Returns true if
	 * exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForHighCard() {
		boolean exists = false;
		for (int i = 0; i < 4; i++) {
			if (strUtils.getCardRanksAsString().contains("0")
					|| strUtils.getCardRanksAsString().contains("10")
					|| strUtils.getCardRanksAsString().contains("11")
					|| strUtils.getCardRanksAsString().contains("12")) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	/**
	 * Check the hand for one pair. Check that exactly 2 cards have the same
	 * rank. Returns true if exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForOnePair() {
		boolean exists = false;
		for (int i = 0; i < 4; i++) {
			if (strUtils.getCardRanksAsString().contains(
					strUtils.getCardRanksAsArray()[i] + ","
							+ strUtils.getCardRanksAsArray()[i])) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	/**
	 * Check the hand for royal flush. Check that all 5 cards have the same suit
	 * and all the ranks are in this group (0,9,10,11,12). Returns true if
	 * exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForRoyalFlush() {
		if (checkForFlush()) {
			if (strUtils.getCardRanksAsString().contains("0,9,10,11,12")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check the hand for straight. Check that the rank of all 5 cards are in a
	 * sequence. Returns true if exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForStraight() {

		if (strUtils.getAllRanksAsString().contains(
				strUtils.getCardRanksAsString())) {
			return true;
		}
		return false;
	}

	/**
	 * Check the hand for straight flush. Check that all 5 cards have the same
	 * suit and all 5 ranks are in a sequence. Returns true if exists otherwise
	 * false.
	 * 
	 * @return boolean
	 */
	private boolean checkForStraightFlush() {
		if (checkForStraight() && checkForFlush())
			return true;
		return false;
	}

	/**
	 * Check the hand for three of a kind. Check that exactly 3 cards have the
	 * same rank. Returns true if exists otherwise false.
	 * 
	 * @return boolean
	 */
	private boolean checkForThreeOfaKind() {
		boolean exists = false;

		for (int i = 0; i < 4; i++) {
			if (strUtils.getCardRanksAsString().contains(
					strUtils.getCardRanksAsArray()[i] + ","
							+ strUtils.getCardRanksAsArray()[i] + ","
							+ strUtils.getCardRanksAsArray()[i])) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	/**
	 * Check the hand for two pair. Check that there are 4 cards of which there
	 * exists exactly 2 cards with same rank. Returns true if exists otherwise
	 * false.
	 * 
	 * @return boolean
	 */
	private boolean checkForTwoPair() {
		int pairCount = 0;
		String cardRanks = strUtils.getCardRanksAsString();
		for (int i = 0; i < 4; i++) {
			String toCheck = strUtils.getCardRanksAsArray()[i] + ","
					+ strUtils.getCardRanksAsArray()[i];
			if (cardRanks.contains(toCheck)) {
				cardRanks = cardRanks.replace(toCheck, " ");
				pairCount = pairCount + 1;
			}
		}
		cardRanks = null;
		if (pairCount == 2)
			return true;

		return false;
	}

	/**
	 * Helper method to display the current hand.
	 * 
	 */
	public void displayHand() {
		if (isHandValid()) {
			for (int i = 0; i <= 4; i++) {
				cards.get(i).displayCard();
			}
		}

	}

	/**
	 * Method to evaluate the cards in the hand and determine the rank of the
	 * hand. The logic below checks the hand for the following ranks in the
	 * order of the best to the worst. If it doesn't find any of these ranks
	 * then it defaults to Nothing. 1. Royal Flush 2. Straight Flush 3. Four of
	 * a kind 4. Full House 5. Flush 6. Straight 7. Three of a kind 8. Two pair
	 * 9. One pair 10. High Card 11. Nothing
	 * 
	 * @return
	 */
	public void evaluateHand() {

		if (isHandValid()) {
			// Helper method to sort the cards by rank
			sortHandByRank();

			// String utility helper class for rank and suit comparison as
			// string
			strUtils = new StringUtils(cards);
			
			if (checkForRoyalFlush()) {
				setRank("Royal Flush");
			} else if (checkForStraightFlush()) {
				setRank("Straight Flush");
			} else if (checkForFourofaKind()) {
				setRank("Four of a Kind");
			} else if (checkForFullHouse()) {
				setRank("Full House");
			} else if (checkForFlush()) {
				setRank("Flush");
			} else if (checkForStraight()) {
				setRank("Straight");
			} else if (checkForThreeOfaKind()) {
				setRank("Three of a Kind");
			} else if (checkForTwoPair())
				setRank("Two Pair");
			else if (checkForOnePair()) {
				setRank("One pair");
			} else if (checkForHighCard()) {
				setRank("High Card");
			} else
				setRank("Nothing");
		} else {
			System.out
					.println("Something seems wrong about the cards. Check whether the cards are valid or not.");
		}

	}

	/**
	 * Returns the rank of the hand.
	 * 
	 * @return rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Helper method to check whether its a valid hand.
	 * 
	 * @return boolean
	 */

	private boolean isHandValid() {

		if (cards != null) {
			if (cards.isEmpty() || cards.size() < 5)
				return false;
		} else
			return false;

		return true;

	}

	/**
	 * Sets the rank of the hand after evaluating the cards.
	 * 
	 * @param rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Helper method to sort the cards in the hand based on their ranks.
	 * 
	 */
	private void sortHandByRank() {

		Collections.sort((List<Card>) cards);

	}

}
