package LinkedList.BasicLinkedList;

public class MiddleElement {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);

//        int ans=middleElement(head);
        int ans=middleElementEfficient(head);
        System.out.println(ans);
    }

    static int middleElement(Node head)
    {
        if(head==null)
            return -1;
        if(head.next==null)
            return head.data;
        int count=0;
        Node curr=head;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        curr=head;
        for(int i=0;i<count/2;i++)
        {
            curr=curr.next;
        }
        return curr.data;
    }

    static int middleElementEfficient(Node head)
    {
        if(head==null)
            return -1;
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}
