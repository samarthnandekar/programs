package Dynamic;

/*
 
 How to print maximum number of A’s using given four keys
This is a famous interview question asked in Google, Paytm and many other company interviews.

Below is the problem statement. Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
                 after what has already been printed. 

If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers of A's. That is to
say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).

Examples:

Input:  N = 3
Output: 3
We can at most get 3 A's on screen by pressing 
following key sequence.
A, A, A

Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

Input:  N = 11
Output: 27
We can at most get 27 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 */
public class _36_PrintMaxAUsing4keys {

	public int countAsRec(int n){
	    
        if(n < 7){
            return n;
        }
        int max = Integer.MIN_VALUE;
        int result = 0;
        for(int b=n-3; b > 0; b--){
            result = (n-b-1)*countAs(b);
            if(max < result){
                max = result;
            }
        }
        return max;
    }
 
    public int countAs(int n){
        if(n < 7){
            return n;
        }
        
        int T[] = new int[n+1];
        for(int i=1; i < 7 ; i++){
            T[i] = i;
        }
        for(int i=7; i <= n; i++){
            for(int b = i-3; b > 0; b--){
                T[i] = Math.max(T[i], T[b]*(i-b-1));
            }
        }
        return T[n];
    }
    
    public static void main(String args[]){
    	_36_PrintMaxAUsing4keys ca =new _36_PrintMaxAUsing4keys();
       // System.out.println(ca.countAsRec(11));
        System.out.println(ca.countAs(7));
              
    }
}
