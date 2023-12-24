package onitama;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Onitama {
    private static Onitama game;

    private GameGUI gui;

    private Player p1, p2;

    private BoardFile board;

    private static int p1Difficulty = Player.EASY, p2Difficulty = Player.EASY;

    private static int playerColor = BoardFile.blue;

    private static int playerCount = 1;
    private static final String BACKGROUND_MUSIC_PATH = "C:\\Users\\Ce PC\\OneDrive\\Documents\\MiniProjet_LO_SULEIMAN_LAMESH_COURTOIS\\Onitama\\musique.wav";

    private Clip backgroundMusic;

    public static void main(String[] args) {
        CardFIle.init();
        Deck.init();
        game = new Onitama();
        game.startBackgroundMusic();
        game.run();
    }

    public static void reset() {
        Deck.shuffle();
        game.resetGame();
        game.run();
    }

    public static void updatePlayerCount(int n) {
        playerCount = n;
    }

    public static void updateDifficulty(int newDifficulty) {
        p1Difficulty = p2Difficulty = newDifficulty;
        game.updateDifficulty();
    }

    public Onitama() {
        CardFIle cards[] = Deck.draw();
        p1 = new Player(new CardFIle[]{cards[0], cards[3]}, BoardFile.red, Player.EASY);
        p2 = new Player(new CardFIle[]{cards[1], cards[4]}, BoardFile.blue);

        board = null;

        if (cards[2].getColor() == BoardFile.red)
            board = new BoardFile(cards[2], p1, p2);
        else
            board = new BoardFile(cards[2], p2, p1);

        gui = new GameGUI(cards, board);

        p1.setBoard(board);
        p2.setBoard(board);
    }

    public void run() {
        if (board.isComputerTurn())
            gui.compTurn();
    }

    private void updateDifficulty() {
        switch (playerCount) {
            case 2:
                System.out.println("No change");
                break;
            case 1:
                if (playerColor == BoardFile.red) {
                    p2.setDifficulty(p2Difficulty);
                } else {
                    p1.setDifficulty(p1Difficulty);
                }
                break;
            case 0:
                p1.setDifficulty(p1Difficulty);
                p2.setDifficulty(p2Difficulty);
                break;
        }
    }

    public void resetGame() {
        CardFIle cards[] = Deck.draw();
        switch (playerCount) {
            case 2:
                p1 = new Player(new CardFIle[]{cards[0], cards[3]}, BoardFile.red);
                p2 = new Player(new CardFIle[]{cards[1], cards[4]}, BoardFile.blue);
                break;
            case 1:
                if (playerColor == BoardFile.red) {
                    p1 = new Player(new CardFIle[]{cards[0], cards[3]}, BoardFile.red);
                    p2 = new Player(new CardFIle[]{cards[1], cards[4]}, BoardFile.blue, p2Difficulty);
                } else {
                    p1 = new Player(new CardFIle[]{cards[0], cards[3]}, BoardFile.red, p1Difficulty);
                    p2 = new Player(new CardFIle[]{cards[1], cards[4]}, BoardFile.blue);
                }
                break;
            case 0:
                p1 = new Player(new CardFIle[]{cards[0], cards[3]}, BoardFile.red, p1Difficulty);
                p2 = new Player(new CardFIle[]{cards[1], cards[4]}, BoardFile.blue, p2Difficulty);
                break;
        }
        board = null;

        if (cards[2].getColor() == BoardFile.red)
            board = new BoardFile(cards[2], p1, p2);
        else
            board = new BoardFile(cards[2], p2, p1);

        p1.setBoard(board);
        p2.setBoard(board);

        gui.reset(cards, board);
    }

    private void startBackgroundMusic() {
        try {
            File audioFile = new File(BACKGROUND_MUSIC_PATH);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
