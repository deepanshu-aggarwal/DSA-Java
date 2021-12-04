package Hashing.Concepts;

public class OpenAddressing {
    public static void main(String[] args) {
        MyHash h = new MyHash(7);
        h.insert(54);
        h.insert(99);
        h.insert(42);
        h.insert(75);
        h.insert(4);

        h.printhash();
        h.delete(54);
        h.delete(75);
        h.printhash();
        System.out.println(h.search(4));
    }
}

class MyHash{
    int[] arr;
    int cap,size;

    MyHash(int c)
    {
        arr = new int[c];
        cap=c;
        size=0;
        for(int i=0;i<cap;i++)
            arr[i]=-1;
    }

    int hash(int key)
    {
        return key%cap;
    }

    boolean search(int key)
    {
        int h=hash(key);
        int i=h;
        while(arr[h]!=-1)
        {
            if(arr[h]==key)
                return true;
            else
                i=(i+1)%cap;
            if(i==h)
                return false;
        }
        return false;
    }

    boolean insert(int key)
    {
        if(size==cap)
            return false;
        int i=hash(key);
        while(arr[i]!=-1 && arr[i]!=-2 && arr[i]!=key)
            i=(i+1)%cap;
        if(arr[i]==key)
            return false;
        else
        {
            arr[i]=key;
            size++;
            return true;
        }
    }

    boolean delete(int key)
    {
        int h=hash(key);
        int i=h;
        while(arr[i]!=-1)
        {
            if(arr[i]==key)
            {
                arr[i]=-2;
                return true;
            }
            i=(i+1)%cap;
            if(i==h)
                return false;
        }
        return false;
    }

    void printhash()
    {
        int i=0;
        System.out.print("[");
        for(i=0;i<cap;i++) {
            System.out.print(arr[i]);
            if (i != cap - 1)
                System.out.print(", ");
            else
                System.out.println("]");
        }
//        System.out.println(arr.toString());
    }
}
