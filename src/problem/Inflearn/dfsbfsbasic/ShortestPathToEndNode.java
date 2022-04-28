package problem.Inflearn.dfsbfsbasic;

import java.util.*;

// DFS
public class ShortestPathToEndNode {

    static class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
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
        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);

        int count = -1;
        List<Integer> lengthList = new ArrayList<>();
        dfs(node1, count, lengthList);
        System.out.println(lengthList.stream().min(Comparator.naturalOrder()).get());

        var shortestPathLength = dfs2(0, node1);
        System.out.println(shortestPathLength);

        shortestPathLength = bfs(node1);
        System.out.println(shortestPathLength);
    }

    private static void dfs(Node node, int count, List<Integer> lengthList) {
        if (node.leftNode != null) dfs(node.leftNode, count + 1, lengthList);
        if (node.rightNode != null) dfs(node.rightNode, count + 1, lengthList);
        if (node.leftNode == null && node.rightNode == null) lengthList.add(count + 1);
    }

    private static int dfs2(int level, Node node) {
        if (node.getLeftNode() == null && node.getRightNode() == null) return level;
        else return Math.min(dfs2(level + 1, node.getLeftNode()), dfs2(level + 1, node.getRightNode()));
    }

    private static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = -1;
        while (!queue.isEmpty()) {
            var size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                var poll = queue.poll();
                if (poll.getRightNode() != null) queue.offer(poll.getRightNode());
                if (poll.getLeftNode() != null) queue.offer(poll.getLeftNode());

                if (poll.getLeftNode() == null && poll.getRightNode() == null) return level;
            }
        }

        return level;
    }
}
