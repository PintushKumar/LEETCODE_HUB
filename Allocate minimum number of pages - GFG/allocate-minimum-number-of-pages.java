//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static boolean isPossible(int[] books, int maxStudent, int limitedPages) {
        int numOfStudent = 1; // Initialize the number of students as 1
        int numOfPages = 0; // Initialize the total number of pages allocated as 0
        for (int pages : books) {
            if (pages + numOfPages <= limitedPages) {
                numOfPages += pages; // Add the pages of the current book to the total
            } else {
                numOfStudent++; // Increment the number of students
                numOfPages = pages; // Reset the total number of pages to the pages of the current book
            }
        }
        return numOfStudent <= maxStudent; // Check if the number of students is less than or equal to the maximum allowed
    }
    
    public static int findPages(int[] books, int N, int numOfstudent) {
        if (books.length < numOfstudent) {
            return -1; // If there are fewer books than students, it's not possible to allocate each student at least one book
        }
        int si = 0; // Initialize the start index as 0
        int ei = 0; // Initialize the end index as 0
        for (int pages : books) {
            si = Math.max(si, pages); // Update the start index to hold the minimum number of pages among all books
            ei += pages; // Update the end index to hold the sum of all pages in the books
        }
        int pans = -1; // Initialize the possible answer as -1
        while (si <= ei) { // Binary search loop to find the minimum number of pages
            int mid = (si + ei) / 2; // Calculate the mid value
            if (isPossible(books, numOfstudent, mid) == true) {
                pans = mid; // Update the possible answer to the current mid value
                ei = mid - 1; // Search for a smaller value by updating the end index
            } else {
                si = mid + 1; // Search for a larger value by updating the start index
            }
        }
        return pans; // Return the minimum number of pages
    }
};

