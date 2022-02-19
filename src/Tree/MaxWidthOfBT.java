package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

        System.out.println(width(root));
    }

    public static int width(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()) {
            int count = q.size();
            ans = Math.max(ans, count);
            for(int i=0; i<count; i++) {
                Node curr = q.poll();
                if(curr.left != null)   q.add(curr.left);
                if(curr.right != null)   q.add(curr.right);
            }
        }
        return ans;
    }
}
