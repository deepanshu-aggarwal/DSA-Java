package LinkedList.BasicLinkedList;

public class RemoveDuplicatesSinglyLL {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(5);
        head.next.next=new Node(20);
        head.next.next.next=new Node(20);
        head.next.next.next.next=new Node(20);

        head=removeDuplicates(head);
        BasicLinkedList.traverse(head);
    }

    static Node removeDuplicates(Node head)
    {
        if(head==null)
            return null;
        Node curr=head;
        while(curr.next!=null)
        {
            if(curr.data==curr.next.data)
                curr.next=curr.next.next;
            else
                curr=curr.next;
        }
        return head;
    }
}
