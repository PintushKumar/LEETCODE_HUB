//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
public:
    bool dfs(vector<vector<char>>& board, int i, int j, int n, int m, string word, int indx) {
        if (indx == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word[indx]) {
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '*';
        bool up1 = dfs(board, i + 1, j, n, m, word, indx + 1);
        bool up2 = dfs(board, i - 1, j, n, m, word, indx + 1);
        bool up3 = dfs(board, i, j + 1, n, m, word, indx + 1);
        bool up4 = dfs(board, i, j - 1, n, m, word, indx + 1);
        bool up5 = dfs(board, i + 1, j + 1, n, m, word, indx + 1);
        bool up6 = dfs(board, i - 1, j - 1, n, m, word, indx + 1);
        bool up7 = dfs(board, i + 1, j - 1, n, m, word, indx + 1);
        bool up8 = dfs(board, i - 1, j + 1, n, m, word, indx + 1);
        board[i][j] = ch;
        return up1 || up2 || up3 || up4 || up5 || up6 || up7 || up8;
    }
	vector<string> wordBoggle(vector<vector<char> >& board, vector<string>& dictionary) {
	    // Code here
	    vector<string> res;
        int n = board.size();
        int m = board[0].size();
        for (int i = 0; i < dictionary.size(); i++) {
            string s = dictionary[i];
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < m; j++) {
                    if (board[k][j] == s[0]) {
                        if (dfs(board, k, j, n, m, s, 0)) {
                            if (find(res.begin(), res.end(), s) == res.end()) {
                                res.push_back(s);
                            }
                        }
                    }
                }
            }
        }

        return res;
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<string> dictionary;
        for (int i = 0; i < N; ++i) {
            string s;
            cin >> s;
            dictionary.push_back(s);
        }
        
        int R, C;
        cin >> R >> C;
        vector<vector<char> > board(R);
        for (int i = 0; i < R; i++) {
            board[i].resize(C);
            for (int j = 0; j < C; j++) cin >> board[i][j];
        }
        Solution obj;
        vector<string> output = obj.wordBoggle(board, dictionary);
        if (output.size() == 0)
            cout << "-1";
        else {
            sort(output.begin(), output.end());
            for (int i = 0; i < output.size(); i++) cout << output[i] << " ";
        }
        cout << endl;
    }
}

// } Driver Code Ends