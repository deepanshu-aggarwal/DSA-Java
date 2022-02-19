package Tree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(12);
        root.right = new Node(8);
        root.left.left = new Node(12);
        root.right.left = new Node(5);
        root.right.right = new Node(3);
        root.right.left.right = new Node(5);

        System.out.println(isSum(root));
    }

    public static boolean isSum(Node root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        int sum = 0;
        if(root.left != null)   sum += root.left.data;
        if(root.right != null)   sum += root.right.data;

        return sum == root.data && isSum(root.left) && isSum(root.right);
    }
}
