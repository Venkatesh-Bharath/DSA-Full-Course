# 1. Introduction to Graph

Graphs are a collection of vertices (nodes) and edges that connect pairs of vertices. They are widely used to model various real-world scenarios like social networks, transportation networks, etc.

# 2. Graph Representation

# 3. Adjacency Matrix

An adjacency matrix is a 2D array where each element `matrix[i][j]` represents the presence of an edge between vertices `i` and `j`.

```java
import java.util.*;

class Graph {
    private int V; // Number of vertices
    private int[][] matrix; // Adjacency matrix

    // Constructor to initialize the graph
    public Graph(int vertices) {
        V = vertices;
        matrix = new int[V][V];
        // Initialize adjacency matrix with 0 (no edges)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // Function to add an edge between vertices u and v
    public void addEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1; // Uncomment for undirected graph
    }

    // Function to print the adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5); // Create a graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printMatrix();
    }
}
```

# 6. Breadth-First Search (BFS)

Breadth-First Search is a graph traversal technique that explores vertices in the order of their distance from the source vertex, visiting all neighbors before moving on to vertices at the next level.

```java
import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor to initialize the graph
    public Graph(int vertices) {
        V = vertices;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge between vertices u and v
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u); // Uncomment for undirected graph
    }

    // Function to perform BFS traversal starting from vertex s
    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(5); // Create a graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Breadth First Traversal (starting from vertex 0): ");
        graph.BFS(0);
    }
}
```

# 8. Depth First Search (DFS)

Depth-First Search is another graph traversal technique that explores vertices by going as deep as possible down a path before backtracking.

```java
import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor to initialize the graph
    public Graph(int vertices) {
        V = vertices;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge between vertices u and v
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u); // Uncomment for undirected graph
    }

    // Function to perform DFS traversal starting from vertex s
    public void DFS(int s) {
        boolean visited[] = new boolean[V];
        DFSUtil(s, visited);
    }

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(5); // Create a graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Depth First Traversal (starting from vertex 0): ");
        graph.DFS(0);
    }
}
```

# 11. Shortest Path in an Unweighted Graph

#### Explanation:
The shortest path in an unweighted graph refers to finding the minimal number of edges from a source vertex to all other vertices in the graph.

#### Java Implementation (Breadth-First Search):
```java
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void shortestPath(int s) {
        int dist[] = new int[V];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        dist[s] = 0;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        // Print shortest distances stored in dist[]
        System.out.println("Shortest distances from node " + s + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        int source = 0;
        g.shortestPath(source);
    }
}
```

# 12. Detecting Cycle in an Undirected Graph

#### Explanation:
Detecting cycles in an undirected graph involves checking if there are any cycles (loops) in the graph structure.

#### Java Implementation (Depth-First Search):
```java
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Undirected graph
    }

    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        visited[v] = true;
        for (int i : adj[v]) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int u = 0; u < V; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
```

# 13. Detecting Cycle in a Directed Graph

#### Explanation:
Detecting cycles in a directed graph involves identifying if there is a sequence of vertices that leads back to itself.

#### Java Implementation (Depth-First Search):
```java
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isCyclicUtil(int v, boolean visited[], boolean recStack[]) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        for (int i : adj[v]) {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }

        recStack[v] = false;
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
```

# 14. Topological Sorting of a Directed Acyclic Graph (DAG)

#### Explanation:
Topological sorting of a DAG arranges vertices such that for every directed edge uv, vertex u comes before v in the ordering.

#### Java Implementation (Kahn's Algorithm using BFS):
```java
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSort() {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj[i]) {
                inDegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        ArrayList<Integer> topOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);

            for (int v : adj[u]) {
                if (--inDegree[v] == 0)
                    q.add(v);
            }
            count++;
        }

        if (count != V) {
            System.out.println("Graph contains cycle");
            return;
        }

        System.out.println("Topological Sort:");
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
    }
}
```

# 15. Kahn's BFS Based Algorithm for Topological Sorting
Already covered in the previous example.

# 16. DFS Based Algorithm for Topological Sorting (Continued)

#### Java Implementation (DFS):
```java
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (int i : adj[v]) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        System.out.println("Topological Sort:");
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
    }
}
```

# 17. Shortest Path in Directed Acyclic Graph (DAG)

#### Explanation:
Finding the shortest path in a Directed Acyclic Graph (DAG) involves a modified version of Dijkstra's algorithm, which is optimized for graphs with no cycles.

#### Java Implementation (Topological Sorting + Relaxation):
```java
import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adj;

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
    }

    void shortestPath(int s) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != Integer.MAX_VALUE) {
                for (Node neighbor : adj.get(u)) {
                    if (dist[neighbor.vertex] > dist[u] + neighbor.weight)
                        dist[neighbor.vertex] = dist[u] + neighbor.weight;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("Vertex " + i + " is unreachable from source");
            else
                System.out.println("Shortest distance to vertex " + i + " is: " + dist[i]);
        }
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (Node neighbor : adj.get(v)) {
            if (!visited[neighbor.vertex])
                topologicalSortUtil(neighbor.vertex, visited, stack);
        }

        stack.push(v);
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int source = 1;
        System.out.println("Shortest paths from source vertex " + source);
        g.shortestPath(source);
    }
}
```

# 18. Shortest Path in Directed Acyclic Graph (DAG) using Dynamic Programming

#### Explanation:
An alternative method for finding the shortest path in a DAG involves using Dynamic Programming to calculate the shortest paths from a source vertex to all other vertices.

#### Java Implementation:
```java
import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adj;

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (Node neighbor : adj.get(v)) {
            if (!visited[neighbor.vertex])
                topologicalSortUtil(neighbor.vertex, visited, stack);
        }

        stack.push(v);
    }

    void shortestPath(int s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != Integer.MAX_VALUE) {
                for (Node neighbor : adj.get(u)) {
                    if (dist[neighbor.vertex] > dist[u] + neighbor.weight)
                        dist[neighbor.vertex] = dist[u] + neighbor.weight;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("Vertex " + i + " is unreachable from source");
            else
                System.out.println("Shortest distance to vertex " + i + " is: " + dist[i]);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int source = 1;
        System.out.println("Shortest paths from source vertex " + source);
        g.shortestPath(source);
    }
}
```
