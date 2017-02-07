import java.util.*;

public class Dijkstra{
	public static void main(String[] args){
		int[][] weight = new int[7][7];
		int[] distance = new int[7];
		for(int i=0; i<distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		distance[1] = 0;
		int size = 0;
		int[] parent = new int[7];
		boolean[] visited = new boolean[7];
		weight[1][3] = 5;
		weight[3][1] = 5;
		weight[1][4] = 8;
		weight[4][1] = 8;
		weight[3][4] = 2;
		weight[4][3] = 2;
		weight[4][6] = 7;
		weight[6][4] = 7;
		weight[6][2] = 2;
		weight[2][6] = 2;
		weight[4][2] = 3;
		weight[2][4] = 3;
		weight[2][5] = 6;
		weight[5][2] = 6;
		weight[3][5] = 3;
		weight[5][3] = 3;
		while(size < 7 ){
			int minindex = 0;
			int mindistance = Integer.MAX_VALUE;
			for(int i=1; i<distance.length; i++){
				if(!visited[i] && distance[i] < mindistance){
					mindistance = distance[i];
					minindex = i;
				}
			}
			visited[minindex] = true;
			size++;
			for(int i=1; i<distance.length; i++){
				if(!visited[i] &&  weight[minindex][i] !=0 && distance[minindex] + weight[minindex][i] < distance[i]){
					distance[i] = distance[minindex] + weight[minindex][i];
					parent[i] = minindex;
				}
			}
		}
		for(int i=1; i<distance.length; i++){
			System.out.println(i + ", Distance: " + distance[i] + " , Parent: "+ parent[i]);
		}

 	}
}