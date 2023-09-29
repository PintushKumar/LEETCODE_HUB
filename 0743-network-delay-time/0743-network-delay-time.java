class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list to represent the graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // Populate the adjacency list with edges and their weights.
        for (int ti[] : times) {
            int u = ti[0];
            int v = ti[1];
            int wt = ti[2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Initialize a priority queue for Dijkstra's algorithm.
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // Initialize an array to store distances to all nodes, set to maximum values.
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Add the source node to the priority queue and set its distance to 0.
        pq.add(new Pair(k, 0));
        dist[k] = 0;

        // Perform Dijkstra's algorithm.
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int currNode = temp.node;

            // Explore neighbors and update distances if a shorter path is found.
            for (Pair nbr : adj.get(currNode)) {
                int nbrNode = nbr.node;
                int nbrwt = nbr.weight;
                if (dist[currNode] + nbrwt < dist[nbrNode]) {
                    dist[nbrNode] = dist[currNode] + nbrwt;
                    pq.add(new Pair(nbrNode, dist[nbrNode]));
                }
            }
        }

        // Find the maximum time it takes for the signal to reach all nodes.
        int time = 0;
        for (int i = 1; i <= n; i++) {
            time = Math.max(time, dist[i]);
        }

        // If there's a node that is not reachable, return -1; otherwise, return the maximum time.
        return time == Integer.MAX_VALUE ? -1 : time;
    }
}
