/*
ID: michael274
LANG: JAVA
TASK: fence6
*/

import java.io.*;
import java.util.*;

class fence6 {
	static int[][] weight;
	static int numintersections;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("fence6.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence6.out")));
		int numedges = s.nextInt();
		int intersections = 0;
		ArrayList<int[]> vertextoedge = new ArrayList<int[]>();
		int[] edgelength = new int[numedges];
		for(int i=0; i<numedges; i++){
			int cur = s.nextInt()-1;
			edgelength[cur] = s.nextInt();
			int[] neighbor1 = new int[s.nextInt()+1];
			int[] neighbor2 = new int[s.nextInt()+1];
			neighbor1[0] = cur;
			neighbor2[0] = cur;
			for(int j=1; j<neighbor1.length; j++){
				neighbor1[j] = s.nextInt()-1;
			}
			for(int j=1; j<neighbor2.length; j++){
				neighbor2[j] = s.nextInt()-1;
			}
			Arrays.sort(neighbor1);
			Arrays.sort(neighbor2);
			if(!contains(vertextoedge, neighbor1)){
				vertextoedge.add(neighbor1);
			}
			if(!contains(vertextoedge, neighbor2)){
				vertextoedge.add(neighbor2);
			}
		}
		int[][] edgetovertex = new int[numedges][2];
		for(int i=0; i<edgetovertex.length; i++){
			edgetovertex[i][0] = -1;
			edgetovertex[i][1] = -1;
		}
		for(int i =0; i<vertextoedge.size(); i++){
			for(int j: vertextoedge.get(i)){
				if(edgetovertex[j][0] == -1){
					edgetovertex[j][0] = i;
				}else{
					edgetovertex[j][1] = i;
				}
			}
		}
		numintersections = vertextoedge.size();
		weight = new int[numintersections][numintersections];
		for(int i =0; i<numedges; i++){
			weight[edgetovertex[i][0]][edgetovertex[i][1]] = edgelength[i];
			weight[edgetovertex[i][1]][edgetovertex[i][0]] = weight[edgetovertex[i][0]][edgetovertex[i][1]];
		}
		int mincycle = Integer.MAX_VALUE;
		for(int i=0; i<numedges; i++){
			weight[edgetovertex[i][0]][edgetovertex[i][1]] =0;
			weight[edgetovertex[i][1]][edgetovertex[i][0]] = 0;
			int temp = Dijkstra(weight, edgetovertex[i][0], edgetovertex[i][1]);
			if(temp == Integer.MAX_VALUE){
				continue;
			}
			temp +=edgelength[i];
			if(temp < mincycle){
				mincycle = temp;
			}
			weight[edgetovertex[i][0]][edgetovertex[i][1]] = edgelength[i];
			weight[edgetovertex[i][1]][edgetovertex[i][0]] = weight[edgetovertex[i][0]][edgetovertex[i][1]];
		}
		out.println(mincycle);
		out.close();                                
	}

	public static boolean contains(ArrayList<int[]> a, int[] b){
		if(a.size()==0){
			return false;
		}
		for(int[] c: a){
			if(Arrays.equals(c, b)){
				return true;
			}
		}
		return false;
	}

	public static int Dijkstra(int[][] weight, int start, int end){
		int[] distance = new int[numintersections];
		boolean[] visited = new boolean[numintersections];
		for(int i=0; i<distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		for(int i=0; i<numintersections; i++){
			int minindex =0;
			int mindistance = Integer.MAX_VALUE;
			for(int j=0; j<distance.length; j++){
				if(!visited[j] && distance[j]< mindistance){
					mindistance = distance[j];
					minindex = j;
				}
			}
			visited[minindex] = true;
			for(int j=0; j<distance.length; j++){
				if(!visited[j] &&  weight[minindex][j] !=0 && distance[minindex] + weight[minindex][j] < distance[j]){
					distance[j] = distance[minindex] + weight[minindex][j];
				}
			}
		}
		return distance[end];
	}
}
