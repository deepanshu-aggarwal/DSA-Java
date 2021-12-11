package LinkedList.BasicLinkedList;

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        Node head1=new Node(5);
        head1.next=new Node(10);
        head1.next.next=new Node(20);
        head1.next.next.next=new Node(40);

        Node head2=new Node(15);
        head2.next=new Node(30);
        head2.next.next=new Node(35);
        head2.next.next.next=new Node(45);
        head2.next.next.next.next=new Node(80);

        Node head=merge(head1,head2);
        BasicLinkedList.traverse(head);
    }

    static Node merge(Node a,Node b)
    {
        if(a==null) return b;
        if(b==null) return a;
        Node head=null,tail=null;
        if(a.data<b.data)
        {
            head=a;
            tail=a;
            a=a.next;
        }
        else
        {
            head=b;
            tail=b;
            b=b.next;
        }
        while(a!=null && b.next!=null)
        {
            if(a.data<b.data)
            {
                tail.next=a;
                tail=a;
                a=a.next;
            }
            else
            {
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if(b==null)
            tail.next=a;
        else
            tail.next=b;
        return head;
    }
}
