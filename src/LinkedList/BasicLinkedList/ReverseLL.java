package LinkedList.BasicLinkedList;

public class ReverseLL {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(80);

//        head=reverseLLIterative(head);
//        head=reverseLLRecursive(head);
        head=reverseLLRecursiveII(null,head);
        BasicLinkedList.traverse(head);
    }

    static Node reverseLLIterative(Node head)
    {
        if(head==null || head.next==null)
            return head;
        Node curr=head,temp=head.next,prev=null;
        while(curr!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=temp;
            if(temp!=null)
                temp=temp.next;
        }
        return prev;
    }

    static Node reverseLLRecursive(Node head)
    {
        if(head==null || head.next==null)
            return head;
        Node newHead=reverseLLRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    static Node reverseLLRecursiveII(Node prev,Node curr)
    {
        if(curr==null)
            return prev;
        Node next=curr.next;
        curr.next=prev;
        return reverseLLRecursiveII(curr,next);
    }
}
