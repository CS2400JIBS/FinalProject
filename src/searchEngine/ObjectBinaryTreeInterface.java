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
    public void insertBST(Word o);
    public void insertBSTDup(Word o);
    public Word searchBST(Word o);
    public void preTrav(ObjectTreeNode tree);
    public void inTrav(ObjectTreeNode tree);
    public void postTrav(ObjectTreeNode tree);
    public void delete(Word o);
}
