package Tree;

public class LeftViewOfBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

        leftView(root, 1);
        System.out.println("null");
    }

    public static int maxLevel = 0;
    public static void leftView(Node root, int level) {
        if(root == null)
            return;
        if(level > maxLevel) {
            System.out.print(root.data + " -> ");
            maxLevel = level;
        }
        leftView(root.left, level+1);
        leftView(root.right, level+1);
    }
}
