package LinkedList.DoublyLinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {
    public static void main(String[] args) {

        lruCache(5);

    }

    static void lruCache(int size)
    {
        Scanner scn=new Scanner(System.in);
        HashMap<Integer,Node> h=new HashMap<>();
        int x=scn.nextInt();
        Node head=null;
        while(x>0)
        {
            if(h.size()>=size)
            {
                Node temp=head;
                while (temp.next!=null)
                    temp=temp.next;
                temp.prev.next=null;
                temp.prev=null;
                h.remove(temp.data);
            }
            Node curr=new Node(x);
            if(h.size()==0)
            {
                h.put(x,curr);
                head=curr;
            }
            else
            {
                if(h.containsKey(x))
                {
                    if(head.data!=x)
                    {
                        Node prev=h.get(x).prev;
                        if(h.get(x).next==null)
                            prev.next=null;
                        else
                        {
                            prev.next=h.get(x).next;
                            h.get(x).next.prev=prev;
                        }
                        h.get(x).next=head;
                        h.get(x).prev=null;
                        head=h.get(x);
                    }
                }
                else
                {
                    head.prev=curr;
                    curr.next=head;
                    head=curr;
                    h.put(x,curr);
                }
            }
            DoublyLinkedList.traverse(head);
            System.out.println(h.size());
            x=scn.nextInt();
        }
    }
}
