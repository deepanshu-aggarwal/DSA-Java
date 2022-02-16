package Tree;

public class MaxElementInBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

        System.out.println(findMax(root));
    }

    public static int findMax(Node root) {
        if(root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }
}
