package problem.Inflearn.dfsbfsbasic;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS {
    static class Node {
        private int value;
        private Node leftNode;
        private Node rightNode;


        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
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

        node1.leftNode = node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode = node6;
        node3.rightNode = node7;

        bfs(node1);
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while(!queue.isEmpty()) {
            int length = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < length; i ++) {
                Node cursor = queue.poll();
                System.out.print(cursor.getValue() + " ");
                if (cursor.leftNode != null) queue.offer(cursor.leftNode);
                if (cursor.rightNode != null) queue.offer(cursor.rightNode);
            }
            level++;
            System.out.println();
        }
    }
}
