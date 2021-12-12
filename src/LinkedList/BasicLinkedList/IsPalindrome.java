package LinkedList.BasicLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsPalindrome {
    public static void main(String[] args) {
        NodeC head=new NodeC('R');
        head.next=new NodeC('A');
        head.next.next=new NodeC('D');
        head.next.next.next=new NodeC('A');
        head.next.next.next.next=new NodeC('R');

//        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeEfficient(head));
    }

    static Boolean isPalindrome(NodeC head)
    {
        Deque<Character> stack=new ArrayDeque<>();
        for(NodeC curr=head;curr!=null;curr=curr.next)
            stack.push(curr.data);
        for(NodeC curr=head;curr!=null;curr=curr.next)
        {
            if(stack.pop()!=curr.data)
                return false;
        }
        return true;
    }

    static Boolean isPalindromeEfficient(NodeC head)
    {
        NodeC slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        NodeC newHead=reverseLLRecursiveChar(slow.next);
        while(newHead!=null)
        {
            if(head.data!=newHead.data)
                return false;
            newHead=newHead.next;
            head=head.next;
        }
        return true;
    }

    static NodeC reverseLLRecursiveChar(NodeC head)
    {
        if(head==null || head.next==null)
            return head;
        NodeC newHead=reverseLLRecursiveChar(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}

class NodeC
{
    char data;
    NodeC next;
    NodeC(char data)
    {
        this.data=data;
    }
}