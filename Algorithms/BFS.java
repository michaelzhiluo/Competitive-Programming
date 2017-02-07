import java.util.*;

class BFS {
	// Adjacency List Representation
	static class Graph{
		int V; // number of vertices
		LinkedList<Integer> adj[]; 
		public Graph(int v){
			V = v;
			adj = new LinkedList[v];
			for(int i=0; i<v; i++){
				adj[i] = new LinkedList();
			}
		}

		public void addEdge(int v, int w){
			adj[v].add(w);
		}
	}

	public static void main (String [] args){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		boolean[] visited = new boolean[4];
		queue.add(2);
		visited[2] = true;
		while(!queue.isEmpty()){
			int temp = queue.poll();
			System.out.println(temp);
			for(int i: g.adj[temp]){
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
