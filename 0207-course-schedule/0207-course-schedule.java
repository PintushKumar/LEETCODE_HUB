// ****************************************

//  this code using Dfs 

// class Solution {
//     // Depth-First Search (DFS) function to check for cyclic dependencies
//     public boolean isCyclicDFS(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[], boolean dfsVisited[]) {
//         visited[u] = true;       // Mark the current node as visited
//         dfsVisited[u] = true;    // Mark the current node as visited in the current DFS traversal

//         // Iterate through all adjacent vertices of u
//         for (int v : adj.get(u)) {
//             if (!visited[v]) {   // If v is not visited, recursively explore it
//                 if (isCyclicDFS(adj, v, visited, dfsVisited)) {
//                     return true;  // If a cycle is detected, return true
//                 }
//             } else if (dfsVisited[v]) {
//                 return true;      // If v is visited in the current DFS traversal, a cycle is detected, return true
//             }
//         }

//         dfsVisited[u] = false;    // Mark u as unvisited in the current DFS traversal

//         return false;            // No cycle was found, return false
//     }

//     // Function to check if it's possible to finish all courses without cyclic dependencies
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<Integer>());
//         }

//         // Build the adjacency list representation of the course prerequisites
//         for (int crs[] : prerequisites) {
//             int a_crs = crs[0];
//             int b_crs = crs[1];

//             // To take course a_crs, you must complete course b_crs
//             adj.get(b_crs).add(a_crs);
//         }

//         boolean visited[] = new boolean[numCourses];    // Array to keep track of visited nodes
//         boolean dfsVisited[] = new boolean[numCourses]; // Array to keep track of visited nodes in the current DFS traversal

//         // Perform DFS on each unvisited node
//         for (int i = 0; i < numCourses; i++) {
//             if (!visited[i]) {
//                 if (isCyclicDFS(adj, i, visited, dfsVisited)) {
//                     return false; // If a cycle is detected in any DFS traversal, return false means we can not complete all the course
//                 }
//             }
//         }

//         return true; // No cycle was found, it's possible to finish all courses
//     }
// }


//****************************************** */

// this code using BFS 

class Solution {
    // Function to check for cyclic dependencies using Breadth-First Search (BFS)
    public boolean isCyclicBFS(int N, ArrayList<ArrayList<Integer>> adj) {
        int inDegree[] = new int[N];                  // Array to store in-degrees of each node
        Queue<Integer> q = new ArrayDeque<>();        // Queue for BFS traversal
        boolean visited[] = new boolean[N];           // Array to track visited nodes
        
        // Calculate in-degrees for each node
        for (int u = 0; u < N; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        // Add nodes with in-degree 0 to the queue (initial courses that can be taken)
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = q.size(); // Counter for courses that can be taken initially

        // Perform BFS traversal
        while (q.size() > 0) {
            int u = q.remove();
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                    count++;
                }
            }
        }

        // If all courses can be taken without cyclic dependencies, return false
        if (count == N) {
            return false;
        }

        return true; // Cyclic dependencies exist, return true
    }

    // Function to check if it's possible to finish all courses without cyclic dependencies
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        // Build the adjacency list representation of the course prerequisites
        for (int crs[] : prerequisites) {
            int a_crs = crs[0];
            int b_crs = crs[1];

            // To take course a_crs, you must complete course b_crs
            adj.get(b_crs).add(a_crs);
        }

        // Check for cyclic dependencies using BFS
        if (isCyclicBFS(numCourses, adj)) {
            return false; // Cyclic dependencies exist, cannot finish all courses
        }

        return true; // No cyclic dependencies, it's possible to finish all courses
    }
}
