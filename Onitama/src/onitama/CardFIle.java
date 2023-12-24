package onitama;


import java.util.ArrayList;

public class CardFIle {
//Name(Set of moves, name)
	private String name;
	private int[][] moves;
	private int color;

	public static ArrayList<CardFIle> allCards = new ArrayList<CardFIle>();

	public static CardFIle tiger;
	public static CardFIle dragon;
	public static CardFIle frog;
	public static CardFIle rabbit;
	public static CardFIle crab;
	public static CardFIle elephant;
	public static CardFIle goose;
	public static CardFIle rooster;
	public static CardFIle monkey;
	public static CardFIle mantis;
	public static CardFIle horse;
	public static CardFIle ox;
	public static CardFIle crane;
	public static CardFIle boar;
	public static CardFIle eel;
	public static CardFIle cobra;

	public String toString() {
		return name;
	}

	public static void init() {
		tiger    = new CardFIle(new int[][] {{0,2},  {0,-1}}                 ,"Tiger", BoardFile.blue);
		dragon   = new CardFIle(new int[][] {{-2,1}, {-1,-1}, {1,-1}, {2,1}} ,"Dragon", BoardFile.red);
		frog     = new CardFIle(new int[][] {{-2,0}, {-1,1},  {1,-1}}        ,"Frog", BoardFile.red);
		rabbit   = new CardFIle(new int[][] {{1,1},  {-1,-1}, {2,0}}         ,"Rabbit", BoardFile.blue);
		crab     = new CardFIle(new int[][] {{2,0},  {-2,0},  {0,1}}         ,"Crab", BoardFile.blue);
		elephant = new CardFIle(new int[][] {{1,0},  {-1,0},  {1,1},  {-1,1}},"Elephant", BoardFile.red);
		goose    = new CardFIle(new int[][] {{-1,1}, {1,-1},  {-1,0}, {1,0}} ,"Goose", BoardFile.blue);
		rooster  = new CardFIle(new int[][] {{-1,-1},{1,1},   {-1,0}, {1,0}} ,"Rooster", BoardFile.red);
		monkey   = new CardFIle(new int[][] {{1,1},  {-1,-1}, {1,-1}, {-1,1}},"Monkey", BoardFile.blue);
		mantis   = new CardFIle(new int[][] {{0,-1}, {-1,1},  {1,1}}         ,"Mantis", BoardFile.red);
		horse    = new CardFIle(new int[][] {{-1,0}, {0,1},   {0,-1}}        ,"Horse", BoardFile.red);
		ox       = new CardFIle(new int[][] {{1,0},  {0,1},   {0,-1}}        ,"Ox", BoardFile.blue);
		crane    = new CardFIle(new int[][] {{-1,-1},{1,-1},  {0,1}}         ,"Crane", BoardFile.blue);
		boar     = new CardFIle(new int[][] {{-1,0}, {1,0},   {0,1}}         ,"Boar", BoardFile.red);
		eel      = new CardFIle(new int[][] {{-1,1}, {-1,-1}, {1,0}}         ,"Eel", BoardFile.blue);
		cobra    = new CardFIle(new int[][] {{1,1},  {1,-1},  {-1,0}}        ,"Cobra", BoardFile.red);
	}

	CardFIle(int [][] moves, String name, int color) {
		this.moves = moves;
		this.name  = name;
		this.color = color;

		allCards.add(this);
	}

	public CardFIle(CardFIle c) {
		moves = c.getMoves();
		name  = c.getName();
		color = c.getColor();
	}

	public int [][] getMoves() {
		return moves;
	}

	public String getName() {
		return name;
	}

	public int getColor() {
		return color;
	}

	public String getColorString() {
		String col = "Blue";
		if(color == BoardFile.red) col = "Red";
		return col;
	}

	public static CardFIle getCardByName(String name) {
		for(CardFIle c : allCards)
			if(c.name == name)
				return c;
		return null;
	}

	public boolean equals(CardFIle c) {
		return c.getName().equals(name);
	}
}

