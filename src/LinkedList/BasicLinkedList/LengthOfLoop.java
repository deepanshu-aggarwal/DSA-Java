package LinkedList.BasicLinkedList;

public class LengthOfLoop {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(80);
        head.next.next.next.next.next=head;

        int length=lengthOfLoop(head);
        System.out.println(length);
    }

    static int lengthOfLoop(Node head)
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
        int count=1;
        fast=fast.next;
        while(slow!=fast)
        {
            fast=fast.next;
            count++;
        }
        return count;
    }
}
