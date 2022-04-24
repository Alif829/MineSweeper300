public class GameService {
    private final GameDifficulty difficultyLevel;


    public GameService (GameDifficulty difficultyLevel)
    {
        this.difficultyLevel=difficultyLevel;
    }

    public void gameRunner()
    {
        GameBoard board = difficultyLevel.createBoard();
        System.out.println(board);
    }
}
