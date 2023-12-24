package onitama;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.*;

public class Deck {
	private static CardFIle allCards[];

	public static void init() {
		allCards = new CardFIle[CardFIle.allCards.size()];

		shuffle();
	}

	public static CardFIle[] draw() {
		return Arrays.copyOfRange(allCards,0,5);
	}

	public static void shuffle() {
		Collections.shuffle(CardFIle.allCards);
		for (int i = 0; i < 5; i++)
			allCards[i] = CardFIle.allCards.get(i);
	}
}
