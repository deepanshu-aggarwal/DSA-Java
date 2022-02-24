package Tree;

public class BTtoDLL {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(70);
        root.right.left.right = new Node(60);

        Node head = convert(root);
        Node curr = head;
        while(curr.right != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.right;
        }
        System.out.print(curr.data + " -> ");
        System.out.print("null");
        System.out.println();
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.left;
        }
        System.out.print("null");
    }

    public static Node prev = null;
    public static Node convert(Node root) {
        if(root == null)
            return null;
        Node head = convert(root.left);
        if(prev == null)
            head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convert(root.right);
        return head;
    }
}
