/*
ID: michael274
LANG: JAVA
TASK: rockers
*/

import java.io.*;
import java.util.*;

class rockers {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("rockers.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
		int n = s.nextInt(), t= s.nextInt(), m = s.nextInt();
		int[] songs = new int[n+1];
		for(int i=1; i<=n; i++){ songs[i] = s.nextInt(); }
		int[][][] dp = new int[m+1][t+1][n+1];
		for(int i=1; i<=m; i++){
			for(int j=0; j<=t; j++){
				for(int k=1; k<=n; k++){
					if(j==0){
						dp[i][j][k] = dp[i-1][t][k];
					}
					else if(songs[k] <= j){
						dp[i][j][k] = Math.max(dp[i][j-songs[k]][k-1] + 1, dp[i][j][k-1]);
					}else if(songs[k] >j){
						dp[i][j][k] = Math.max(dp[i-1][t][k], dp[i][j][k-1]);
					}
				}
			}
		}
		out.println(dp[m][t][n]);
		out.close();                                
	}
}
