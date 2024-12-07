package edu.grinnell.csc207.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 * Static reference tables stored as BitTrees.
 *
 * @author Sarah Deschamps
 * @author Samuel A. Rebelsky
 */
public class BrailleAsciiTables {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * Conversions from ASCII to braille.
   */
  static final String a2b =
      "01000001,100000\n"
      + "01000010,110000\n"
      + "01000011,100100\n"
      + "01000100,100110\n"
      + "01000101,100010\n"
      + "01000110,110100\n"
      + "01000111,110110\n"
      + "01001000,110010\n"
      + "01001001,010100\n"
      + "01001010,010110\n"
      + "01001011,101000\n"
      + "01001100,111000\n"
      + "01001101,101100\n"
      + "01001110,101110\n"
      + "01001111,101010\n"
      + "01010000,111100\n"
      + "01010001,111110\n"
      + "01010010,111010\n"
      + "01010011,011100\n"
      + "01010100,011110\n"
      + "01010101,101001\n"
      + "01010110,111001\n"
      + "01010111,010111\n"
      + "01011000,101101\n"
      + "01011001,101111\n"
      + "01011010,101011\n"
      + "01100001,100000\n"
      + "01100010,110000\n"
      + "01100011,100100\n"
      + "01100100,100110\n"
      + "01100101,100010\n"
      + "01100110,110100\n"
      + "01100111,110110\n"
      + "01101000,110010\n"
      + "01101001,010100\n"
      + "01101010,010110\n"
      + "01101011,101000\n"
      + "01101100,111000\n"
      + "01101101,101100\n"
      + "01101110,101110\n"
      + "01101111,101010\n"
      + "01110000,111100\n"
      + "01110001,111110\n"
      + "01110010,111010\n"
      + "01110011,011100\n"
      + "01110100,011110\n"
      + "01110101,101001\n"
      + "01110110,111001\n"
      + "01110111,010111\n"
      + "01111000,101101\n"
      + "01111001,101111\n"
      + "01111010,101011\n"
      + "00100000,000000\n";

  /**
   * Conversions from braille to ASCII.
   */
  static final String b2a =
      "100000,A\n"
      + "110000,B\n"
      + "100100,C\n"
      + "100110,D\n"
      + "100010,E\n"
      + "110100,F\n"
      + "110110,G\n"
      + "110010,H\n"
      + "010100,I\n"
      + "010110,J\n"
      + "101000,K\n"
      + "111000,L\n"
      + "101100,M\n"
      + "101110,N\n"
      + "101010,O\n"
      + "111100,P\n"
      + "111110,Q\n"
      + "111010,R\n"
      + "011100,S\n"
      + "011110,T\n"
      + "101001,U\n"
      + "111001,V\n"
      + "101101,X\n"
      + "101111,Y\n"
      + "101011,Z\n"
      + "010111,W\n"
      + "000000, \n";

  /**
   * Conversions from braille to unicode.
   */
  static final String b2u =
      "000000,2800\n"
      + "100000,2801\n"
      + "010000,2802\n"
      + "110000,2803\n"
      + "001000,2804\n"
      + "101000,2805\n"
      + "011000,2806\n"
      + "111000,2807\n"
      + "000100,2808\n"
      + "100100,2809\n"
      + "010100,280A\n"
      + "110100,280B\n"
      + "001100,280C\n"
      + "101100,280D\n"
      + "011100,280E\n"
      + "111100,280F\n"
      + "000010,2810\n"
      + "100010,2811\n"
      + "010010,2812\n"
      + "110010,2813\n"
      + "001010,2814\n"
      + "101010,2815\n"
      + "011010,2816\n"
      + "111010,2817\n"
      + "000110,2818\n"
      + "100110,2819\n"
      + "010110,281A\n"
      + "110110,281B\n"
      + "001110,281C\n"
      + "101110,281D\n"
      + "011110,281E\n"
      + "111110,281F\n"
      + "000001,2820\n"
      + "100001,2821\n"
      + "010001,2822\n"
      + "110001,2823\n"
      + "001001,2824\n"
      + "101001,2825\n"
      + "011001,2826\n"
      + "111001,2827\n"
      + "000101,2828\n"
      + "100101,2829\n"
      + "010101,282A\n"
      + "110101,282B\n"
      + "001101,282C\n"
      + "101101,282D\n"
      + "011101,282E\n"
      + "111101,282F\n"
      + "000011,2830\n"
      + "100011,2831\n"
      + "010011,2832\n"
      + "110011,2833\n"
      + "001011,2834\n"
      + "101011,2835\n"
      + "011011,2836\n"
      + "111011,2837\n"
      + "000111,2838\n"
      + "100111,2839\n"
      + "010111,283A\n"
      + "110111,283B\n"
      + "001111,283C\n"
      + "101111,283D\n"
      + "011111,283E\n"
      + "111111,283F\n";

  // +---------------+-----------------------------------------------
  // | Static fields |
  // +---------------+

  /**
   * The tree converting from ASCII to Braille.
   */
  static BitTree a2bTree = null;

  /**
   * The tree converting from Braille to ASCII.
   */
  static BitTree b2aTree = null;

  /**
   * The tree converting from Braille to Unicode.
   */
  static BitTree b2uTree = null;

  // +-----------------------+---------------------------------------
  // | Static helper methods |
  // +-----------------------+

  /**
   * Loads the tree of a given height with a given String.
   *
   * @param source
   *    The source of the tree, in CSV format.
   * @return The created Input Stream.
   */
  private static InputStream createInputStream(String source) {
    return new ByteArrayInputStream(source.getBytes());
  } // createTree(BitTree, int, String)

  /**
   * Converts a given hex value to Unicode.
   *
   * @param hex
   *    The hex value.
   * @return The Unicode value in a String.
   */
  private static String hexToUni(String hex) {
    return new String(Character.toChars(Integer.valueOf(hex, 16)));
  } // hexToUni(String)

  // +----------------+----------------------------------------------
  // | Static methods |
  // +----------------+

  /**
   * Converts the given letter into Braille.
   *
   * @param letter
   *    The letter to convert to Braille.
   * @return The Braille representation of the letter, in bits.
   */
  public static String toBraille(char letter) {
    if (a2bTree == null) {
      InputStream a2bStream = createInputStream(a2b);
      a2bTree = new BitTree(8);
      a2bTree.load(a2bStream);
      try {
        a2bStream.close();
      } catch (IOException e) {
        // Do nothing.
      } // try-catch
    } // if
    String bits = Integer.toBinaryString((int) letter);
    while (bits.length() < 8) {
      bits = "0" + bits;
    } // while
    return a2bTree.get(bits);
  } // toBraille(char)

  /**
   * Converts the given Braille bits to ASCII.
   *
   * @param bits
   *    The Braille representation of a letter, in bits.
   * @return The ASCII representation of the letter.
   */
  public static String toAscii(String bits) {
    if (b2aTree == null) {
      InputStream b2aStream = createInputStream(b2a);
      b2aTree = new BitTree(6);
      b2aTree.load(b2aStream);
      try {
        b2aStream.close();
      } catch (IOException e) {
        // Do nothing.
      } // try-catch
    } // if
    return "" + b2aTree.get(bits);
  } // toAscii(String)

  /**
   * Converts the given Braille bits to Unicode
   * representations of Braille.
   *
   * @param bits
   *    The Braille representation of a letter, in bits.
   * @return The Unicode representation of the Braille letter.
   */
  public static String toUnicode(String bits) {
    if (b2uTree == null) {
      InputStream b2uStream = createInputStream(b2u);
      b2uTree = new BitTree(6);
      b2uTree.load(b2uStream);
      try {
        b2uStream.close();
      } catch (IOException e) {
        // Do nothing.
      } // try-catch
    } // if
    return hexToUni(b2uTree.get(bits));
  } // toUnicode(String)
} // BrailleAsciiTables
