/*
ID: michael274
LANG: JAVA
TASK: ditch
*/

import java.io.*;
import java.util.*;

class ditch {
	static int[][] capacity;
	static int numedges, numvertexes;
	public static void main (String [] args) throws IOException {
		long startTime = System.currentTimeMillis();
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("ditch.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ditch.out")));
		numedges = s.nextInt();
		numvertexes = s.nextInt();
		capacity = new int[numvertexes][numvertexes];
		for(int i=0; i<numedges; i++){
			capacity[s.nextInt()-1][s.nextInt()-1] += s.nextInt();
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
		long endTime = System.currentTimeMillis(); 
		System.out.println(endTime-startTime);                               	
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
