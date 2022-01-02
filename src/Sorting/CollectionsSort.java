package Sorting;

import java.util.*;

public class CollectionsSort {
    public static void main(String[] args) {
        List<Point> l=new ArrayList<>();
        l.add(new Point(5,10));
        l.add(new Point(2,20));
        l.add(new Point(10,30));
        Collections.sort(l);
        for(Point p:l)
        {
            System.out.println(p.x+" "+p.y);
        }
    }

    static class Point implements Comparable<Point>
    {
        int x;
        int y;
        Point(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
        public int compareTo(Point p)
        {
            return p.x-this.x;
        }
    }
}
