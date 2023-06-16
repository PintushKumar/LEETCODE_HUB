//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

void push(stack<int> &s,int x);
int pop(stack<int> &s);

int getSize(stack<int> &s);

int getTop(stack<int> &s);
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		stack<int> s;
		int q;
		cin>>q;
		while(q--)
		{
			char c;
			cin>>c;
			if(c=='a')
			{
				int x;
				cin>>x;
				push(s,x);
			}
			if(c=='b')
			{
				cout<<pop(s)<<" ";
			}
			if(c=='c')
			{
				cout<<getSize(s)<<" ";
			}
			if(c=='d')
			{
				cout<<getTop(s)<<" ";
			}
		
		
		
		}
cout<<endl;
	}
	return 0;
}
// } Driver Code Ends


/*You are required to complete below methods*/

/*the function pushes an element
x into the stack s */
void push(stack<int> &s,int x)
{
    //Your code here
    s.push(x);
}

/*pops the top element of the
stack and returns it */
int pop(stack<int> &s)
{
    //Your code here
    if(s.empty()){
        return -1;
    }
    int val = s.top();
    s.pop();
    return val;
}

/*returns the size of the stack */
int getSize(stack<int> &s)
{
   //Your code here
   return s.size();
}

/*returns the top element 
of the stack */
int getTop(stack<int> &s)
{
   //Your code here
   if(s.empty()){
       return -1;
   }
   return s.top();
}