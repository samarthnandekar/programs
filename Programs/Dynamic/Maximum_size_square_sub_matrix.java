package Dynamic;

/*

https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

Given a binary matrix, find out the maximum size square sub-matrix with all 1s. For example, consider the below binary matrix.

Input :- 
   0  1  1  0  1
   1  1  0  1  0
   0  1  1  1  0
   1  1  1  1  0
   1  1  1  1  1
   0  0  0  0  0

result Matrix will form like below.
   0  1  1  0  1
   1  1  0  1  0
   0  1  1  1  0
   1  1  2  2  0
   1  2  2  3  1
   0  0  0  0  0
   

 */

public class Maximum_size_square_sub_matrix {

	private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public int maxSize(int arr[][]){
        
        int result[][] = new int[arr.length][arr[0].length];
        int max = 0;
        for(int i=0; i < arr.length; i++){
            result[i][0] = arr[i][0];
            if (result[i][0] == 1)
            {
                max = 1;
            }
        }
        
        for(int i=0; i < arr[0].length; i++){
            result[0][i] = arr[0][i];
            if (result[0][i] == 1)
            {
                max = 1;
            }
            
        }
        
        
        for(int i=1; i < arr.length; i++){
            for(int j=1; j < arr[i].length; j++){
                if(arr[i][j] == 0){
                    continue;
                }
                int t = min(result[i-1][j],result[i-1][j-1],result[i][j-1]);
                result[i][j] =  t +1;
                if(result[i][j] > max){
                    max = result[i][j];
                }
            }
        }
        return max;
    }
    
    
    public static void main(String args[]){
        
        int arr[][] = {{0,1,1,0,1},
        		       {1,1,1,0,0},
        		       {1,1,1,1,0},
        		       {1,1,1,0,1}};
        
        Maximum_size_square_sub_matrix mssm = new Maximum_size_square_sub_matrix();
        int result = mssm.maxSize(arr);
        System.out.print(result);
    }
    
}
