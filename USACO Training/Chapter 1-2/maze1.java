/*
ID: michael274
LANG: JAVA
TASK: maze1
*/

import java.io.*;
import java.util.*;

class maze1 {
	static int y, x;
	static char[][] maze;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("maze1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		y = s.nextInt();
		x = s.nextInt();
		maze = new char[2*x+1][2*y+1];
		//input
		s.nextLine();
		for(int i=0; i<maze.length; i++){
			String temp = s.nextLine();
			for(int j=0; j<maze[0].length; j++){
				maze[i][j] = temp.charAt(j);
			}
		}
		int[] exit = new int[2];
		int co = 0;
		// Finding the location of exit
		for(int i=1; i<=2*y; i+=2){
			if(maze[0][i]== ' '){
				exit[co] = i/2;
				co++;
			}
		}
		for(int i=1; i<=2*x; i+=2){
			if(maze[i][0]== ' '){
				exit[co] = y*(i/2);
				co++;
			}
		}
		for(int i=1; i<=2*y; i+=2){
			if(maze[2*x][i]== ' '){
				exit[co] = y*(x-1) + i/2;
				co++;
			}
		}
		for(int i=1; i<=2*x; i+=2){
			if(maze[i][2*y]== ' '){
				exit[co] = (y-1) + y*(i/2);
				co++;
			}
		}
		
		int[][] distance = new int[x*y][2];
		boolean[] visited = new boolean[x*y];
		int nodesvisited =1;
		// Djistkra's for the first exit
		for(int i=0; i<x*y; i++){
			distance[i][0] = 1000000000;
			distance[i][1] = 1000000000;
		}
		distance[exit[0]][0] = 0;
		distance[exit[1]][1] = 0;
		visited[exit[0]] = true;
		int i = exit[0];
		int mindist =0;
		int minpos = 0;
		while(nodesvisited<x*y){
			int[] temp = neighbor(i);
			mindist = 100000;
			for(int gg: temp){
				if(gg!=-1 && !visited[gg]){
					if(distance[i][0] + 1 < distance[gg][0]){
						distance[gg][0] = distance[i][0]+1;
					}
				}
			}
			for(int t =0; t<distance.length; t++){
				if(distance[t][0]<mindist && !visited[t]){
					mindist = distance[t][0];
					minpos = t;
				}
			}
			i = minpos;
			visited[i] = true;
			nodesvisited++;
		}
		visited = new boolean[x*y];
		visited[exit[1]] = true;
		i= exit[1];
		nodesvisited =1;
		while(nodesvisited<x*y){
			int[] temp = neighbor(i);
			mindist = 100000;
			for(int gg: temp){
				if(gg!=-1 && !visited[gg]){
					if(distance[i][1] + 1 < distance[gg][1]){
						distance[gg][1] = distance[i][1]+1;
					}
				}
			}
			for(int t =0; t<distance.length; t++){
				if(distance[t][1]<mindist && !visited[t]){
					mindist = distance[t][1];
					minpos = t;
				}
			}
			i = minpos;
			visited[i] = true;
			nodesvisited++;
		}
		int maxdist =0;
		for(int ii=0; ii<distance.length; ii++){
			int temp= Math.min(distance[ii][0], distance[ii][1]);
			if(temp > maxdist){
				maxdist = temp;
			}
		}
		out.println(maxdist+1);
		out.close();                                  
	}
	
	public static int[] neighbor(int pos){
		int[] temp = {-1, -1, -1, -1}; // North, East, South, West
		int tempx = 2*(pos/y)+1; int tempy = 2*(pos%y)+1;
		if(maze[tempx-1][tempy] == ' '){
			if(tempx-1!=0){
				temp[0] = pos-y;
			}
		}
		if(maze[tempx][tempy+1] == ' '){
			if(tempy + 1 != 2*y){
				temp[1] = pos +1;
			}
		}
		if(maze[tempx+1][tempy] == ' '){
			if(tempx +1 != 2*x){
				temp[2] = pos+y;
			}
		}
		if(maze[tempx][tempy-1] == ' '){
			if(tempy-1 != 0){
				temp[3] = pos-1;
			}
		}
		return temp;
	}
}
