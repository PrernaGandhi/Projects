package graphPractice;

import java.util.Iterator;
import java.util.LinkedList;

import graphPractice.CreateGraph.Graph;

public class BFS {
	void BFSUtil(Graph g,int start){
		boolean visited[] = new boolean[g.V];
		LinkedList<Integer> l = new LinkedList<>();
		visited[start] = true;
		l.add(start);
		while(!l.isEmpty()){
			start = l.poll();
			System.out.print(start + " ");
			Iterator<Integer> i = g.adj.get(start).listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					l.add(n);
				}
			}
		}
	}
}
