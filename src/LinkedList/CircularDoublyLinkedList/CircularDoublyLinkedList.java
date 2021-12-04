package LinkedList.CircularDoublyLinkedList;

public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        Node head=new Node(5);
//        head.prev=head;
//        head.next=head;
        Node temp1=new Node(10);
        Node temp2=new Node(20);
        temp2.next=head;
        temp2.prev=temp1;
        temp1.prev=head;
        head.prev=temp2;
        head.next=temp1;
        temp1.next=temp2;

        traverse(head);
        head=insertAtBegin(head,1);
        head=insertAtEnd(head,100);
        traverse(head);
    }

    static void traverse(Node head)
    {
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
            temp.prev=temp;
            return temp;
        }
        head.prev.next=temp;
        temp.prev=head.prev;
        temp.next=head;
        head.prev=temp;
        return temp;
    }

    static Node insertAtEnd(Node head,int x)
    {
        Node temp=new Node(x);
        if(head==null)
        {
            temp.next=temp;
            temp.prev=temp;
            return temp;
        }
        head.prev.next=temp;
        temp.prev=head.prev;
        temp.next=head;
        head.prev=temp;
        return head;
    }
}

class Node{
    int data;
    Node prev;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}
