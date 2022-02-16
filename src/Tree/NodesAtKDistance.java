package Tree;

public class NodesAtKDistance {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

        int k = 2;
        printK(root, k);
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
}
