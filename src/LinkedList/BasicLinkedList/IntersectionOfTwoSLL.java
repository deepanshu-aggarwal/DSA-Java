package LinkedList.BasicLinkedList;

import java.util.HashSet;

public class IntersectionOfTwoSLL {
    public static void main(String[] args) {
        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(80);
        Node head2=new Node(30);
        head2.next=head.next.next;

        int data=intersectionPoint(head,head2);
        System.out.println(data);
    }

    static int intersectionPointHash(Node h1,Node h2)
    {
        HashSet<Integer> h=new HashSet<>();
        Node curr1=h1,curr2=h2;
        while(curr1!=null)
        {
            h.add(curr1.data);
            curr1=curr1.next;
        }
        while(curr2.next!=null)
        {
            if(h.contains(curr2.next.data))
                return curr2.next.data;
            else
                curr2=curr2.next;
        }
        return -1;
    }

    static int intersectionPoint(Node h1,Node h2)
    {
        Node curr1=h1,curr2=h2;
        int count1=0,count2=0;
        while(curr1!=null)
        {
            count1++;
            curr1=curr1.next;
        }
        while(curr2!=null)
        {
            count2++;
            curr2=curr2.next;
        }
        int count=Math.abs(count1-count2);
        curr1=h1;
        curr2=h2;
        if(count1>count2)
        {
            while(count!=0)
            {
                curr1=curr1.next;
                count--;
            }
        }
        else
        {
            while(count!=0)
            {
                curr2=curr2.next;
                count--;
            }
        }
        while(curr1!=null && curr2!=null)
        {
            curr1=curr1.next;
            curr2=curr2.next;
            if(curr1==curr2)
                return curr1.data;
        }
        return -1;
    }
}
