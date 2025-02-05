package searchEngine;


/**
 * ObjectTreeNode Class for nodes of the ObjectBinaryTree Class
 * 
 * @author William A. Baires
 * @version 5/15/2020
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Word info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * ObjectTreeNode Default Constructor
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**
     * Single argument ObjectTreeNode Constructor
     * 
     * @param o Word information that will be set to the node
     */
    public ObjectTreeNode (Word o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**
     * Sets the information of Word on the tree node
     * 
     * @param o Word information that will be set to the node
     */
    public void setInfo(Word o) {
        info = o;
    }
    
    /**
     * Returns the information of the Word on the tree node
     * 
     * @return The Word information set to the node
     */
    public Word getInfo() {
        return info;
    }
    
    /**
     * Sets the left child node of the tree node
     * 
     * @param  p the node that will be set as the left child
     */ 
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**
     * Returns the tree node's left child node
     * 
     * @return the information set on the left child of the current node
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**
     * Sets the right child of the tree node
     * 
     * @param  p the node that will be set as the right child
     */ 
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**
     * Returns the tree node's right child node
     * 
     * @return the information set on the right child of the current node
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}