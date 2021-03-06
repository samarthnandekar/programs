package Graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
 https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 
Detect cycle in an undirected graph
Given an undirected graph, how to check if there is a cycle in the graph? For example, the following graph has a cycle 1-0-2-1.

Time Complexity: The program does a simple DFS Traversal of graph and graph is represented using adjacency list. 
                 So the time complexity is O(V+E)
 */
public class _17_CycleUndirectedGraph {

	    private int V;                      // No. of vertices 
	    private LinkedList<Integer> adj[]; // Adjacency List Represntation 
	  
	    // Constructor 
	    _17_CycleUndirectedGraph(int v) { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for(int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    // Function to add an edge into the graph 
	    void addEdge(int v,int w) { 
	        adj[v].add(w); 
	        adj[w].add(v); 
	    } 
	  
	    // A recursive function that uses visited[] and parent to detect 
	    // cycle in subgraph reachable from vertex v. 
	    Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
	    { 
	        // Mark the current node as visited 
	        visited[v] = true; 
	        Integer i; 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        Iterator<Integer> it = adj[v].iterator(); 
	        while (it.hasNext()) 
	        { 
	            i = it.next(); 	  
	            // If an adjacent is not visited, then recur for that adjacent 
	            if (!visited[i]) 
	            { 
	                if (isCyclicUtil(i, visited, v)) 
	                    return true; 
	            } 	  
	            // If an adjacent is visited and not parent of current vertex, then there is a cycle. 
	            else if (i != parent) 
	                return true; 
	        } 
	        return false; 
	    } 
	  
	    // Returns true if the graph contains a cycle, else false. 
	    Boolean isCyclic() 
	    { 
	        // Mark all the vertices as not visited and not part of recursion stack 
	        Boolean visited[] = new Boolean[V]; 
	        for (int i = 0; i < V; i++) 
	            visited[i] = false; 
	  
	        // Call the recursive helper function to detect cycle in different DFS trees 
	        for (int u = 0; u < V; u++) 
	            if (!visited[u]) // Don't recur for u if already visited 
	                if (isCyclicUtil(u, visited, -1)) 
	                    return true; 
	  
	        return false; 
	    } 
	  	  
	    // Driver method to test above methods 
	    public static void main(String args[]) 
	    { 
	    	_17_CycleUndirectedGraph g1 = new _17_CycleUndirectedGraph(5); 
	        g1.addEdge(1, 0); 
	        g1.addEdge(0, 2); 
	        g1.addEdge(2, 1); 
	        g1.addEdge(0, 3); 
	        g1.addEdge(3, 4); 
	        if (g1.isCyclic()) 
	            System.out.println("Graph contains cycle"); 
	        else
	            System.out.println("Graph doesn't contains cycle"); 
	  
	        _17_CycleUndirectedGraph g2 = new _17_CycleUndirectedGraph(3); 
	        g2.addEdge(0, 1); 
	        g2.addEdge(1, 2); 
	        if (g2.isCyclic()) 
	            System.out.println("Graph contains cycle"); 
	        else
	            System.out.println("Graph doesn't contains cycle"); 
	    } 
}
