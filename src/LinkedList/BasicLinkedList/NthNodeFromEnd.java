package LinkedList.BasicLinkedList;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);

        int data=nthNodeEnd(head,4);
        System.out.println(data);
    }

    static int nthNodeEnd(Node head, int k)
    {
        if(head==null)
            return -1;
        int n=0;
        Node curr=head;
        while(curr!=null)
        {
            curr=curr.next;
            n++;
        }
        if(n-k<0)
            return -1;
        curr=head;
        for(int i=0;i<n-k;i++)
        {
            curr=curr.next;
        }
        return curr.data;
    }
}
