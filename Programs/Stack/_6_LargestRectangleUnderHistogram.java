package Stack;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.experimental.max.MaxHistory;

/*
 
 https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 
 */
public class _6_LargestRectangleUnderHistogram {

	public static void main(String[] args) {
		int [] arr= {2,1,2,3,1};
		int maxArea=maxHistogram(arr);
		
		System.out.println("maxArea -->"+maxArea);

	}

	static public int maxHistogram(int input[])
	{
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;)
        {
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }
            else
            {
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be greater or equal to input[top] so get area by input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1 has to be greater or equal to input[top] so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        
        while(!stack.isEmpty())
        {
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be greater or equal to input[top] so get area by input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1 has to be greater or equal to input[top] so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
