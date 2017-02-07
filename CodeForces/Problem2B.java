/*
ID: theasura
LANG: JAVA
TASK: Problem2B
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Problem2B {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] grid = new int[n][n];
		// number of 0's in position i, j
		BigInteger[][] dp = new BigInteger[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				grid[i][j] = s.nextInt();
			}
		}

		dp[0][0]

		out.close();                                
	}

	public static int numtens


}
