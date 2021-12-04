package LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);
        head.next=temp1;
        temp1.next=temp2;
        temp2.prev=temp1;
        temp1.prev=head;

        traverse(head);
//        head=insertAtBegin(head,100);
//        head=insertAtEnd(head,1000);
//        head=reverseDLL(head);
//        head=deleteAtBegin(head);
        head=deleteAtEnd(head);
        traverse(head);
    }

    static void traverse(Node head)
    {
        Node curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data+" -> ");
            curr=curr.next;
        }
        System.out.println("null");
    }

    static Node insertAtBegin(Node head,int x)
    {
        Node temp=new Node(x);
        temp.next=head;
        if(head!=null)
            head.prev=temp;
        return temp;
    }

    static Node insertAtEnd(Node head,int x)
    {
        Node temp=new Node(x);
        if(head==null)
            return temp;
        Node curr=head;
        while(curr.next!=null)
            curr=curr.next;
        curr.next=temp;
        temp.prev=curr;
        return head;
    }

    static Node reverseDLL(Node head)
    {
        if(head==null || head.next==null)
            return head;
        Node curr=head;
        Node temp=null;
        while(curr!=null)
        {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        return temp.prev;
    }

    static Node deleteAtBegin(Node head)
    {
        if(head==null || head.next==null)
            return null;
        head=head.next;
        head.prev=null;
        return head;
    }

    static Node deleteAtEnd(Node head)
    {
        if(head==null || head.next==null)
            return null;
        Node curr=head;
        while(curr.next.next!=null)
        {
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }
}

class Node
{
    int data;
    Node prev;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}
