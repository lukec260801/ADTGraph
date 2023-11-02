package bfs;

import java.util.*;
import java.io.*;

public class multiGraph {
	
	//Global Variables
	int n;
	LinkedList<Integer> graph[];
	
	//Constructor t build graph
	public multiGraph(int n) {
		this.n = n;
		graph = new LinkedList[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList();
		}
	}
	
	//add edges to graph
	public void addE(int n, int e) {
		graph[n].add(e);
	}
	
	//Start search of graph
	public LinkedList<Integer> search(int s, int e) {
		int prev[] = solve(s);
		return reconPath(s, e, prev);
	}
	
	//Start solve of graph
	public int[] solve(int s) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		//System.out.println("Queue before solve " + queue);
		
		boolean visited[] = new boolean[n];
		visited[s] = true;
		
		
		int prev[] = new int[n];
		Arrays.fill(prev,  -1);
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			Iterator<Integer> i = graph[node].listIterator();
			while (i.hasNext()) {
				int next = i.next();
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					prev[next] = node;
				}
			}
		}
		//System.out.println("Queue after solve " + queue);
		return prev;
	}
	
	//Reconstruct the path from end to start
	public LinkedList<Integer> reconPath(int s, int e, int prev[]) {
		LinkedList<Integer> path = new LinkedList<>();
		
		for(int at = e; at != -1; at = prev[at]) {
			//System.out.println("at: " + at + ", prev[at]: " + prev[at]);
			//System.out.println("prev array: " + Arrays.toString(prev));
			path.add(at);
			//System.out.println("path: " + path);
		}
		
		Collections.reverse(path);
		
		//System.out.println("path: " + path);
		
		if (path.get(0).equals(s)) {
			return path;
		} else {
			throw new IllegalArgumentException("List is Empty");
		}
	}
}
