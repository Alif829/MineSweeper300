public class MediumDifficulty implements GameDifficulty {


    @Override
    public GameBoard createBoard() {
        return new GameBoard(7,7);
    }
}
