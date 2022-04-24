import java.util.ArrayList;


public class GameBoard {

   private final ArrayList<ArrayList<BoardCell>> cellList;
   private int totalMines;
   private final int gameBoardSize;


   public GameBoard(int mineOdds, int gameBoardSize) throws IllegalArgumentException {
      if (gameBoardSize < 1)
         throw new IllegalArgumentException("Size must be greater than zero.");

      this.gameBoardSize = gameBoardSize;

      cellList = new ArrayList<>();

      // fills in the board with tiles
      for (int x_axis = 0; x_axis < gameBoardSize + 2; x_axis++) {
         cellList.add(new ArrayList<>());

         for (int y_axis = 0; y_axis < gameBoardSize + 2; y_axis++) {
            if (isNullBorder(x_axis,y_axis)) {
               cellList.get(x_axis).add(null); // makes a null border around board

            } else {
               BoardCell cell = new BoardCell(mineOdds);
               cellList.get(x_axis).add(cell);

               if (cell.isMine())
                  totalMines++;
            }
         }
      }
   }

   private boolean isNullBorder(int x_axis,int y_axis)
   {
      return (x_axis == 0 || x_axis == gameBoardSize + 1 || y_axis == 0 || y_axis == gameBoardSize + 1);
   }

   public BoardCell chooseCell(int xCoordinate, int yCoordinate)
         throws ArrayIndexOutOfBoundsException {
      if (isCellnotOnBoard(xCoordinate, yCoordinate))
         throw new ArrayIndexOutOfBoundsException("Coordinates not on board.");

      return cellList.get(xCoordinate).get(yCoordinate);
   }

   private boolean isCellnotOnBoard(int xCoordinate,int yCoordinate)
   {
      return (xCoordinate < 1 || xCoordinate > gameBoardSize || yCoordinate < 1 || yCoordinate > gameBoardSize);
   }

   public int getMineNumbers() {
      return totalMines;
   }

   public String toString() {
      String board = "";

      for (int yAxis = gameBoardSize; yAxis > 0; yAxis--) {
         for (int xAxis = 1; xAxis <= gameBoardSize; xAxis++) {

            board = board.concat(cellList.get(xAxis).get(yAxis).toString());
         }

         board = board.concat("\n");
      }

      return board;
   }


}
