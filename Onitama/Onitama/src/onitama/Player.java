package onitama;

/**
 *
 * @author samee
 */
import java.util.Arrays;

public class Player {
	public static final int EASY = 3, MEDIUM = 4, HARD = 5;

	private CardFIle[] cards;
	private BoardFile board;
	private int color;
	private boolean isComputer;
	private int difficulty;

	public Player(CardFIle[] moves, int playerColor, int difficulty) {
		this(moves, playerColor);

		isComputer = true;
		this.difficulty = difficulty;
	}

	public Player(CardFIle[] moves, int playerColor) {
		cards = moves;
		color = playerColor;
		difficulty = 0;
		isComputer = false;
	}

	public Player(Player p) {
		cards = Arrays.copyOf(p.getCards(),2);
		board = p.getBoard();
		color = p.getColor();
		isComputer = p.isComputer();
		difficulty = p.getDifficulty();
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int n) {
		difficulty = n;
	}

	public boolean isComputer() {
		return isComputer;
	}

	public void setBoard(BoardFile b) {
		if(board == null)
			board = b;
		else
			board = new BoardFile(b);
	}

	public BoardFile getBoard() {
		return board;
	}

	public void setCard(int index, CardFIle card) {
		cards[index] = new CardFIle(card);
	}

	public Coordinate [] getMove() {
		if(isComputer)
			return getMax();
		return null;
	}

	public Coordinate [] getMax() {
		return new Coordinate[] {new Coordinate(0,0), new Coordinate(0,0)};
	}

	public CardFIle[] getCards() {
		return cards;
	}

	public int getColor() {
		return color;
	}

	public String toString() {
		return getColorString()+"\nCards: "+cards[0]+", "+cards[1]+"\nIs Computer: "+isComputer+"\nDifficulty: "+difficulty;
	}

	public String getColorString() {
		String col = "Blue";
		if(color == BoardFile.red) col = "Red";
		return col;
	}

}
