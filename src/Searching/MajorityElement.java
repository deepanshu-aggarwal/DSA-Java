package Searching;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr={4,4,3,8,8};
//        System.out.println(majorityNaive(arr));
        System.out.println(majorityEfficient(arr));
    }

    static int majorityNaive(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int count=1;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                    count++;
            }
            if(count>arr.length/2)
                return i;
        }
        return -1;
    }

    static int majorityEfficient(int[] arr)      // Popularly known as Moore's Voting Algorithm
    {
        int count=1,res=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[res])
                count++;
            else
                count--;
            if(count==0)
            {
                res=i;
                count=1;
            }
        }
        count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==arr[res])
                count++;
            if(count>arr.length/2)
                return res;
        }
        return -1;
    }
}
