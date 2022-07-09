// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        int Ans = 0;
        int count = 0;
        while (N > 0) {
            int r = (N & 1);
            if (r == 1) {
                count++;
                Ans = Math.max(Ans, count);
            } else {
                count = 0;
            }
            N = (N >> 1);
        }
        return Ans;
    }
}



// { Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}


  // } Driver Code Ends