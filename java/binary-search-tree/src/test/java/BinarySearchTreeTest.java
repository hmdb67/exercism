import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class BinarySearchTreeTest {

    @Test
    public void dataIsRetained() {


        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        int expected = 4;
        binarySearchTree.insert(expected);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);

        int actual = root.getData();
        assertEquals(expected, actual);
    }


    @Test
    public void rightNowRootIsOverwritten() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(4);
        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        int data = root.getData();
        assertEquals(data, 4);

        binarySearchTree.insert(2);
        root = binarySearchTree.getRoot();
        int rootData2 = root.getData();
        assertEquals(rootData2, 4);
    }


    @Test
    public void insertsLess() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        char expectedRoot = '4';
        char expectedLeft = '2';

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<Character> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Character> left = root.getLeft();
        assertNotNull(left);

        char actualRoot = root.getData();
        char actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void insertsSame() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        String expectedRoot = "4";
        String expectedLeft = "4";

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<String> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<String> left = root.getLeft();
        assertNotNull(left);

        String actualRoot = root.getData();
        String actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void insertsRight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int expectedRoot = 4;
        int expectedRight = 5;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRight);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        BinarySearchTree.Node<Integer> right = root.getRight();
        assertNotNull(right);

        int actualRoot = root.getData();
        int actualRight = right.getData();
        assertEquals(expectedRight, actualRight);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    public void addsStuffToNodesWhenRootIsFull() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);

        binarySearchTree.insert(1);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertThat(root.getData()).isEqualTo(4);

        BinarySearchTree.Node<Integer> firstLeft = root.getLeft();
        assertThat(firstLeft.getData()).isEqualTo(2);

        BinarySearchTree.Node<Integer> lastLeft = firstLeft.getLeft();
        assertThat(lastLeft.getData()).isEqualTo(1);

    }

    @Test
    public void addsStuffToLargeNodesWhenRootIsFull() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);

        binarySearchTree.insert(7);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertThat(root.getData()).isEqualTo(4);

        BinarySearchTree.Node<Integer> firstRight = root.getRight();
        assertThat(firstRight.getData()).isEqualTo(6);

        BinarySearchTree.Node<Integer> lastRight = firstRight.getRight();
        assertThat(lastRight.getData()).isEqualTo(7);

    }

    @Test
    public void createsComplexTreeNaive() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6', '1', '3', '5', '7')
        );

        List<Character> treeData = Collections.unmodifiableList(
                Arrays.asList('4', '2', '6', '1', '3', '5', '7')
        );

        treeData.forEach(binarySearchTree::insert);

        List<Character> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);
    }


    @Test
    public void createsComplexTree() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('4', '2', '6', '1', '3', '5', '7');

        binarySearchTree.insert('4');
        binarySearchTree.insert('6');
        binarySearchTree.insert('2');
        binarySearchTree.insert('7');
        binarySearchTree.insert('3');
        binarySearchTree.insert('1');
        binarySearchTree.insert('5');

        List<Character> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);
    }


    @Test
    public void traversesLittleTree() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('4', '2', '6');

        binarySearchTree.insert('4');
        binarySearchTree.insert('6');
        binarySearchTree.insert('2');

        List<Character> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);

    }
    //

    // Retunred list ->  4, 2, 6, 1, 3, 5, 7

    //Q ->


    //      4
    //     / \
    //    2   6
    //   /\   /\
    //  1  3 5  7

    //      4
    //     / \
    //    2   6
    //   /\   /\
    //  1  3 5  7

    //      4
    //     / \
    //    2   6
    //   /    /\
    //  1    5  7
    //    \--/


    // TODO - Add A bunch of elements to the tree
    // TODO - return them in the same order
    // TODO - be able to traver a little tree

    @Test
    public void sortsSingleElement() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.unmodifiableList(
                Collections.singletonList("2")
        );

        binarySearchTree.insert("2");

        List<String> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        List<Integer> expected = List.of(1, 2);

        binarySearchTree.insert(2);
        binarySearchTree.insert(1);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    public void sortsCollectionOfTwoIfSecondNumberisSameAsFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('2', '2');

        binarySearchTree.insert('2');
        binarySearchTree.insert('2');

        List<Character> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('2', '3');

        binarySearchTree.insert('2');
        binarySearchTree.insert('3');

        List<Character> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    public void iteratesOverComplexTree() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

        List<String> expected = List.of("1", "2", "3", "5", "6", "7");
        List<String> treeData = List.of("2", "1", "3", "6", "7", "5");

        treeData.forEach(binarySearchTree::insert);

        List<String> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    public void bigAssTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        List<Integer> expected = List.of(1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        List<Integer> treeData = List.of(12, 17, 18, 19, 16, 1, 2, 7, 8, 9, 10, 14, 15, 11, 3, 5, 20, 13, 6);
        treeData.forEach(binarySearchTree::insert);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }
}
