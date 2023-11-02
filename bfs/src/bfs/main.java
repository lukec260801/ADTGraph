package bfs;

import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiGraph g = new multiGraph(5);
		g.addE(0, 1);
		g.addE(0, 2);
		g.addE(1, 3);
		g.addE(2, 4);
	    
		int start = 0;
		int end = 3;
		 
		
		try {
			LinkedList<Integer> path = g.search(start, end);
			
			if (!path.isEmpty()) {
				System.out.println("Path from " + start + " to " + end);
				for (int node : path) {
					System.out.println(node + " ");
				}
			} else {
				System.out.println("No path found");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
