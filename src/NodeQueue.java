/**
 * Stores the Nodes in a queue
 *
 * @author Bhavyai Gupta
 */
public class NodeQueue {
    private Node front;
    private Node rear;

    /**
     * Creates an empty queue
     */
    public NodeQueue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * Enqueues an item at rear of the queue
     *
     * @param s the Student to be enqueued
     */
    public void enqueue(Node n) {
        if (this.isEmpty()) {
            this.front = new Node(n);
            this.rear = this.front;
        }

        else {
            this.rear.right = new Node(n);
            this.rear = this.rear.right;
        }
    }

    /**
     * Dequeues an item from the front of the queue
     *
     * @return the Student to be dequeued
     */
    public Node dequeue() {
        if (this.isEmpty()) {
            return null;
        }

        else {
            Node n = (Node) this.front.data;
            this.front = this.front.right;
            return n;
        }
    }

    /**
     * Checks if the queue is empty
     *
     * @return <code>true</code> if the queue is empty, <code>false</code> otherwise
     */
    public boolean isEmpty() {
        return (this.front == null);
    }
}
