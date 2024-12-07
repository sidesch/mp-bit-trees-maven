package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 * Command line program that assists in converting to and from
 * Braille bits, ASCII characters, and Unicode characters.
 *
 * @author Sarah Deschamps
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Command line main program. Helps in conversions between
   * Braille bits, ASCII characters, and Unicode characters.
   *
   * @param args
   *    The arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length == 2) {
      String command = args[0];
      String message = args[1];
      if (command.equals("braille")) {
        for (char letter : message.toCharArray()) {
          try {
            String bits = BrailleAsciiTables.toBraille(letter);
            if (bits == null) {
              pen.println("\nTrouble translating because No corresponding value");
              pen.close();
              return;
            } // if
            pen.print(BrailleAsciiTables.toBraille(letter));
          } catch (IndexOutOfBoundsException e) {
            pen.println("\nTrouble translating because " + e.getMessage());
            pen.close();
            return;
          } // try-catch
        } // for
        pen.println();
      } else if (command.equals("unicode")) {
        for (char letter : message.toCharArray()) {
          try {
            pen.print(BrailleAsciiTables.toUnicode(BrailleAsciiTables.toBraille(letter)));
          } catch (IndexOutOfBoundsException e) {
            pen.println("\nTrouble translating because " + e.getMessage());
            pen.close();
            return;
          } // try-catch
        } // for
        pen.println();
      } else if (command.equals("ascii")) {
        StringBuilder sb = new StringBuilder();
        if (message.length() % 6 != 0) {
          pen.println("Invalid length of bit string");
          pen.close();
          return;
        } // if
        for (int i = 6; i <= message.length(); i += 6) {
          try {
            String bits = message.substring(i - 6, i);
            sb.append(BrailleAsciiTables.toAscii(bits));
          } catch (IndexOutOfBoundsException e) {
            pen.println("\nTrouble translating because " + e.getMessage());
            pen.close();
            return;
          } // try-catch
        } // for
        pen.println(sb.toString());
      } else {
        pen.println("Invalid command.");
      } // if-else
    } // if
    pen.close();
  } // main(String[]
} // class BrailleASCII
