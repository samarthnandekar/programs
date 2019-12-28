package Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 Given an unordered array of positive integers, create an algorithm that makes sure no group of integers of size bigger than M have the same integers.

Input: 2,1,1,1,3,4,4,4,5 M = 2
Output: 2,1,1,3,1,4,4,5,4

https://www.careercup.com/question?id=6026101998485504

 */
public class _82_GroupElementsInSizeM {
	public boolean group(int input[],int m){
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(Integer i : input){
            int c = 1;
            if(count.containsKey(i)){
                c = count.get(i);
                c++;
            }
            count.put(i, c);
        }
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(count.size(),new Comparators());
        for(Integer s : count.keySet()){
            int c = count.get(s);
            //if any count is greater than len/m then this arrangement is not possible
            if(c > Math.ceil(input.length*1.0/m)){
                return false;
            }
            maxHeap.offer(new Pair(s,c));
        }
        int current = 0;
        int start = current;
        while(maxHeap.size() > 0){
            Pair p = maxHeap.poll();
            int i =0;
            while(i < p.count){
                input[start] = p.num;
                start = start + m;
                if(start >= input.length){
                    current++;
                    start = current;
                }
                i++;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        int input[] = {2,1,5,1,3,5,3,3,4};
        int input1[] = {1,2,3,8,8,8,7,8};
        GroupElementsInSizeM gps = new GroupElementsInSizeM();
        boolean r = gps.group(input1, 3);
        System.out.println(r);
        for(int i=0; i < input1.length; i++){
            System.out.println(input1[i]);
        }
    }
    
    class Pair{
        int num;
        int count;
        Pair(int num,int count){
            this.count = count;
            this.num = num;
        }
    }

    class Comparators implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.count <= o2.count){
                return 1;
            }else{
                return -1;
            }
        }
        
    }
}

