package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
      throw new IndexOutOfBoundsException("Invalid length of bit string");
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
        throw new IndexOutOfBoundsException("Bit string contains character other than '1' or '0'.");
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
    } else {
      throw new IndexOutOfBoundsException("Bit string contains character other than '1' or '0'.");
    } // if-else
    if (!curr.isLeaf()) {
      throw new IndexOutOfBoundsException("Invalid length of bit string");
    } else {
      return (TreeLeaf) curr;
    } // if-else
  } // traverseTree(String)

  private void dumpHelper(PrintWriter pen, TreeNode node, String soFar) {
    if (node == null) {
      return;
    } // if
    if (soFar.length() == this.height && node.isLeaf()) {
      TreeLeaf leaf = (TreeLeaf) node;
      if (leaf.getValue() != null) {
        pen.println(soFar + "," + leaf.getValue());
      } // if
    } else if (node.isLeaf()) {
      throw new IndexOutOfBoundsException();
    } else {
      if (node.getLeft() != null) {
        dumpHelper(pen, node.getLeft(), soFar + "0");
      } // if
      if (node.getRight() != null) {
        dumpHelper(pen, node.getRight(), soFar + "1");
      } // if
    } // if-else
  } // dumpHelper(PrintWriter, TreeNode)

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
   * Prints all contents of the tree in CSV style
   * using depth-first left-to-right and post-order
   * tree traversal.
   *
   * @param pen
   *    The place to write the output.
   */
  public void dump(PrintWriter pen) {
    dumpHelper(pen, this.head, "");
  } // dump(PrintWriter)

  /**
   * Reads CSV style document that loads values
   * into the bit tree.
   *
   * @param source
   *    CSV style document. Takes form 'bits,value'.
   *
   * @throws IOException
   */
  public void load(InputStream source) {
    BufferedReader br = new BufferedReader(new InputStreamReader(source));
    try {
      String line = br.readLine();
      while (line != null) {
        String[] words = line.split(",");
        this.set(words[0], words[1]);
        line = br.readLine();
      } // while
    } catch (IOException e) {
      // do nothing
    } // try-catch
  } // load(InputStream)
} // class BitTree
