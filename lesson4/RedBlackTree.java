package lesson4;

public class RedBlackTree {

        private Node root;

        private enum ColorNode {
            RED, BLACK
        }
       class Node {
            Node left, right;
            int value;
            ColorNode color;

            Node(int value) {
                this.value = value;
                left = null;
                right = null;
                color = ColorNode.RED;
            }

        }

        private Node rotateLeft (Node myNode){
        Node child = myNode.right;
        Node childLeft = child.left;
        child.left = myNode;
        myNode.right = childLeft;
        return child;
    }

        private Node rotateRight (Node myNode){
        Node child = myNode.left;
        Node childRight = child.right;
        child.right = myNode;
        myNode.left = childRight;
        return child;
    }

        private boolean isRed (Node myNode){
        return myNode != null && myNode.color.equals(ColorNode.RED);
    }

        private void swapColors (Node node1, Node node2){
        ColorNode temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

        public boolean add (int data){
        Node node;
        if (root != null) {
            node = add(root, data);
            if (node == null) {
                return false;
            }
        } else {
            node = new Node(data);
        }
        root = node;
        root.color = ColorNode.BLACK;
        return true;
    }

        private Node add (Node myNode, int data){
        if (myNode == null) {
            return new Node(data);
        }
        if (myNode.value > 0) {
            myNode.left = add(myNode.left, data);
        } else if (myNode.value < 0) {
            myNode.right = add(myNode.right, data);
        } else
            return null;
        return balanced(myNode);
    }

        private Node balanced (Node myNode){
        if (isRed(myNode.right) && !isRed(myNode.left)) {
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }

        if (isRed(myNode.left) && isRed(myNode.left.left)) {
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }

        if (isRed(myNode.left) && isRed(myNode.right)) {
            myNode.color = ColorNode.RED;
            myNode.left.color = ColorNode.BLACK;
            myNode.right.color = ColorNode.BLACK;
        }
        return myNode;
    }

        public void show () {
        show(root);
    }

        private void show (Node node){
        if (node != null) {
            show(node.left);
            System.out.print(node.value + " " + node.color + " | ");
            show(node.right);
        }
    }
}

