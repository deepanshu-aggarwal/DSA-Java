package LinkedList.BasicLinkedList;

public class BasicLinkedList {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(50);
        Node temp2=new Node(6);
        head.next=temp1;
        temp1.next=temp2;
        traverse(head);
//        head=insertAtBegin(head,1000);
//        head=insertAtEnd(head,59);
//        traverse(head);
//        head=deleteAtEnd(head);
        head=insertAtPosition(head,4,100);
        traverse(head);
        System.out.println(search(null,5));
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

    static Node insertAtBegin(Node head, int x)
    {
        Node temp=new Node(x);
        if(head==null)
            return temp;
        temp.next=head;
        head=temp;
        return head;
    }

    static Node insertAtEnd(Node head, int x)
    {
        Node temp=new Node(x);
        if(head==null)
            return temp;
        Node curr=head;
        while(curr.next!=null)
            curr=curr.next;
        curr.next=temp;
        return head;
    }

    static Node deleteAtBegin(Node head)
    {
        if(head==null)
            return null;
        return head.next;
    }

    static Node deleteAtEnd(Node head)
    {
        if(head==null || head.next==null)
            return null;
        Node curr=head;
        while(curr.next.next!=null)
            curr=curr.next;
        curr.next=null;
        return head;
    }

    static Node insertAtPosition(Node head, int pos, int x)
    {
        int i=1;
        Node curr=head;
        Node temp=new Node(x);
        if(pos==1)
        {
            temp.next=head;
            head=temp;
            return head;
        }
        while(i!=pos-1)
        {
            if(curr==null)
                return head;
            curr=curr.next;
            i++;
        }
        temp.next=curr.next;
        curr.next=temp;
        return head;
    }

    static int search(Node head, int x)
    {
        int i=1;
        Node curr=head;
        while(curr!=null)
        {
            if(curr.data==x)
                return i;
            curr=curr.next;
            i++;
        }
        return -1;
    }
}

class Node {
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}
