/*
 * Project: MineSweeper300
 * Files: RunMineSweeper.java, GameBoard.java, BoardCell.java
 * 
 * Description: A text based minesweeper game displayed and played from the
 * console. Input is received via Scanner and output is created from print
 * statements.
 * 
 * Author: Alec Osmak
 * Email: osmak@wisc.edu
 * 
 * Date Started: July 7, 2020
 */

//import java.util.ArrayList;

public class RunMineSweeper {

   public static void main(String[] args) {
         System.out.println("Welcome to MineSweeper300!\n");
         GameService service=new GameService(new MediumDifficulty());
         service.gameRunner();

         System.out.println();

         System.out.println("Goodbye");
   }

}
