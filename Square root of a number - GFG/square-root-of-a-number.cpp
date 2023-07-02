//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

  

// } Driver Code Ends
// Function to find square root
// x: element to find square root
class Solution{
  public:
    long long int floorSqrt(long long int x) 
    {
        // Your code goes here
        // for(int i=0;i<sqrt(x);i++){
        //     return sqrt(x);
        // }
        // return sqrt(x);
        
        long long int ans = 0; 
        for(int i=1;i<=x;i++){
            long long int sqrts = i*i;
            if(sqrts<=x){
                ans = i;
            }else{
                break;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long n;
		cin>>n;
		Solution obj;
		cout << obj.floorSqrt(n) << endl;
	}
    return 0;   
}

// } Driver Code Ends