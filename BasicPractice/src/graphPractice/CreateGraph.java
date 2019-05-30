package graphPractice;

import java.util.LinkedList;
import java.util.List;

public class CreateGraph {
	
	class Graph{
		int V;
		List<LinkedList<Integer>>adj;
		
		Graph(int v){
			V=v;
			adj = new LinkedList<>();
			for(int i = 0;i<V;i++)
				adj.add(new LinkedList<Integer>());
		}
	}

	void addEdge(Graph g, int src,int dest){
		g.adj.get(src).add(dest); 
		//g.adj.get(dest).add(src); 
	}
	
	void print(Graph g){
		for(int i=0;i<g.V;i++){
			for(Integer j:g.adj.get(i)){
				System.out.print(j +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		CreateGraph c = new CreateGraph();
		Graph graph = c.new Graph(5);
		c.addEdge(graph, 0, 1); 
		c.addEdge(graph, 0, 4); 
        c.addEdge(graph, 1, 2); 
        c.addEdge(graph, 1, 3); 
        c.addEdge(graph, 1, 4); 
        c.addEdge(graph, 2, 3); 
        c.addEdge(graph, 3, 4); 
      
        c.print(graph); 
	}

}
