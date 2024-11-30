package edu.grinnell.csc207.util;

/**
 * The leaf of a tree, containing a value and
 * no children.
 *
 * @author Sarah Deschamps
 */
public class TreeLeaf extends TreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value stored within the leaf.
   */
  String value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public TreeLeaf(String value) {
    super();
    this.value = value;
  } // TreeLeaf(char)

  public TreeLeaf() {
    super();
  } // TreeLeaf()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Gets the value contained in this leaf.
   *
   * @return the value.
   */
  public String getValue() {
    return this.value;
  } // getValue()

  /**
   * Sets the value stored in the leaf.
   *
   * @param val
   *    The value to be put into the leaf.
   */
  public void setValue(String val) {
    this.value = val;
  } // setValue(char)

  /**
   * Determines whether this is a leaf.
   *
   * @return true if this is a leaf, false otherwise.
   */
  @Override
  public boolean isLeaf() {
    return true;
  } // isLeaf()
} // class TreeLeaf
