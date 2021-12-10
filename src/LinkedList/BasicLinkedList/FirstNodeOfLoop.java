package LinkedList.BasicLinkedList;

public class FirstNodeOfLoop {
    public static void main(String[] args) {
        Node head=new Node(5);
//        head.next=new Node(10);
//        head.next.next=new Node(20);
//        head.next.next.next=new Node(40);
//        head.next.next.next.next=new Node(80);
        head.next=head;

        int data=firstNode(head);
        System.out.println(data);
    }

    static int firstNode(Node head)
    {
        Node slow=head.next,fast=head.next.next;
        while(fast!=slow)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        slow=head;
        while(slow!=fast)
        {
            fast=fast.next;
            slow=slow.next;
        }
        return slow.data;
    }
}
