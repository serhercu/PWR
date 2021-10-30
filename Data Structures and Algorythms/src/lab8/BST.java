package lab8;

import java.util.NoSuchElementException;

public class BST<T extends Comparable> {
    int size;
    public static String result;
    private T valueRem;

    private class Node{
        T value;
        Node left,right,parent;

        public Node(T v) {
            value=v;
        }
        public Node(T value, Node left, Node right, Node parent) {
            super();
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    private Node root=null;

    public BST() {
    }

    public T getElement(T toFind) {
        // TODO
        Node result = getElemRec(root, toFind);

        if (result == null) {
            return null;
        }
        return result.value;
    }

    private Node getElemRec(Node current, T value) {
        if (current == null) {
            return null;
        }
        if (value.equals(current.value)) {
            return current;
        }

        if (value.compareTo(current) < 0) {
            return getElemRec(current.left, value);
        } else {
            return getElemRec(current.right, value);
        }
    }


    public T successor(T elem) {
        // TODO
        Node successorNode = findSuccessorNodeRec(root, elem);

        if (successorNode == null) { return null;
        } else { return successorNode.value; }
    }

    private Node findSuccessorNodeRec(Node node, T elem) {
        if (node == null) {
            return null;
        }

        int aux = elem.compareTo(node.value);

        if (aux == 0) {
            if (node.right != null) {
                return getMin(node.right);
            } else {
                return null;
            }
        } else {
            if (aux < 0) {
                Node retNode = findSuccessorNodeRec(node.left, elem);
                if (retNode == null) { return node;
                } else return retNode;
            } else {
                return findSuccessorNodeRec(node.right, elem);
            }
        }
    }

    private Node getMin(Node current) {
        if (current.left == null) {
            return current;
        } else {
            return getMin(current.left);
        }
    }


    public String toStringInOrder() {
        // TODO
        result = "";
        shiftInOrder(root);
        return getResult();
    }

    public void shiftInOrder(Node node) {
        if (node != null) {
            shiftInOrder(node.left);
            result = result + node.value + ", ";
            shiftInOrder(node.right);
        }
    }

    public static String getResult() {
        if (result.length() == 0) {
            return result;
        }

        return result.substring(0, result.length() - 2);
    }

    public String toStringPreOrder() {
        // TODO
        result = "";
        shiftPreOrder(root);
        return getResult();
    }

    private void shiftPreOrder(Node node) {
        if (node != null) {
            result = result + node.value + ", ";
            shiftPreOrder(node.left);
            shiftPreOrder(node.right);
        }
    }

    public String toStringPostOrder() {
        // TODO
        result = "";
        shiftPostOrder(root);
        return getResult();
    }

    private void shiftPostOrder(Node node) {
        if (node != null) {
            shiftPostOrder(node.left);
            shiftPostOrder(node.right);
            result = result + node.value + ", ";
        }
    }


    public boolean add(T elem) {
        // TODO
        int prevSize = size;
        root = addRecursive(root, elem);

        if(prevSize == size) {
            return false;
        } else {
            return true;
        }
    }

    private Node addRecursive(Node current, T value) {
        if (current == null) {
            size++;
            return new Node(value);
        }

        if (current.value.compareTo(value) > 0) {
            current.left = addRecursive(current.left, value);
        } else {
            if (current.value.compareTo(value) < 0) {
                current.right = addRecursive(current.right, value);
            } else {
                return current;
            }
        }
        return current;
    }


    public T remove(T value) {
        // TODO
        valueRem = null;
        root = remove(value, root);
        return valueRem;
    }

    protected Node remove(T elem, Node node) {
        if (node == null) {
            return null;
        } else {
            int aux = elem.compareTo(node.value);
            if (aux < 0) {
                node.left = remove(elem, node.left);
            } else {
                if (aux > 0) {
                    node.right = remove(elem, node.right);
                } else {
                    if (node.left != null && node.right != null) {
                        node.right = separateMin(node, node.right);
                    } else {
                        valueRem = node.value;
                        node = (node.left != null) ? node.left : node.right;
                        size--;
                    }
                }
            }
        }
        return node;
    }

    private Node separateMin(Node del, Node node) {
        if (node.left != null) {
            node.left = separateMin(del, node.left);
        } else {
            size--;
            valueRem = del.value;
            del.value = node.value;
            node = node.right;
        }
        return node;
    }

    public void clear() {
        // TODO
        size = 0;
        root = null;
    }

    public int size() {
        // TODO
        return this.size;
    }

}