import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the functionality of the BoardCell class.
 * 
 * @author Alec Osmak
 */
class BoardCellTest {


   /**
    * Tests that the constructor throws exceptions.
    */
   @SuppressWarnings("unused")
   @Test
   void testConstructorThrowsException() {
      try {
         BoardCell zeroError = new BoardCell(0);
         fail("Constructor did not throw exception.");
      } catch (IllegalArgumentException ignored) {
      }
   }


   /**
    * Test method for isMine().
    */
   @Test
   void testIsMine() {
      BoardCell mine = new BoardCell(1);
      assert (mine.isMine());

      BoardCell likelyNotMine = new BoardCell(Integer.MAX_VALUE);
      assert (!likelyNotMine.isMine());
   }


   /**
    * Test method for setValue().
    */
   @Test
   void testSetValue() {
         BoardCell mine = new BoardCell(1);
         mine.setValue('1');
      }


   /**
    * Test method for isShown() and show().
    */
   @Test
   void testIsShown() {
      BoardCell cell = new BoardCell(10);

      assert (!cell.isShown());
      cell.show();
      assert (cell.isShown());
   }


   /**
    * Test method for toString(). Should print according to if it is shown or
    * not.
    */
   @Test
   void testToString() {
      BoardCell mine = new BoardCell(1);
      BoardCell likelyNotMine = new BoardCell(Integer.MAX_VALUE);

      assert (mine.toString().equals("O"));
      assert (likelyNotMine.toString().equals("O"));

      mine.show();
      likelyNotMine.show();

      assert (mine.toString().equals("X"));
      assert (likelyNotMine.toString().equals(" "));
   }


}
