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

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.head = new TreeNode(n);
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  private TreeLeaf traverseTree(String bits) {
    TreeNode curr = this.head;
    for (char bit : bits.toCharArray()) {
      if (bit == '1') {
        curr = curr.getRight();
      } else if (bit == '0') {
        curr = curr.getLeft();
      } else {
        throw new IndexOutOfBoundsException();
      } // if-else
    } // for
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
