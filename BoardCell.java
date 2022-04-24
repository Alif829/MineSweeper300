import java.util.Random;

/**
 * This class represents a single cell on the minesweeper board. The cell holds
 * the value of being a mine or not and is also able to change if it is hidden
 * to the user or not.
 * 
 * @author Alec Osmak
 */
public class BoardCell {

   private char value;
   private boolean isShown;

   BoardCell(int mineOdds) throws IllegalArgumentException {
      if (mineOdds < 1)
         throw new IllegalArgumentException(
               "Odds must be greater than or equal to 1.");

      if (new Random().nextInt(mineOdds) == 0)
         value = 'X';
      else
         value = '0';

      isShown = false;
   }

   public boolean isMine() {
      return value == 'X';
   }

   public void setValue(char value) {
      if (valueValidityChecker(value))
      {
         System.out.println("Value must be between 0 and 8 and Mine cannot be changed");
      }
      this.value = value;
   }

   private boolean valueValidityChecker(char value)
   {
      return (this.value == 'X' ||  value < '0' || value > '8');
   }

   public boolean isShown() {
      return isShown;
   }

   public void show() {
      isShown = true;
   }

   public String toString() {
      String COVER = "O";
      if (isShown) {
         if (value == '0')
            return " ";

         return Character.toString(value);

      } else
         return COVER;
   }

}
