/**
 * Represents a node of an AVL Tree
 *
 * @author Bhavyai Gupta
 */
public class Node {
    public Object data;
    public int height;
    public Node left;
    public Node right;

    /**
     * Creates a new node with Object <code>o</code>
     *
     * @param o object that is to be stored in the Node
     */
    public Node(Object o) {
        this.data = o;
        this.height = 0;
        this.left = null;
        this.right = null;
    }
}
