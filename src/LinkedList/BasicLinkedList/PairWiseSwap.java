package LinkedList.BasicLinkedList;

public class PairWiseSwap {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(80);
        head.next.next.next.next.next=new Node(160);

        swap(head);
        BasicLinkedList.traverse(head);
    }

    static void swap(Node head)
    {
        Node curr=head;
        while(curr!=null && curr.next!=null)
        {
            int temp=curr.data;
            curr.data=curr.next.data;
            curr.next.data=temp;
            curr=curr.next.next;
        }
    }
}
