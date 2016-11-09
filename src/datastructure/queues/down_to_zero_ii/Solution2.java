package datastructure.queues.down_to_zero_ii;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by cjred77@gmail.com on 2016. 11. 7..
 * https://www.hackerrank.com/challenges/down-to-zero-ii
 */
public class Solution2 {
  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner d=new Scanner(System.in);
    int operations=d.nextInt();
    while(operations!=0)
    {
      int num=d.nextInt();
      int dist[]=new int[num+1];
      if(num==0)
      {
        System.out.println("0");
        continue;
      }
      Queue<Integer> q=new LinkedList<Integer>();
      q.add(num);
      dist[num]=0;
      while(!q.isEmpty())
      {
        int curr=q.element();
        q.remove();
        if(dist[curr-1]==0)
        {
          dist[curr-1]=dist[curr]+1;
          if(curr-1==0)
            break;
          q.add(curr-1);
        }
        for(int i=2;i*i<=curr;i++)
        {
          if(curr%i==0)
          {
            int fact=Math.max(i,curr/i);
            if(dist[fact]==0)
            {
              dist[fact]=dist[curr]+1;
              q.add(fact);
            }
          }
        }
      }
      System.out.println(dist[0]);
      operations--;
    }
  }
}
