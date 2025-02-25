package tree;


import base.Node;

import java.util.LinkedList;
import java.util.Queue;

class Q116_node_connect {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node cur = queue.poll();
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);

            for (int i = 1; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                cur.next = node;
                cur = node;
            }
        }
        return root;
    }
}