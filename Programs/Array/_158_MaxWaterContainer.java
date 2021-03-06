package Array;

/*
11. Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
the max area of water (blue section) the container can contain is 49.

Example:- Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/

public class _158_MaxWaterContainer {

	public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, (height[i]) * (j - i));
                i++;
            } else {
                maxArea = Math.max(maxArea, height[j] * (j - i));
                j--;
            }
        }
        return maxArea;
    }
	
	 public static void main(String args[]) {
		 _158_MaxWaterContainer mwc = new _158_MaxWaterContainer();
	        int input[] =  {1,8,6,2,5,4,8,3,7};
	       int maxWater= mwc.maxArea(input);
	        System.out.print(maxWater);
	        }
}
