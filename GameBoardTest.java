import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class GameBoardTest {


   /**
    * Tests that the constructor throws exceptions.
    */
   @SuppressWarnings("unused")
   @Test
   void testGameBoard() {
      try {
         GameBoard badOddsBoard = new GameBoard(0, 5);
         fail("Constructor did not throw exception.");
      } catch (IllegalArgumentException error) {
         assert (error.getMessage()
               .equals("Odds must be greater than or equal to 1."));
      }

      try {
         GameBoard badSizeBoard = new GameBoard(10, 0);
         fail("Constructor did not throw exception.");
      } catch (IllegalArgumentException error) {
         assert (error.getMessage().equals("Size must be greater than zero."));
      }
   }


   /**
    * Test method for chooseCell().
    */
   @Test
   void testChooseCell() {
      GameBoard board = new GameBoard(10, 5);
      board.chooseCell(2, 2);

      try {
         board.chooseCell(-1, 2);
         fail("Exception not thrown");
      } catch (ArrayIndexOutOfBoundsException ignored) {
      }

      try {
         board.chooseCell(6, 2);
         fail("Exception not thrown");
      } catch (ArrayIndexOutOfBoundsException ignored) {
      }

      try {
         board.chooseCell(2, -1);
         fail("Exception not thrown");
      } catch (ArrayIndexOutOfBoundsException ignored) {
      }

      try {
         board.chooseCell(-1, 0);
         fail("Exception not thrown");
      } catch (ArrayIndexOutOfBoundsException ignored) {
      }
   }


   /**
    * Test method for getNumMines().
    */
   @Test
   void testGetNumMines() {
      int mine = 1;
      int noOdds = Integer.MAX_VALUE;
      int size = 5;

      GameBoard mineBoard = new GameBoard(mine, size);
      assert (mineBoard.getMineNumbers() == size * size);

      GameBoard emptyBoard = new GameBoard(noOdds, size);
      assert (emptyBoard.getMineNumbers() == 0);
   }


   /**
    * Test method for toString(). Is only able to print the board to console.
    */
   @Test
   void testToString() {
      int mine = 1;
      int noOdds = Integer.MAX_VALUE;
      int size = 5;

      GameBoard board = new GameBoard(10, 5);
      GameBoard mineBoard = new GameBoard(mine, size);
      GameBoard emptyBoard = new GameBoard(noOdds, size);

      System.out.println(board);
      for (int y = size; y > 0; y--) {
         for (int x = 1; x <= size; x++) {
            board.chooseCell(x, y).show();
         }
      }
      System.out.println(board);
      
      System.out.println(mineBoard);
      for (int y = size; y > 0; y--) {
         for (int x = 1; x <= size; x++) {
            mineBoard.chooseCell(x, y).show();
         }
      }
      System.out.println(mineBoard);

      System.out.println(emptyBoard);
      for (int y = size; y > 0; y--) {
         for (int x = 1; x <= size; x++) {
            emptyBoard.chooseCell(x, y).show();
         }
      }
      System.out.println(emptyBoard);
   }


}
