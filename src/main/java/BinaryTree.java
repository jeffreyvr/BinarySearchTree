public class BinaryTree {
    public Node root;

    /**
     * Insert a new node into the tree.
     * 
     * @param value
     */
    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;

        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                if (value < focusNode.value) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }

                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Find a node with focusNode as staring point.
     * 
     * @param focusNode
     * @param value
     * @return Node or null
     */
    public Node find(Node focusNode, int value) {
        if (focusNode == null) {
            return null;
        }

        if (focusNode.value == value) {
            return focusNode;

        } else {
            Node left   = find(focusNode.leftChild, value);
            Node right  = find(focusNode.rightChild, value);

            return left != null ? left : right;
        }
    }

    /**
     * Find the minimum value in the tree.
     * 
     * @param focusNode
     * @return Node or null
     */
    public Node findMin(Node focusNode) {
        if (focusNode == null) {
            return null;
        }

        if (focusNode.leftChild == null) {
            return focusNode;
        }
        
        return findMin(focusNode.leftChild);
    }

    /**
     * Find the maximum value in the tree.
     * 
     * @param focusNode
     * @return Node or null
     */
    public Node findMax(Node focusNode) {
        if (focusNode == null)
            return null;
        if (focusNode.rightChild == null) {
            return focusNode;
        } else {
            return findMax(focusNode.rightChild);
        }
    }
}