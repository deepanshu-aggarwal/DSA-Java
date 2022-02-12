package Tree;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }

    public static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " -> ");
            inorder(root.right);
        }
    }

    public static void preorder(Node root) {
        if(root != null) {
            System.out.print(root.data + " -> ");
            inorder(root.left);
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if(root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.data + " -> ");
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
    }
}
