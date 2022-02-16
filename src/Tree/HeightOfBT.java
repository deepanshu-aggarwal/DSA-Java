package Tree;

public class HeightOfBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.left.right = new Node(60);

        System.out.println(heightOfBT(root));
    }

    public static int heightOfBT(Node root) {
        if(root == null)
            return 0;
        else
            return Math.max(heightOfBT(root.left), heightOfBT(root.right)) + 1;
    }
}
