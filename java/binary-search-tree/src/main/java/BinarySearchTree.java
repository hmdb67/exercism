import java.util.*;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            root.insert(value);
        }
    }


    List<T> getAsSortedList() {
        //Reccomend looking at a recursive solution
        List<T> returnedList = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();

        stack.push(root);

        Node<T> current = root;

        while (!stack.empty()) {
            while (current != null) {
                current = current.visitLeft(stack);
            }

            current = stack.pop();

            returnedList.add(current.getData());

            current = current.visitRight(stack);
        }

        return returnedList;
    }


    List<T> getAsLevelOrderList() {
        List<T> returnedList = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> element = queue.poll();

            returnedList.add(element.getData());

            if (element.getLeft() != null) {
                queue.add(element.getLeft());
            }

            if (element.right != null) {
                queue.add(element.getRight());
            }
        }


        return returnedList;
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


        private Node<T> visitLeft(Stack<Node<T>> stack) {
            if (left != null) {
                stack.push(left);
            }

            return left;
        }

        private Node<T> visitRight(Stack<Node<T>> stack) {
            if (right != null) {
                stack.push(right);
            }

            return right;
        }

        void insert(T insert) {
            if (this.getData().compareTo(insert) >= 0) {
                if (left == null) {
                    left = new Node<>(insert);
                } else {
                    left.insert(insert);
                }
            } else {
                if (right == null) {
                    right = new Node<>(insert);
                } else {
                    right.insert(insert);
                }
            }
        }
    }
}
