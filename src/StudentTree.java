/**
 * Stores the Student Nodes in a AVL Tree
 *
 * @author Bhavyai Gupta
 */
public class StudentTree {
    private Node root;
    private StringBuilder tempString;
    private NodeQueue tempQueue;

    /**
     * Creates an empty tree
     */
    public StudentTree() {
        this.root = null;
        this.tempString = null;
    }

    /**
     * Returns the height of the current Node
     *
     * @return height of the Node <b>curr</b>
     */
    public int getHeight(Node curr) {
        if (curr == null) {
            return -1;
        }

        else {
            return curr.height;
        }
    }

    /**
     * Clockwise rotate the AVL about Node curr
     *
     * @param curr the Node about which rotation is to be done
     * @return pointer to Node after rotation
     */
    public Node rotateRight(Node curr) {
        Node temp = curr.left;
        curr.left = temp.right;
        temp.right = curr;

        // not accessing height directly because there could be null nodes
        curr.height = 1 + Math.max(this.getHeight(curr.left), this.getHeight(curr.right));
        temp.height = 1 + Math.max(this.getHeight(temp.left), this.getHeight(temp.right));

        return temp;
    }

    /**
     * Anti-clockwise rotate the AVL about Node curr
     *
     * @param curr the Node about which rotation is to be done
     * @return pointer to Node after rotation
     */
    public Node rotateLeft(Node curr) {
        Node temp = curr.right;
        curr.right = temp.left;
        temp.left = curr;

        // not accessing height directly because there could be null nodes
        curr.height = 1 + Math.max(this.getHeight(curr.left), this.getHeight(curr.right));
        temp.height = 1 + Math.max(this.getHeight(temp.left), this.getHeight(temp.right));

        return temp;
    }

    /**
     * Left-Right rotation the AVL about Node curr
     *
     * @param curr the Node about which rotation is to be done
     * @return pointer to Node after rotation
     */
    public Node doubleRotateRight(Node curr) {
        curr.left = this.rotateLeft(curr.left);
        return this.rotateRight(curr);
    }

    /**
     * Right-Left rotation the AVL about Node curr
     *
     * @param curr the Node about which rotation is to be done
     * @return pointer to Node after rotation
     */
    public Node doubleRotateLeft(Node curr) {
        curr.right = this.rotateRight(curr.right);
        return this.rotateLeft(curr);
    }

    /**
     * Inserts a Student at appropriate position in the StudentTree
     *
     * @param s the Student to be inserted
     */
    public void insert(Student s) {
        this.root = this.insert(this.root, s);
    }

    /**
     * Actual method that inserts a Student at appropriate position in the
     * StudentTree
     *
     * @param curr the root node of the StudentTree
     * @param s    the Student to be inserted
     * @return the root node of the StudentTree
     */
    public Node insert(Node curr, Student s) {
        if (curr == null) {
            curr = new Node(s);
            curr.height = 1 + Math.max(this.getHeight(curr.left), this.getHeight(curr.right));
        }

        else if (s.compareTo((Student) curr.data) > 0) {
            curr.right = this.insert(curr.right, s);
            curr.height = 1 + Math.max(this.getHeight(curr.left), this.getHeight(curr.right));

            if (this.getHeight(curr.right) - this.getHeight(curr.left) == 2) {
                if (s.compareTo((Student) curr.right.data) > 0) {
                    curr = this.rotateLeft(curr);
                }

                else {
                    curr = this.doubleRotateLeft(curr);
                }
            }
        }

        else {
            curr.left = this.insert(curr.left, s);
            curr.height = 1 + Math.max(this.getHeight(curr.left), this.getHeight(curr.right));

            if (this.getHeight(curr.left) - this.getHeight(curr.right) == 2) {
                if (s.compareTo((Student) curr.left.data) < 0) {
                    curr = this.rotateRight(curr);
                }

                else {
                    curr = this.doubleRotateRight(curr);
                }
            }

        }

        // curr.height = 1 + Math.max(this.getHeight(curr.left), this.getHeight(curr.right));
        return curr;
    }

    /**
     * Traverses the tree in in-order fashion and returns the string representing
     * the tree
     *
     * @return in-order representation of the StudentTree
     */
    public String inOrder() {
        // reset the tempString
        this.tempString = new StringBuilder();
        this.tempString.append(Student.studentDivider());
        this.tempString.append(Student.studentHeader());
        this.tempString.append(Student.studentDivider());

        this.inOrder(this.root);

        this.tempString.append(Student.studentDivider());
        return this.tempString.toString();
    }

    /**
     * Actual method that traverses the tree in in-order fashion
     *
     * @param root the root node of the StudentTree
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        this.inOrder(root.left);
        this.tempString.append(((Student) root.data).toString()); // equivalent to System.out.println((Student)
                                                                  // root.data);
        this.inOrder(root.right);
    }

    /**
     * Traverses the tree in level-order fashion and returns the string representing
     * the tree
     *
     * @return level-order representation of the StudentTree
     */
    public String levelOrder() {
        // reset the tempString
        this.tempString = new StringBuilder();
        this.tempString.append(Student.studentDivider());
        this.tempString.append(Student.studentHeader());
        this.tempString.append(Student.studentDivider());

        // reset the tempQueue
        this.tempQueue = new NodeQueue();

        if (this.root != null) {
            this.tempQueue.enqueue((Node) this.root);
        }

        while (!this.tempQueue.isEmpty()) {
            Node curr = this.tempQueue.dequeue();
            this.tempString.append(curr.data.toString());

            if (curr.left != null) {
                this.tempQueue.enqueue((Node) curr.left);
            }

            if (curr.right != null) {
                this.tempQueue.enqueue((Node) curr.right);
            }
        }

        this.tempString.append(Student.studentDivider());
        return this.tempString.toString();
    }
}
