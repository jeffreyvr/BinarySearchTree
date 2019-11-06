public class Main {
    public static void main(String[] args) {
        (new Main()).example();
    }

    /**
     * An example of a BST.
     */
    public void example() {
        BinaryTree tree = new BinaryTree();

        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);

        System.out.println("Found: " + tree.find(tree.root, 4));
        System.out.println("The minimum value: " + tree.findMin(tree.root));
        System.out.println("The maximum value: " + tree.findMax(tree.root));
    }
}