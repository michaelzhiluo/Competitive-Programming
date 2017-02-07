/*
ID: michael274
LANG: JAVA
TASK: butter
*/

import java.io.*;
import java.util.*;

class butter {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(new FileReader("butter.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
		int n = s.nextInt();
		int p = s.nextInt();
		int c = s.nextInt();

		// number of cows in pastures 1 -> p
		int[] numcows  = new int[p+1];
		for(int i=1; i<=n; i++){
			numcows[s.nextInt()]++;
		}
		
		int[][] weight = new int[p+1][p+1];
		int[] distance = new int[p+1];
		boolean[] visited = new boolean[p+1];
		while(s.hasNext()){
			int a = s.nextInt();
			int b = s.nextInt();
			weight[a][b] = s.nextInt();
			weight[b][a] = weight[a][b];
		}
		long totalmin = 10000000000000000L;
		for(int i=1; i<=p; i++){
			for(int j=0; j<p+1; j++){
				distance[j] = Integer.MAX_VALUE;
			}
			distance[i] =0;
			visited = new boolean[p+1];
			int size =0;
			while(size < p+1){
				int minindex = 0;
				int mindistance = Integer.MAX_VALUE;
				for(int j=1; j<distance.length; j++){
					if(!visited[j] && distance[j] < mindistance){
						mindistance = distance[j];
						minindex = j;
				}
				}
				visited[minindex] = true;
				size++;
				for(int j=1; j<distance.length; j++){
					if(!visited[j] &&  weight[minindex][j] !=0 && distance[minindex] + weight[minindex][j] < distance[j]){
						distance[j] = distance[minindex] + weight[minindex][j];
					}
				}
			}
			long temp =0;
			for(int j=1; j<p+1; j++){
				temp+=numcows[j]*distance[j];
			}
			if(temp < totalmin){
				totalmin = temp;
			}
		}
		out.println(totalmin);
		out.close();                                  
	}
	
}
