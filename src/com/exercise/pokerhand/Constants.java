package com.exercise.pokerhand;

/**
 * Constants Class is used to store all the string and number constant values
 * used during hand evaluation as well as for display.
 * 
 * @author US
 * 
 */
public class Constants {

	// public static String handRanks[] = { "Royal Flush", "Straight Flush",
	// "Four of a Kid", "Full House", "Flush", "Straight",
	// "Three of a kind", "Two pair", "One pair", "High Card" };

	public static String suitsName[] = { "clubs", "diamonds", "hearts",
			"spades" };

	public static String suits[] = { "c", "d", "h", "s" };

	public static String values[] = { "A", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "K", "Q", "J" };

	public static int ranks[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	public static String spadesFlushFormat = "s,s,s,s,s";

	public static String clubsFlushFormat = "c,c,c,c,c";

	public static String heartsFlushFormat = "h,h,h,h,h";

	public static String diamondsFlushFormat = "d,d,d,d,d";

}
