/*
ID: michael274
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.*;

class nocows {
	static int cows, height;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("nocows.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		cows =s.nextInt();
		height = s.nextInt();
		int[][] dp = new int[height+1][cows+1];
		for(int i=1; i<=height; i++){
			dp[i][0] = 1; dp[i][1] = 1;
		}
		
		for(int i=1; i<=height; i++){
			for(int j=1; j<=cows; j+=2){
				for(int k=1; k<j; k+=2){
					dp[i][j] =(dp[i][j] + dp[i-1][k]*dp[i-1][j-k-1])%9901;
				}
			}
		}
		out.println((9901 + dp[height][cows] - dp[height-1][cows])%9901);
		
		out.close();                                  
	}
}
