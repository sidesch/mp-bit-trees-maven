package edu.grinnell.csc207.util;

/**
 * A node within a tree that does not store a value,
 * and has two children.
 *
 * @author Sarah Deschamps
 */
public class TreeNode {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * The left node.
   */
  TreeNode left;

  /**
   * The right node.
   */
  TreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructor for interior node.
   *
   * @param left
   *    The left subtree.
   * @param right
   *    The right subtree.
   */
  public TreeNode(TreeNode left, TreeNode right) {
    this.left = left;
    this.right = right;
  } // TreeNode(TreeNode, TreeNode)

  /**
   * Constructor for interior node.
   */
  public TreeNode() {
    this.left = null;
    this.right = null;
  } // TreeNode()

  public TreeNode(int n) {
    if (n == 1) {
      this.left = new TreeLeaf();
      this.right = new TreeLeaf();
    } // if
    this.left = new TreeNode(n - 1);
    this.right = new TreeNode(n - 1);
  } // InteriorNode(int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Gets the left subtree.
   *
   * @return the left subtree.
   */
  public TreeNode getLeft() {
    return this.left;
  } // getLeft()

  /**
   * Gets the right subtree.
   *
   * @return the right subtree.
   */
  public TreeNode getRight() {
    return this.right;
  } // getRight()

  /**
   * Sets the left subtree.
   *
   * @param left
   *    The tree to put into the left subtree.
   */
  public void setLeft(TreeNode left) {
    this.left = left;
  } // setLeft(TreeNode)

  /**
   * Sets the right subtree.
   *
   * @param right
   *    The tree to put into the right subtree.
   */
  public void setRight(TreeNode right) {
    this.right = right;
  } // setRight(TreeNode)

  /**
   * Determines whether this is a leaf.
   *
   * @return true if this is a leaf, false otherwise.
   */
  public boolean isLeaf() {
    return false;
  } // isLeaf()
} // class TreeNode
