package bostonMetro;

import java.util.*;
import java.io.*;

public abstract class multiGraph {
	
	//Global Variables
	int n;
	LinkedList<Integer> graph[];
	
	//Start search of graph
	public LinkedList<Integer> search(int s, int e) {
		int prev[] = solve(s);
		return reconPath(s, e, prev);
	}
	
	//Start solve of graph
	public int[] solve(int s) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		boolean visited[] = new boolean[n];
		visited[s] = true;
		
		while (queue.size() != 0) {
			
		}
		
		int prev[] = new int[n];
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			Iterator<Integer> i = graph[node].listIterator();
			while (i.hasNext()) {
				int t = i.next();
				if (!visited[t]) {
					visited[t] = true;
					queue.add(t);
				}
			}
		}
		
		return prev;
	}
	
	//Reconstruct the path from end to start
	public LinkedList<Integer> reconPath(int s, int e, int prev[]) {
		LinkedList<Integer> path = new LinkedList<>();
		
		for(int at = e; at != 0; at = prev[at]) {
			path.add(at);
		}
		
		if (path.get(0).equals(s)) {
			return path;
		} else {
			throw new IllegalArgumentException("List is Empty");
		}
	}
}
