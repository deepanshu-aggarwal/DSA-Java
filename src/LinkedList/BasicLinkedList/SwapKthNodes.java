package LinkedList.BasicLinkedList;

public class SwapKthNodes {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
//        head.next.next.next=new Node(40);
//        head.next.next.next.next=new Node(80);
//        head.next.next.next.next.next=new Node(160);

        head=swapKthNode(head,3,4);
        BasicLinkedList.traverse(head);
    }

    static Node swapKthNode(Node head, int num, int k)
    {
        // your code here
        if(k>num)
            return head;

//        if(k==1)
//        {
//            Node temp2=head;
//            while(temp2.next.next!=null)
//                temp2=temp2.next;
//            Node temp=temp2.next;
//            temp.next=head.next;
//            temp2.next=head;
//            head.next=null;
//            return temp;
//        }

//        int count=0;
//        Node temp1=head,temp2=head;
//        for(int i=0;i<k-1;i++)
//        {
//            temp1=temp1.next;
//        }
//        for(int i=0;i<num-k-1;i++)
//        {
//            temp2=temp2.next;
//        }
//        Node tempa=temp2.next;
//        temp2.next=temp1.next;
//        Node tempb=temp1.next.next;
//        temp1.next.next=tempa.next;
//        temp1.next=tempa;
//        tempa.next=tempb;
//        return head;

        Node c1=head,c2=head,p1=null,p2=null;
        for(int i=0;i<k-1;i++)
        {
            p1=c1;
            c1=c1.next;
        }
        for(int i=0;i<num-k;i++)
        {
            p2=c2;
            c2=c2.next;
        }
        if(p1!=null)
        {
            p1.next=c2;
        }
        if(p2!=null)
        {
            p2.next=c1;
        }
        Node temp=c1.next;
        c1.next=c2.next;
        c2.next=temp;
        if(k==1)
        {
            head=c2;
        }
        if(k==num)
        {
            head=c1;
        }
        return head;
    }
}
