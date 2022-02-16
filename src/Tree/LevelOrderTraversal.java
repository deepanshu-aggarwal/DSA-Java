package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

//        int k = heightOfBT(root);
//        for(int i = 0; i < k; i++) {
//            printK(root, i);
//            System.out.println();
//        }

        efficientLOT(root);
    }

    public static int heightOfBT(Node root) {
        if(root == null)
            return 0;
        else
            return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
    }

    public static void printK(Node root, int k) {
        if(root == null) {
            return;
        }
        if(k == 0) {
            System.out.print(root.data + " ");
        }
        else {
            printK(root.left, k-1);
            printK(root.right, k-1);
        }
    }


    public static void efficientLOT(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node ele = q.poll();
            System.out.println(ele.data);

            if(ele.left!=null)
                q.add(ele.left);

            if(ele.right!=null)
                q.add(ele.right);
        }
    }
}
