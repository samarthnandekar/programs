package Array;

/*
 Find the k-th Smallest Element in Two Sorted Arrays.
 
 */

/*
 I think this is two concurrent binary searches on the subarrays A[0..n-1] and B[0..n-1], which is O(log n).

1) Given sorted arrays, you know that the nth largest will appear somewhere before or at A[n-1] if it is in array A, or B[n-1] if it is in array B
2) Consider item at index a in A and item at index b in B.
3) Perform binary search as follows (pretty rough pseudocode, not taking in account 'one-off' problems):
   a) If a + b > n, then reduce the search set
		a) if A[a] > B[b] then b = b / 2, else a = a / 2
   b) If a + b < n, then increase the search set
		b) if A[a] > B[b] then b = 3/2 * b, else a = 3/2 * a (halfway between a and previous a)
   c) If a + b = n then the nth largest is max(A[a], B[b])
		c) I believe worst case O(ln n), but in any case definitely sublinear.

 */
public class _90_KthLargestInTwoSortedArray {

	
	/*
	  Basic Approach :- Since we are given two sorted arrays, we can use merging technique to get the final merged array. From this, we simply go to the k’th index.
	 */
	
	static int kth(int arr1[], int arr2[], int m, int n, int k) 
    { 
        int[] sorted1 = new int[m + n]; 
        int i = 0, j = 0, d = 0; 
        while (i < m && j < n) 
        { 
            if (arr1[i] < arr2[j]) 
                sorted1[d++] = arr1[i++]; 
            else
                sorted1[d++] = arr2[j++]; 
        } 
        while (i < m) 
            sorted1[d++] = arr1[i++]; 
        while (j < n) 
            sorted1[d++] = arr2[j++]; 
        return sorted1[k - 1]; 
    } 
	
	
	
	public int kthLargest(int input1[],int input2[],int k){
        return kthLargest(input1, input2, 0, input1.length-1, 0, input2.length-1, k);
    }
    
    private int kthLargest(int input1[],int input2[],int l1, int h1, int l2,int h2,int k){
        if(l1 > h1){
            return input2[k-1];
        }
        if(l2 > h2){
            return input1[k-1];
        }
        
        if((h1 - l1 + 1) + (h2 - l2 + 1) == k){
            return Math.max(input1[h1], input2[h2]);
        }

        if(k == 1){
            return Math.min(input1[l1],input2[l2]);
        }

        //handle the situation where only one element is left in either of array. e.g k =2 and arr1 = 8 arr2 = 1,9,11
        //we try to find if 8 is before 9 betweenn 1 and 9 or before 1. In all these cases k will be either 1 8 or 9 
        if(l2 == h2 || l1 == h1){
            if(l2 == h2){
                if(input1[l1+k-1] < input2[l2]){
                    return input1[l1+k-1];
                }else if(input1[l1+k-2] > input2[l2]){
                    return input1[l1+k-2];
                }else{
                    return input2[l2];
                }
            }
            if(l1 == h1){
                if(input2[l2+k-1] < input1[l1]){
                    return input2[l2+k-1];
                }else if(input2[l2+k-2] > input1[l1]){
                    return input2[l2+k-2];
                }else{
                    return input1[l1];
                }
            }
        }
            
        int m1 = (h1 + l1)/2;
        int m2 = (h2 + l2)/2;
        
        int diff1 = m1 - l1+1;
        int diff2 = m2 - l2+1;
        if(diff1 + diff2 >= k){
            if(input1[m1] < input2[m2]){
                return kthLargest(input1, input2, l1, h1, l2, m2, k);
            }else{
                return kthLargest(input1, input2, l1, m1, l2, h2, k);
            }
        }else{
            if(input1[m1] < input2[m2]){
                return kthLargest(input1, input2,m1+1, h1, l2, h2, k - diff1);
            }else{
                return kthLargest(input1, input2, l1, h1, m2+1, h2, k -diff2);
            }
        }
    }
    
    public static void main(String args[]){
    	_90_KthLargestInTwoSortedArray kis = new _90_KthLargestInTwoSortedArray();
        int input1[] = {1,4,7,11,17,21};
        int input2[] = {-4,-1,3,4,6,28,35,41,56,70};
        
       System.out.println(kis.kthLargest(input1, input2, 6));       
       System.out.println(kis.kthLargest1(input1, input2,0,input1.length-1,0,input2.length-1, 6));
    }
    
    public int kthLargest1(int arr1[],int arr2[],int low1,int high1,int low2,int high2,int k){
        int len1 = high1-low1 +1;
        int len2 = high2 - low2+1;
        
        if(len1 == 0){
            return arr2[low2+k];
        }
        if(len2 ==0){
            return arr1[low1+k];
        }
        if(k == 0){
            return Math.min(arr1[low1], arr2[low2]);
        }
             
        int mid1 = len1*k/(len1 + len2);
        int mid2 = k - mid1 - 1;
        
        mid1 = low1+mid1;
        mid2 = low2 + mid2;
        
        if(arr1[mid1] > arr2[mid2]){
            k = k - mid2 + low2 -1;
            high1 = mid1;
            low2 = mid2 + 1;
        }else{
            k = k - mid1 + low1 -1;
            high2 = mid2;
            low1 = mid1+1;
        }
        return kthLargest1(arr1, arr2, low1, high1, low2, high2, k);
    }
}
