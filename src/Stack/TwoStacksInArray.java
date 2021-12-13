package Stack;

public class TwoStacksInArray {
    public static void main(String[] args) {
        TwoStacks s=new TwoStacks(5);
        s.push1(5);
        s.push2(10);
        s.push1(15);
        s.push2(20);
        System.out.println(s.pop1());
        System.out.println(s.pop2());
    }
}

class TwoStacks
{
    int[] arr;
    int cap;
    int top1,top2;

    TwoStacks(int c)
    {
        cap=c;
        arr=new int[cap];
        top1=-1;
        top2=cap;
    }

    void push1(int x)
    {
        if(top1<top2-1)
        {
            top1++;
            arr[top1]=x;
        }
    }

    void push2(int x)
    {
        if(top1<top2-1)
        {
            top2--;
            arr[top2]=x;
        }
    }

    int pop1()
    {
        if(top1>-1)
        {
            int x=arr[top1];
            top1--;
            return x;
        }
        return -1;
    }

    int pop2()
    {
        if(top2<cap)
        {
            int x=arr[top2];
            top2++;
            return x;
        }
        return -1;
    }
}
