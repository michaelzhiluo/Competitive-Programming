import java.util.*;

// Djistkra with Adjacency List and Priority Queue as Heap
public class DijkstraHeap{
	static ArrayList<int[]>[] adj;
	public static void main(String[] args){
		adj = new ArrayList[7];
		for(int i=0; i<7; i++){
			adj[i] = new ArrayList<int[]>();
		}
		int size  =0;
		int[] distance = new int[7];
		for(int i=0; i<distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		boolean[] visited = new boolean[7];
		int[] parent = new int[7];
		distance[1] =0;
		adj[1].add(new int[]{3, 5});
		adj[3].add(new int[]{1, 5});
		adj[1].add(new int[]{4, 8});
		adj[4].add(new int[]{1, 8});
		adj[3].add(new int[]{4, 2});
		adj[4].add(new int[]{3, 2});
		adj[4].add(new int[]{6, 7});
		adj[6].add(new int[]{4, 7});
		adj[2].add(new int[]{6, 2});
		adj[6].add(new int[]{2, 2});
		adj[4].add(new int[]{2, 3});
		adj[2].add(new int[]{4, 3});
		adj[2].add(new int[]{5, 6});
		adj[5].add(new int[]{2, 6});
		adj[3].add(new int[]{5, 3});
		adj[5].add(new int[]{3, 3});
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return a[1] - b[1];
			}
		});
		queue.add(new int[]{1, 9001});
		while(!queue.isEmpty()){
			int[] min = queue.poll();
			for(int[] temp: adj[min[0]]){
				if(distance[temp[0]] > distance[min[0]] + temp[1]){
					parent[temp[0]] = min[0];
					distance[temp[0]] = distance[min[0]] + temp[1];
					queue.add(temp);
				}
			}
		}
		for(int i=1; i<distance.length; i++){
			System.out.println(i + ", Distance: " + distance[i] + " , Parent: "+ parent[i]);
		}
 	}
}