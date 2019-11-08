import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BasicTest {
    public BinaryTree tree = new BinaryTree();

    /**
     * Setting up a graph for testing.
     */
    public void setup() {
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);
    }

    @Test
    public void test_should_find_node() {
        this.setup();

        assertEquals(tree.find(tree.root, 4).toString(), "4");
    }

    @Test
    public void test_should_return_null_on_looking_for_non_existing_node() {
        this.setup();

        assertNull(tree.find(tree.root, 99));
    }

    @Test
    public void test_should_return_correct_min_in_tree() {
        this.setup();

        assertEquals(this.tree.findMin(this.tree.root).value, 1);
    }

    @Test
    public void test_should_return_correct_max_in_tree() {
        this.setup();

        assertEquals(this.tree.findMax(this.tree.root).value, 9);
    }

    @Test
    public void test_assert_that_node_exists_after_creating() {
        BinaryTree tree = new BinaryTree();

        tree.insert(100);

        assertEquals(tree.find(tree.root,100).value, 100);
    }

    @Test
    public void test_assert_removal_works_as_correctly() {
        this.setup();

        tree.remove(4);

        assertNull(tree.find(tree.root, 4));
        assertNull(tree.find(tree.root, 6).leftChild);

        tree.remove(2);

        assertEquals(tree.root.value, 6);
    }

}