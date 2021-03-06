package Graph;
/*

Depth First Search or DFS for a Graph :- https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. The only catch here is, unlike trees, 
graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array.

For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it.
2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating 
process. A Depth First Traversal of the following graph is 2, 0, 1, 3.

  



 */

import java.util.Iterator;
import java.util.LinkedList;

public class _3_DFS_Graph {

	
	private int V;   // No. of vertices 
	  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    _3_DFS_Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
    } 
  
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
  
    public static void main(String args[]) 
    { 
    	_3_DFS_Graph g = new _3_DFS_Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
    } 
    /* Output:- Following is Depth First Traversal (starting from vertex 2)
    	2 0 1 3
	
    The above code traverses only the vertices reachable from a given source vertex. All the vertices may not be reachable from a given
	vertex (example Disconnected graph). To do complete DFS traversal of such graphs, we must call DFSUtil() for every vertex. Also,
	before calling DFSUtil(), we should check if it is already printed by some other call of DFSUtil(). Following implementation does the
	complete graph traversal even if the nodes are unreachable. The differences from the above code are highlighted in the below code.


	*/
    
 // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS() 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        // starting from all vertices one by one 
        for (int i=0; i<V; ++i) 
            if (visited[i] == false) 
                DFSUtil(i, visited); 
    } 
   
    /* Output:- Following is Depth First Traversal
     0 1 2 3
     Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
     */
}
