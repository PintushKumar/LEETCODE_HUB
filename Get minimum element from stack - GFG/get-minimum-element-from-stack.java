//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle; // Variable to store the minimum element
    Stack<Integer> st, minSt; // Two stacks: one for elements, and another for minimum elements.

    // Constructor    
    GfG()
    {
        st = new Stack<>(); // Initialize the element stack
        minSt = new Stack<>(); // Initialize the minimum element stack
    }

    /* Returns the minimum element from the stack */
    int getMin()
    {
        // Your code here
        if (minSt.size() == 0) {
            return -1; // If the minimum element stack is empty, return -1.
        }
        return minSt.peek(); // Return the top element of the minimum element stack.
    }

    /* Returns the popped element from the stack */
    int pop()
    {
        // Your code here
        if (st.size() == 0) {
            return -1; // If the element stack is empty, return -1.
        }
        int stpeek = st.peek(); // Get the top element of the element stack.
        if (stpeek == minSt.peek()) {
            minSt.pop(); // If the top element is the minimum element, pop it from the minimum element stack.
        }
        return st.pop(); // Pop and return the top element from the element stack.
    }

    /* Pushes element x into the stack */
    void push(int x)
    {
        // Your code here
        st.push(x); // Push the element onto the element stack.
        if (minSt.size() == 0) {
            minSt.push(x); // If the minimum element stack is empty, push the element onto it.
        } else if (minSt.size() > 0 && x <= minSt.peek()) {
            minSt.push(x); // If the element is less than or equal to the current minimum, push it onto the minimum element stack.
        }
    }   
}


