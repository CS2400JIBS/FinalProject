package searchEngine;

public class BinarySearchTree {
    
    private static class BinaryNode {
      private Word word;
      private BinaryNode left;
      private BinaryNode right;
    
    
    /** 
      * constructor to build a node with no subtrees
      * @param the value to be stored by this node
      */
      private BinaryNode(Word value) {
        this.word = value;
        left = null;
        right = null;
      }
    
    
    /** 
      * constructor to build a node with a specified (perhaps null) subtrees
      * @param the value to be stored by this node
      * @param the left subtree for this node
      * @param the right subtree for this node
      */
      private BinaryNode(Word value, BinaryNode l, BinaryNode r) {
        this.word = value;
        left = l;
        right = r;
      }
      
      public Word getWord() {
			return word;
		}
      
      public void setWord(Word word) {
			this.word = word;
		}
      
      
    }

    /* the root of the tree is the only data field needed */
    protected BinaryNode root = null; // null when tree is empty
    protected int size;

    /* constructs an empty tree
     */
    public BinarySearchTree() {
    	super();
    }

    /* constructs a tree with one element, as given
     * @param	value to be used for the one element in the tree
     */
    public BinarySearchTree(Word value) {
		super();
		root = new BinaryNode(value);
    }

    /* constructs a tree with the given node as root
     * @param	newRoot to be used as the root of the new tree
     */
    public BinarySearchTree(BinaryNode newRoot) {
		super();
		root = newRoot;
    }

    /* find a value in the tree
     * @param	key identifies the node value desired
     * @return	the node value found, or null if not found
     */
    public Word get(Word key) {
		BinaryNode node = root;
		while (node != null) {
		    if (key.getWord().compareTo(node.getWord().getWord()) == 0) {
			return node.word;
		    }
		    if (key.getWord().compareTo(node.getWord().getWord()) < 0) {
			node = node.left;
		    } else {
			node = node.right;
		    }
		}
		return null;
    }

    /* add a value to the tree, replacing an existing value if necessary
     * @param	value to be inserted
     */
    public void add(Word value) {
    	root = add(value, root);
    	size++;
    }

    /* add a value to the tree, replacing an existing value if necessary
     * @param	value to be inserted
     * @param	node that is the root of the subtree in which to insert
     * @return	the subtree with the node inserted
     */
    protected BinaryNode add(Word value, BinaryNode node) {
    	if (node == null) {
		    return new BinaryNode(value);
		}
		
		if (value.getWord().compareTo(node.getWord().getWord()) == 0) {
		    // replace the value in this node with a new value
		    //node.word = value;
			
		    // alternative code creates new node, leaves old node unchanged:
		    //return new BinaryNode<Word>(value, node.left, node.right);
		} 
		
		else {
		    if (value.getWord().compareTo(node.getWord().getWord()) < 0) {	// add to left subtree
			node.left = add(value, node.left);
		    } else {		// add to right subtree
			node.right = add(value, node.right);
		    }
		}
		return node;
    }
    

}