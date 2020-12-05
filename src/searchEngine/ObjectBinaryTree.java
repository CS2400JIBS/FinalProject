package searchEngine;


/**
 * ObjectBinaryTree Class for Binary Tree Data Structure of Type Object
 * 
 * @author William A. Baires
 * @version 5/15/2020
 */
public class ObjectBinaryTree implements ObjectBinaryTreeInterface {
    private ObjectTreeNode root;

    /**
     * ObjectBinaryTree Constructor.
     * Constructs an empty binary search tree
     */
    public ObjectBinaryTree() {
        root = null;
    }

    /**
     * Returns the root node of the binary search tree
     * 
     * @return the root node of the tree
     */ 
    public ObjectTreeNode getRoot() {
        return root;
    }

    /**
     * Sets the left child node of another node in the Binary Search Tree
     * 
     * @param parent the parent node that will have its left child set
     * @param r the node that will be set as the left child of the parent node
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild()");
            System.exit(1);
        }
        parent.setLeft(r);
    }

    /**
     * Sets the right child node of another node in the Binary Search Tree
     * 
     * @param parent the parent node that will have its right child set
     * @param r the node that will be set as the right child of the parent node
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setRightChild()");
            System.exit(1);
        }
        parent.setRight(r);
    }

    /**
     * Inserts an object into a node on the Binary Search Tree.
     * 
     * @param o the Object that will be inserted into the tree
     */
    public void insertBST(Object o) {
        ObjectTreeNode p, q;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) < 0 )
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) < 0)
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }

    /**
     * Inserts an object into a node on the Binary Search Tree.
     * Chains duplicate node occurrences along the linear linked list that exists on each tree node.
     * 
     * @param o the Object that will be inserted into the tree
     */
    public void insertBSTDup(Object o) {
        ObjectTreeNode p, q;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null && ((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) != 0) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) < 0)
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) < 0)
                setLeftChild(p, r);
            else if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) > 0)
                setRightChild(p, r);
            else ((TreeComparable)(p.getInfo())).operate(r.getInfo());
        }
    }

    /**
     * Searches for an object in the nodes of the Binary Search Tree
     * 
     * @param o the Object that will be inserted into the tree
     * @return a null tree node
     */
    public ObjectTreeNode searchBST(Object o) {
        ObjectTreeNode p;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if(root != null) {
            p = root;
            while (p != null) {
                if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) < 0)
                    p = p.getLeft();
                else if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) > 0)
                    p = p.getRight();
                else 
                    return p;
            }
        }
        return null;
    }

    /**
     * Traverses the Binary Search Tree in Pre-Order sequence
     * 
     * @param tree the Binary Search Tree that will be traversed
     */
    public void preTrav(ObjectTreeNode tree) {
        if (tree != null) {
            ((TreeComparable)tree.getInfo()).visit();
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }

    /**
     * Traverses the Binary Search Tree in In-Order sequence
     * 
     * @param tree the Binary Search Tree that will be traversed
     */
    public void inTrav(ObjectTreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            ((TreeComparable)tree.getInfo()).visit();
            inTrav(tree.getRight());
        }
    }

    /**
     * Traverses the Binary Search Tree in Post-Order
     * 
     * @param tree the Binary Search Tree that will be traversed
     */
    public void postTrav(ObjectTreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            ((TreeComparable)tree.getInfo()).visit();
        }
    }

    /**
     * Deletes a node from the Binary Search Tree
     * 
     * @param o the Object that will be searched for and deleted from the tree
     */
    public void delete(Object o) {
        ObjectTreeNode s, t, v;
        boolean found = false;

        ObjectTreeNode r = new ObjectTreeNode(o);
        ObjectTreeNode p = root;
        ObjectTreeNode q = null;
        // Search for the node with info key, set p to point to that node and set q to point to its parent, if any.
        while (p != null && !found) {
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) == 0)
                found = true;
            else {
                q = p;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else
                    p = p.getRight();
            }
        }
        if (found) {
            // Set v to point to the node that will replace the node 
            // that p points to.
            if (p.getLeft() == null)
                v = p.getRight();
            else if (p.getRight() == null)
                v = p.getLeft();
            else {
                // the node that p points to has two children;
                // set v to the inorder successor of p;
                // set t to the parent of v
                t = p;
                v = p.getRight();
                s = v.getLeft();  // s is the left child of v
                while (s != null) {
                    t = v;
                    v = s;
                    s = v.getLeft();
                }
                // At this point, v is the inorder successor of p
                if (t != p) {
                    // p is not the parent of v and v = t.getLeft()
                    t.setLeft(v.getRight());
                    // Remove the node that v points to from its
                    // current position to take the place of the 
                    // node that p points to.
                    v.setRight(p.getRight());
                }
                v.setLeft(p.getLeft());
            }
            // Insert the node that v points to into the position
            // formally occupied by the node that p points to
            if (q == null)
            // The node that p points to was the root of the tree
                root = v;
            else if (p == q.getLeft())
                q.setLeft(v);
            else q.setRight(v);
        }
    }
}
