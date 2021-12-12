package Stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyStackArray s=new MyStackArray(5);
        s.push(5);
        s.push(10);
        s.pop();
        s.push(30);
        s.push(30);
        s.push(30);
        s.push(30);
        s.size();
//        s.push(30);
        s.peek();
        s.size();
    }
}

class MyStackArray
{
    int[] arr;
    int cap;
    int top;

    MyStackArray(int c)
    {
        cap=c;
        arr=new int[c];
        top=-1;
    }

    void push(int x)
    {
        if(top==cap-1)
        {
            System.out.println("Stack is full!");
            return;
        }
        top++;
        arr[top]=x;
    }

    void pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.println(arr[top]);
        top--;
    }

    void size()
    {
        System.out.println(top+1);
    }

    void peek()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.println(arr[top]);
    }

    void isEmpty()
    {
        System.out.println(top == -1);
    }
}

class MyStackAList
{
    ArrayList<Integer> arr=new ArrayList<>();

    void push(int x)
    {
        if(arr.size()==5)
        {
            System.out.println("Stack is full!");
            return;
        }
        arr.add(x);
    }

    int pop()
    {
        if(arr.size()==0)
            return -1;
        int x=arr.get(arr.size()-1);
        arr.remove(arr.get(arr.size()-1));
        return x;
    }

    int size()
    {
        return arr.size();
    }

    int peek()
    {
        if(arr.size()==0)
            return -1;
        return arr.get(arr.size()-1);
    }

    Boolean isEmpty()
    {
        return arr.size() == 0;
    }
}

class MyStackList
{
    Node head;
    int cap;
    int size;

    MyStackList(int c)
    {
        Node head=null;
        int size=-1;
    }

    void push(int x)
    {
        size++;
        Node temp=new Node(x);
        temp.next=head;
        head=temp;
    }

    int pop()
    {
        if(size==-1)
            return -1;
        int x=head.data;
        head=head.next;
        size--;
        return x;
    }

    int size()
    {
        return size+1;
    }

    int peek()
    {
        if(size==-1)
        {
            return -1;
        }
        return head.data;
    }

    Boolean isEmpty()
    {
        return size==-1;
    }
}

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}



