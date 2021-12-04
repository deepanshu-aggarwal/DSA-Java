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
//        head=insertAtBegin(head,1);
//        head=insertAtEndEfficient(head,108);
//        traverse(head);
//        head=deleteAtBegin(head);
//        head=deleteAtBeginEfficient(head);
        head=deleteKthNode(head,5);
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

    static Node insertAtEnd(Node head,int x)
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
        return head;
    }

    static Node insertAtEndEfficient(Node head,int x)
    {
        Node temp=new Node(x);
        if(head==null)
        {
            temp.next=temp;
            return temp;
        }
        temp.next=head.next;
        head.next=temp;
        int data=temp.data;
        temp.data=head.data;
        head.data=data;
        return temp;
    }

    static Node deleteAtBegin(Node head)
    {
        if(head==null || head.next==null)
            return null;
        Node curr=head;
        while(curr.next!=head)
            curr=curr.next;
        curr.next=head.next;
        return head.next;
    }

    static Node deleteAtBeginEfficient(Node head)
    {
        if(head==null || head.next==head)
            return null;
        head.data=head.next.data;
        head.next=head.next.next;
        return head;
    }

    static Node deleteKthNode(Node head,int k)
    {
        if(head==null)
            return null;
        if(k==1)
            return deleteAtBeginEfficient(head);
        Node curr=head;
        int i=1;
        while(i<k-1)
        {
            curr=curr.next;
            i++;
        }
        if(curr.next==head)
            head=curr.next.next;
        curr.next=curr.next.next;
        return head;
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
