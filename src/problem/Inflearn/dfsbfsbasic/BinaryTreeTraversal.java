package problem.Inflearn.dfsbfsbasic;

public class BinaryTreeTraversal {

    static class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
        }

        public void setLeftNode(Node node) {
            this.leftNode = node;
        }

        public void setRightNode(Node node) {
            this.rightNode = node;
        }

        public int getData() {
            return this.data;
        }

        public Node getLeftNode() {
            return this.leftNode;
        }

        public Node getRightNode() {
            return this.rightNode;
        }
    }

    public static void main(String[] args) {
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        var node5 = new Node(5);
        var node6 = new Node(6);
        var node7 = new Node(7);

        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node3.setLeftNode(node6);
        node3.setRightNode(node7);

        // Root -> left -> right
        printPreOrder(node1);
        System.out.println();

        // Left -> root -> right
        printInOrder(node1);
        System.out.println();

        // Left -> right -> root
        printPostOrder(node1);
    }

    private static void printPostOrder(Node node) {
        if (node.getLeftNode() != null) printPostOrder(node.getLeftNode());
        if (node.getRightNode() != null) printPostOrder(node.getRightNode());
        System.out.print(node.getData() + " ");
    }


    private static void printInOrder(Node node) {
        if (node.getLeftNode() != null) printInOrder(node.getLeftNode());
        System.out.print(node.getData() + " ");
        if (node.getRightNode() != null) printInOrder(node.getRightNode());
    }

    private static void printPreOrder(Node node) {
        System.out.print(node.getData() + " ");
        if (node.getLeftNode() != null) printPreOrder(node.getLeftNode());
        if (node.getRightNode() != null) printPreOrder(node.getRightNode());
    }
}
