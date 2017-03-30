/*
ID: michael274
LANG: JAVA
TASK: race3
*/

import java.io.*;
import java.util.*;

class race3 {
	static int numvertexes;
	static boolean[][] paths;
	public static void main (String [] args) throws IOException {
		Scanner in = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner in = new Scanner(new FileReader("race3.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race3.out")));
		paths = new boolean[51][51];
		numvertexes = 0;
		while(in.hasNext()){
			int temp = in.nextInt();
			if(temp == -2){
				numvertexes++;
			}else if(temp == -1){
				break;
			}else{
				paths[numvertexes][temp] = true;
			}
		}

		ArrayList<Integer> pivots = new ArrayList<Integer>();
		for(int i=1; i<numvertexes-1; i++){
			if(!djistrka(i)){
				pivots.add(i);
			}
		}
		Collections.sort(pivots);

		if(pivots.size()==0){
			out.println(0); 
		}else{
			out.print(pivots.size() + " ");
			for(int i=0; i<pivots.size(); i++){
				if(i== pivots.size()-1){
					out.println(pivots.get(i));
				}else{
					out.print(pivots.get(i) + " ");
				}
			}
		}

		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i: pivots){
			if(dfsworks(i, paths)){
				answer.add(i);
			}
		}
		if(answer.size()==0){
			out.println(0); out.close(); System.exit(0);
		}
		out.print(answer.size() + " ");
		for(int i=0; i<answer.size(); i++){
			if(i== answer.size()-1){
				out.println(answer.get(i));
			}else{
				out.print(answer.get(i) + " ");
			}
		}

        out.close();                                
	}

	// Blots out a single node and checks if there is a path or not (should not have used djistrka but floodfill :( )
	public static boolean djistrka(int missingnode){
		// 0 is Source Node
		HashSet<Integer> path = new HashSet<Integer>();
		int size = 0;
		boolean[] visited = new boolean[numvertexes];
		int[] distance = new int[numvertexes];
		distance[0] = 0;
		for(int i=1; i<distance.length; i++){ distance[i] = Integer.MAX_VALUE;}

		while(size <numvertexes){
			int minindex = -1;
			int mindistance = Integer.MAX_VALUE;
			for(int i=0; i<numvertexes; i++){
				if(!visited[i] && distance[i] < mindistance && i!=missingnode){
					minindex = i;
					mindistance = distance[i];
				}
			}
			if(minindex ==-1){break;}
			visited[minindex] = true;
			size++;
			for(int i=0; i<numvertexes; i++){
				if(!visited[i] && paths[minindex][i] && distance[minindex] + 1 < distance[i]){
					distance[i] = distance[minindex] + 1;
				}
			}
		}
		return distance[numvertexes-1] != Integer.MAX_VALUE;
	}

	// Runs DFS on node 0 to rest of graph excluding the "splitting node", then runs dfs on splitting node to see whether it covers nodes covered from before
	public static boolean dfsworks(int source, boolean[][] paths){
		boolean visited[] = new boolean[numvertexes];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		while(!stack.isEmpty()){
			int temp = stack.pop();
			if(temp == source){
				continue;
			}
			visited[temp] = true;
			for(int i=0; i<numvertexes; i++){
				if(i!=source && (paths[temp][i] || paths[temp][i]) && !visited[i]){
					stack.add(i);
				}
			}
		}

		stack = new Stack<Integer>();
		boolean[] v = new boolean[numvertexes];
		stack.add(source);
		while(!stack.isEmpty()){
			int temp = stack.pop();
			if(visited[temp]){
				return false;
			}
			v[temp] = true;
			for(int i=0; i<numvertexes; i++){
				if(paths[temp][i] && !v[i]){
					stack.add(i);
				}
			}
		}
		return true;
	}		
}
