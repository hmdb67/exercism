import java.util.Collections;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            root.insert(value);
        }
    }

    //What if we just made one big git repo for all of your exercism stuff?
    //sure
    //It'll make it way easier each time we do a new exercise


    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        return Collections.emptyList();
    }

    Node<T> getRoot() {
        return root;

    }

    static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

        void insert(T insert) {
            if (this.getData().compareTo(insert) >= 0) {
                left = new Node<>(insert);
            } else {
                right = new Node<>(insert);
            }
        }


        private void insertNode(T value) {
            Node<T> node = new Node<>(value);


            //make new node
            //make root know that this is the left node
        }
    }
}
