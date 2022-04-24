

public class HardDifficulty implements GameDifficulty {

    @Override
    public GameBoard createBoard() {

        return new GameBoard(9,9);
    }
}
