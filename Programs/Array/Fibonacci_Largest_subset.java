package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Largest subset whose all elements are Fibonacci numbers, Given an array with positive number the task is that we find largest subset from array that contain elements which are Fibonacci numbers.
Asked in Facebook
Examples :-  Input : arr[] = {1, 4, 3, 9, 10, 13, 7}; 
             Output : subset[] = {1, 3, 13}
The output three numbers are Fibonacci numbers.
Input  : arr[] = {0, 2, 8, 5, 2, 1, 4, 13, 23};
Output : subset[] = {0, 2, 8, 5, 2, 1, 13, 23}  

A simple solution is to iterate through all elements of given array. For every number, check if it is Fibonacci or not. If yes, add it to the result.
Below is an efficient solution based on hashing.
1) Find max in the array
2) Generate Fibonacci numbers till the max and store it in hash table.
3) Traverse array again if the number is present in hash table then add it to the result. */

public class Fibonacci_Largest_subset {
	
	public static void findFibSubset(Integer[] x) 
    { 
        Integer max = Collections.max(Arrays.asList(x)); 
        List<Integer> fib = new ArrayList<Integer>();  
        List<Integer> result = new ArrayList<Integer>(); 
          
        // Generate all Fibonacci numbers  
        // till max and store them 
        Integer a = 0; 
        Integer b = 1; 
        while (b < max){ 
            Integer c = a + b; 
            a=b; 
            b=c; 
            fib.add(c); 
        } 
      
        // Now iterate through all numbers and 
        // quickly check for Fibonacci 
        for (Integer i = 0; i < x.length; i++){ 
        if(fib.contains(x[i])){ 
            result.add(x[i]);  
        }      
        } 
        System.out.println(result); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        Integer[] a = {4, 2, 8, 5, 20, 1, 40, 13, 23}; 
        findFibSubset(a); 
    } 
}
