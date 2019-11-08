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
     * Find a node with focusNode as starting point.
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

    /**
     * Remove node
     *
     * @param key key of the node to remove
     * @return true or false
     */
    public boolean remove(Integer key) {
        Node focusNode          = root;
        Node parent             = root;
        boolean isItALeftChild  = true;

        while (focusNode.value != key) {
            parent = focusNode;

            if (key < focusNode.value) {
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            // Node has not been found
            if (focusNode == null) {
                return false;
            }
        }

        if ((focusNode.leftChild == null && focusNode.rightChild == null)) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (focusNode.rightChild == null) {
            if(focusNode == root) {
                root = focusNode.leftChild;
            } else if(isItALeftChild) {
                parent.leftChild=focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else {
            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isItALeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
                replacement.leftChild = focusNode.leftChild;
            }
        }

        return true;
    }

    /**
     * Get Replacement Node
     *
     * @param replacedNode Node to replace
     * @return replacement node
     */
    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent  = replacedNode;
        Node replacement        = replacedNode;
        Node focusNode          = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }
}