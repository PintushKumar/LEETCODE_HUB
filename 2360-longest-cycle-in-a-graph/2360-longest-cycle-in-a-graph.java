// First Solution

// class Solution {
//     // Depth-First Search (DFS) to explore the graph and find cycles
//     public void dfs(int[] edges, int u, boolean[] visited, boolean[] dfsVisited, int[] count, int[] longestCycleLength) {
//         if (u != -1) {
//             visited[u] = true;
//             dfsVisited[u] = true;

//             int v = edges[u];

//             // If v is a valid neighbor and hasn't been visited yet
//             if (v != -1 && !visited[v]) {
//                 count[v] = count[u] + 1;
//                 dfs(edges, v, visited, dfsVisited, count, longestCycleLength);
//             }
//             // If v is a valid neighbor and is already visited (potential cycle)
//             else if (v != -1 && dfsVisited[v]) {
//                 int length = count[u] - count[v] + 1;
//                 longestCycleLength[0] = Math.max(longestCycleLength[0], length);
//             }

//             dfsVisited[u] = false; // Backtrack
//         }
//     }

//     // Main function to find the longest cycle
//     public int longestCycle(int[] edges) {
//         int n = edges.length;
//         int[] longestCycleLength = { -1 }; // Initialize with -1 (no cycle found)
//         boolean[] visited = new boolean[n];
//         boolean[] dfsVisited = new boolean[n];
//         int[] count = new int[n];
//         Arrays.fill(count, 1);

//         // Start DFS from each unvisited node to find cycles
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 dfs(edges, i, visited, dfsVisited, count, longestCycleLength);
//             }
//         }

//         // Return the longest cycle length (or -1 if no cycle found)
//         return longestCycleLength[0] > -1 ? longestCycleLength[0] : -1;
//     }
// }

// Second Solution
class Solution {
    // Depth-First Search (DFS) to explore the graph and find cycles
    public int dfs(int[] edges, int u, boolean[] visited, boolean[] dfsVisited, int[] count) {
        visited[u] = true;
        dfsVisited[u] = true;
        int v = edges[u];
        int length = 0;

        if (v != -1) {
            // If v is a valid neighbor and hasn't been visited yet
            if (!visited[v]) {
                count[v] = count[u] + 1;
                length = dfs(edges, v, visited, dfsVisited, count);
            }
            // If v is a valid neighbor and is already visited (potential cycle)
            else if (dfsVisited[v]) {
                length = count[u] - count[v] + 1;
            }
        }

        dfsVisited[u] = false; // Backtrack
        return length;
    }

    // Main function to find the longest cycle
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int longestCycleLength = -1; // Initialize with -1 (no cycle found)
        boolean visited[] = new boolean[n];
        boolean dfsVisited[] = new boolean[n];
        int count[] = new int[n];

        // Iterate through each node to find cycles
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleLength = dfs(edges, i, visited, dfsVisited, count);
                if (cycleLength > 0) {
                    longestCycleLength = Math.max(longestCycleLength, cycleLength);
                }
            }
        }

        // Return the longest cycle length (or -1 if no cycle found)
        return longestCycleLength;
    }
}
