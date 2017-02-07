/*
ID: michael274
LANG: JAVA
TASK: range
*/

import java.io.*;
import java.util.*;

class range {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("range.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
		int n = s.nextInt();
		boolean[][] range = new boolean[n][n];
		int[] squares = new int[n+1];
		int[][] dp = new int[n][n];
		s.nextLine();
		for(int i=0; i<n; i++){
			String temp = s.nextLine();
			for(int j=0; j<n; j++){
				if(temp.charAt(j) == '0'){
					range[i][j] = false;
				}else{
					range[i][j] = true;
				}
			}

		}
		for(int i=0; i<n; i++){
			if(range[i][0]){
				dp[i][0] = 1;
			}
			if(range[0][i]){
				dp[0][i] = 1;
			}
		}
		for(int i=1; i<n; i++){
			for(int j=1; j<n; j++){
				if(range[i][j]){
					dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i-1][j]+1, dp[i][j-1] + 1));
				}
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(dp[i][j] >=2){
					squares[dp[i][j]]++;
				}
			}
		}
		for(int i=n-1; i>=2; i--){
			squares[i]+=squares[i+1];
		}
		for(int i =2; i<n+1; i++){
			if(squares[i] ==0){
				break;
			}else{
				out.println(i + " " + squares[i]);
			}
		}
		out.close();                                
	}
}
