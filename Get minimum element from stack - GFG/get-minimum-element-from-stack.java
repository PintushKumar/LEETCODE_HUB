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
    int minEle;
    Stack<Integer> st , minSt;
    
    // Constructor    
    GfG()
	{
        st = new Stack<>();
        minSt = new Stack<>();
	}
	
    // Returns the minimum element from the stack
    int getMin() {
        if (minSt.isEmpty()) {
            return -1; // Stack is empty, return -1 or throw an exception.
        }
        return minSt.peek();
    }

    // Removes and returns the top element from the stack
    int pop() {
        if (st.isEmpty()) {
            return -1; // Stack is empty, return -1 or throw an exception.
        }

        int popped = st.pop();
        if (popped == minSt.peek()) {
            minSt.pop();
        }
        return popped;
    }

    // Pushes a new element onto the stack
    void push(int x) {
        st.push(x);
        if (minSt.isEmpty()) {
            minSt.push(x);
        }else if(minSt.size()>0 && x <= minSt.peek()){
            minSt.push(x);
        }
    }
}

