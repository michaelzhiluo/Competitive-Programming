/*
ID: michael274
LANG: JAVA
TASK: stall4
*/

import java.io.*;
import java.util.*;

class stall4 {
	static int[][] capacity;
	static int numvertexes;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("stall4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stall4.out")));
		int numhorses = s.nextInt();
		int numstalls = s.nextInt();
		numvertexes = numhorses + numstalls + 2;
		capacity = new int[numvertexes][numvertexes];
		for(int i=1; i<=numhorses; i++){
			capacity[0][i] = 1;
		}
		for(int i=1; i<=numhorses; i++){
			int temp = s.nextInt();
			for(int j=1; j<=temp; j++){
				capacity[i][numhorses + s.nextInt()] = 1;
			}
		}
		for(int i =numhorses + 1; i<=numhorses + numstalls; i++){
			capacity[i][numhorses + numstalls+1] =1;
		}
		
		int max_flow =0;
		while(true){
			int temp = find_path_bfs();
			if(temp ==0){
				break;
			}
			max_flow+=temp;
		}
		out.println(max_flow);
		out.close();                                	
	}

	public static int find_path_bfs(){
		int[] parent = new int[capacity.length];
		Arrays.fill(parent, -1);
		boolean[] visited = new boolean[capacity.length];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		visited[0] = true;
		while(!queue.isEmpty()){
			int temp = queue.poll();
			for(int i=0; i<capacity.length; i++){
				if(!visited[i] && capacity[temp][i]>0){
					queue.add(i);
					visited[i] = true;
					parent[i] = temp;
					if(i == numvertexes-1){
						break;
					}
				}
			}
		}
		if(parent[numvertexes-1] == -1){
			return 0;
		}
		int mincapacity = Integer.MAX_VALUE;
		int u =0;
		for (int v=numvertexes-1; v!=0; v=parent[v]){
                u = parent[v];
                mincapacity = Math.min(mincapacity, capacity[u][v]);
        }

		for(int v = numvertexes-1; v!=0; v=parent[v]){
			u = parent[v];
            capacity[u][v] -= mincapacity;
            capacity[v][u] += mincapacity;
		}
		return mincapacity;
	}
}
