package LinkedList.BasicLinkedList;

import java.util.HashMap;

public class CloneOfLL {
    public static void main(String[] args) {
        NodeR head=new NodeR(10);
        NodeR temp1=new NodeR(5);
        NodeR temp2=new NodeR(20);
        NodeR temp3=new NodeR(15);
        NodeR temp4=new NodeR(20);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        head.random=temp2;
        temp1.random=temp3;
        temp2.random=head;
        temp3.random=temp2;
        temp4.random=temp3;

        traverse(head);
//        NodeR headClone=cloneEfficient(head);
        NodeR headClone=cloneHash(head);
        traverse(headClone);
        System.out.println(headClone.next.next.random.data);
    }

    static void traverse(NodeR head)
    {
        NodeR curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data+" -> ");
            curr=curr.next;
        }
        System.out.println("null");
    }

    static NodeR cloneHash(NodeR head)
    {
        HashMap<NodeR,NodeR> h=new HashMap<>();
        NodeR curr=head;
        while(curr!=null)
        {
            h.put(curr,new NodeR(curr.data));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null)
        {
            NodeR temp=h.get(curr);
            temp.next=h.get(curr.next);
            temp.random=h.get(curr.random);
            curr=curr.next;
        }
        return h.get(head);
    }

    static NodeR cloneEfficient(NodeR head)
    {
        NodeR curr=head;
        while (curr!=null)
        {
            NodeR temp=new NodeR(curr.data);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null)
        {
            curr.next.random=curr.random!=null ? curr.random.next:null;
            curr=curr.next.next;
        }
        curr=head;
        NodeR next=curr.next;
        NodeR headClone=next;
        while(curr!=null)
        {
            curr.next=curr.next.next;
            curr=curr.next;
            if(curr!=null)
            {
            next.next=next.next.next;
            next=next.next;
            }
        }
//        next.next=null;
        return headClone;
    }
}

class NodeR
{
    int data;
    NodeR next;
    NodeR random;
    NodeR(int data)
    {
        this.data=data;
        next=null;
        random=null;
    }
}
