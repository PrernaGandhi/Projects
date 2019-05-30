package graphPractice;

import java.util.Iterator;
import graphPractice.CreateGraph.Graph;

public class DFS {
	
	void DFSUtil(Graph g,boolean visited[],int start){
		visited[start] = true;
		System.out.print(start + " ");
		Iterator<Integer> i = g.adj.get(start).listIterator();
		while (i.hasNext()) {
			Integer n = i.next();
			if(!visited[n]){
				DFSUtil(g, visited, n);
			}	
		}
	}

	public static void main(String[] args) {
		CreateGraph c = new CreateGraph();
		Graph graph = c.new Graph(5);
		   c.addEdge(graph,0, 1); 
	        c.addEdge(graph,0, 2); 
	        c.addEdge(graph,1, 2); 
	        c.addEdge(graph,2, 0); 
	        c.addEdge(graph,2, 3); 
	        c.addEdge(graph,3, 3); 
	  
	        System.out.println("Following is Depth First Traversal "+ 
	                           "(starting from vertex 2)"); 
	        boolean visited[] = new boolean[graph.V];
	        DFS dfs = new DFS();
	        dfs.DFSUtil(graph, visited,2);
	        System.out.println();
	        BFS bfs = new BFS();
	        System.out.println("Following is Breadth First Traversal "+ 
                    "(starting from vertex 2)"); 

	        bfs.BFSUtil(graph, 2); 
	  
	        
	}

}
