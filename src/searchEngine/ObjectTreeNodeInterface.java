package searchEngine;


/**
 * Interface for ObjectTreeNode Class
 * 
 * @author William A. Baires
 * @version 5/15/2020
 */
public interface ObjectTreeNodeInterface
{
    public Word getInfo();
    public void setLeft(ObjectTreeNode p);
    public ObjectTreeNode getLeft();
    public void setRight(ObjectTreeNode p);
    public ObjectTreeNode getRight();
}
