//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	    long ans = 0;
	    boolean neg = false;
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i)=='-' && i==0){
	            neg = true;
	        }else if(Character.isDigit(str.charAt(i))){
	            ans = ans*10+str.charAt(i)-'0';
	        }else {
	            return -1;
	        }
	    }
	    return neg == true ? (int)ans*-1 :(int)ans;
    }
}
