

public class EasyDififculty implements GameDifficulty {


    @Override
    public GameBoard createBoard() {
        return new GameBoard(5,5);
    }
}
