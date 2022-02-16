package Tree;

public class SizeOfBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

        System.out.println(sizeOFBT(root));
    }

    public static int sizeOFBT(Node root) {
        if(root == null)
            return 0;
        return sizeOFBT(root.left) + sizeOFBT(root.right) + 1;
    }
}
