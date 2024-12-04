package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Sarah Deschamps
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The head of the tree.
   */
  TreeNode head;

  /**
   * The height of the tree.
   */
  int height;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new BitTree.
   *
   * @param n
   *    The height of the BitTree.
   */
  public BitTree(int n) {
    this.head = new TreeNode();
    this.height = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Traverses the tree given the String of bits.
   *
   * @param bits
   *    The bit path.
   *
   * @return the TreeNode at the end of the bit path.
   */
  private TreeLeaf traverseTree(String bits) {
    if (bits.length() != this.height) {
      throw new IndexOutOfBoundsException();
    } // if
    TreeNode curr = this.head;
    for (int i = 0; i < bits.length() - 1; i++) {
      if (bits.substring(i, i + 1).equals("1")) {
        if (curr.getRight() != null) {
          curr = curr.getRight();
        } else {
          curr.setRight(new TreeNode());
          curr = curr.getRight();
        } // if-else
      } else if (bits.substring(i, i + 1).equals("0")) {
        if (curr.getLeft() != null) {
          curr = curr.getLeft();
        } else {
          curr.setLeft(new TreeNode());
          curr = curr.getLeft();
        } // if-else
      } else {
        throw new IndexOutOfBoundsException();
      } // if-else
    } // for
    if (bits.substring(this.height - 1).equals("1")) {
      if (curr.getRight() != null) {
        curr = curr.getRight();
      } else {
        curr.setRight(new TreeLeaf());
        curr = curr.getRight();
      } // if-else
    } else if (bits.substring(this.height - 1).equals("0")) {
      if (curr.getLeft() != null) {
        curr = curr.getLeft();
      } else {
        curr.setLeft(new TreeLeaf());
        curr = curr.getLeft();
      } // if-else
    } // if-else
    if (!curr.isLeaf()) {
      throw new IndexOutOfBoundsException();
    } else {
      return (TreeLeaf) curr;
    } // if-else
  } // traverseTree(String)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sets the value of the leaf reached when following
   * the bit path.
   *
   * @param bits
   *    The bit path.
   * @param value
   *    The value to store in the leaf.
   */
  public void set(String bits, String value) {
    TreeLeaf leaf = traverseTree(bits);
    leaf.setValue(value);
  } // set(String, String)

  /**
   * Gets the leaf following the bit path.
   *
   * @param bits
   *    The bit path.
   *
   * @return the leaf following the bit path.
   */
  public String get(String bits) {
    return traverseTree(bits).getValue();
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    // STUB
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)
} // class BitTree
