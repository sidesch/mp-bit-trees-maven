package edu.grinnell.csc207.util;

/**
 * The leaf of a tree, containing a value and
 * no children.
 *
 * @author Sarah Deschamps
 */
public class TreeLeaf implements TreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value stored within the leaf.
   */
  char value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public TreeLeaf(char value) {
    this.value = value;
  } // TreeLeaf(char)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Gets the value contained in this leaf.
   *
   * @return the value.
   */
  public char getValue() {
    return this.value;
  } // getValue()

  /**
   * Sets the value stored in the leaf.
   *
   * @param val
   *    The value to be put into the leaf.
   */
  public void setValue(char val) {
    this.value = val;
  } // setValue(char)
} // class TreeLeaf
