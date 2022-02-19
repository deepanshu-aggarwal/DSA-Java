package Tree;

public class CheckBalancedBT {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(12);
        root.right = new Node(8);
        root.left.left = new Node(12);
        root.right.left = new Node(5);
        root.right.right = new Node(3);
        root.right.left.right = new Node(5);

        System.out.println(checkBalanced(root) != -1);
    }

    public static int checkBalanced(Node root) {
        if(root == null)
            return 0;

        int lh = checkBalanced(root.left);
        if(lh == -1)    return -1;
        int rh = checkBalanced(root.right);
        if(rh == -1)    return -1;

        if(Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }
}