class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;

    /**
     * Constructor
     *
     * @param value Value of the node
     */
    Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
