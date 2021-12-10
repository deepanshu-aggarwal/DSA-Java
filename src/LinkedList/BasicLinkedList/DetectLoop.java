package LinkedList.BasicLinkedList;

import java.util.HashSet;

public class DetectLoop {
    public static void main(String[] args) {
//        NodeB head=new NodeB(5);
//        head.next=new NodeB(10);
//        head.next.next=new NodeB(20);
//        head.next.next.next=new NodeB(40);
//        head.next.next.next.next=new NodeB(80);
//        head.next.next.next.next=head.next.next;

        Node head=new Node(5);
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(80);
        head.next.next.next.next.next=head.next.next;

//        Boolean loop=detectLoop(head);
//        Boolean loop=detectLoopUsingDummy(head);
//        Boolean loop=detectLoopUsingHash(head);
//        Boolean loop=floydCycleDetection(head);
        detectAndRemoveLoop(head);
        BasicLinkedList.traverse(head);
    }

    static Boolean detectLoop(NodeB head)
    {
        NodeB curr=head;
        while(curr!=null)
        {
            if(curr.visited)
                return true;
            else
                curr.visited=true;
            curr=curr.next;
        }
        return false;
    }

    static Boolean detectLoopUsingDummy(Node head)
    {
        Node temp=new Node(-1);
        Node curr=head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.next==temp)
                return true;
            Node curr_next=curr.next;
            curr.next=temp;
            curr=curr_next;
        }
        return false;
    }

    static Boolean detectLoopUsingHash(Node head)
    {
        HashSet<Integer> h=new HashSet<>();
        Node curr=head;
        while(curr!=null)
        {
            if(h.contains(curr.data))
                return true;
            h.add(curr.data);
            curr=curr.next;
        }
        return false;
    }

    static Boolean floydCycleDetection(Node head)
    {
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    static void detectAndRemoveLoop(Node head)
    {
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        if(slow!=fast)
            return;
        slow=head;
        while(slow.next!=fast.next)
        {
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }
}

class NodeB{
    int data;
    NodeB next;
    Boolean visited;
    NodeB(int data)
    {
        this.data=data;
        next=null;
        visited=false;
    }
}
