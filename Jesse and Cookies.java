import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
        Scanner ab=new Scanner(System.in);
        int n=ab.nextInt();
        int k=ab.nextInt();
        int count=0;
         
            while(ab.hasNext())
            {
            heap.offer(ab.nextInt());
        }
        while(true)
            {
            if(heap.peek()<k)
                {
                count++;
                int temp=heap.poll();
                if(heap.size()<=0)
                    {
                    System.out.println("-1");
                    System.exit(0);
                }
                int temp2=heap.poll();
                heap.offer((temp+(2*temp2)));
            }
            else
                break;
        }
        System.out.println(count);
    }
}
