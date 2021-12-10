package LinkedList.BasicLinkedList;

public class DeleteNodeWithRef {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(80);

        deleteNode(head.next.next);
        BasicLinkedList.traverse(head);
    }

    static void deleteNode(Node ref)
    {
        ref.data=ref.next.data;
        ref.next=ref.next.next;
    }
}
