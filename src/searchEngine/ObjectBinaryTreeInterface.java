package searchEngine;


/**
 * Interface for ObjectBinaryTree Class
 * 
 * @author William A. Baires
 * @version 5/15/2020
 */
public interface ObjectBinaryTreeInterface
{
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
    public void insertBST(Object o);
    public void insertBSTDup(Object o);
    public ObjectTreeNode searchBST(Object o);
    public void preTrav(ObjectTreeNode tree);
    public void inTrav(ObjectTreeNode tree);
    public void postTrav(ObjectTreeNode tree);
    public void delete(Object o);
}
