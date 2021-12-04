package LinkedList.CircularLinkedList;

public class CircularLinkedList {
    public static void main(String[] args) {
        Node head=new Node(5);
//        head.next=head;
        head.next=new Node(10);
        head.next.next=new Node(20);
        head.next.next.next=new Node(40);
        head.next.next.next.next=head;

        traverse(head);
        head=insertAtBegin(head,1);
        traverse(head);
    }

    static void traverse(Node head)
    {
        if(head==null)
        {
            System.out.println("null");
            return;
        }
        Node curr=head;
        while(curr.next!=head)
        {
            System.out.print(curr.data+" -> ");
            curr=curr.next;
        }
        System.out.println(curr.data);
    }

    static Node insertAtBegin(Node head,int x)
    {
        Node temp=new Node(x);
        if(head==null)
        {
            temp.next=temp;
            return temp;
        }
        Node curr=head;
        while(curr.next!=head)
        {
            curr=curr.next;
        }
        curr.next=temp;
        temp.next=head;
        return temp;
    }
}

class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}
