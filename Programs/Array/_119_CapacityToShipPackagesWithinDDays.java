package Array;

/*
A conveyor belt has packages that must be shipped from one port to another within D days.
The i-th package on the conveyor belt has a weight of weights[i].
Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
We may not load more weight than the maximum weight capacity of the ship.
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

Example 1:  Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15

Explanation:- A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like
(2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:
Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation:- A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:
Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1

Note:- 
    1. 1 <= D <= weights.length <= 50000
    2. 1 <= weights[i] <= 500
 */

/*
 
Approach: Greedy Partition + Binary Search
  This topic is almost the same as the Split Array Largest Sum (the code doesn't need to be changed), just change the way to ask...
  Feeling LeetCode's recent topic homogeneity is a bit serious...
 
  The practice is still very obvious... depending on the size of the data, the time complexity can be locked at the O(nlogn) level.
  First traverse the array to determine the upper and lower bounds, left is the heaviest weight of all weights, and right is the sum of all weights +1.
  Then use Binary Search to find the smallest capacity.
 
  Time complexity: O(nlogn)
  Space complexity: O(1)
 
 */
public class _119_CapacityToShipPackagesWithinDDays {
	
	static public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
       
        while (left < right) {
            int mid = left + (right - left >> 1);
            int day = getDays(weights, mid);
            if (day <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

   static private int getDays(int[] weights, int limit) {
        int day = 1, sum = 0;
        for (int weight : weights) {
            if (sum + weight > limit) {
                sum = weight;
                day++;
            } else {
                sum += weight;
            }
        }
        return day;
    }
    
    public static void main(String [] args)
	{
    	int weights[] = {1,2,3,4,5,6,7,8,9,10};
    	int days=shipWithinDays(weights,5);
    	System.out.println(days);
    	
    	int weights1[]= {3,2,2,4,1,4};
    	int days1=shipWithinDays(weights1,3);
    	System.out.println(days1);
    
	}

}
