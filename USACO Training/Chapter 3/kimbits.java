/*
ID: michael274
LANG: JAVA
TASK: kimbits
*/

import java.io.*;
import java.util.*;

class kimbits {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("kimbits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
		int n = s.nextInt();
		int l = s.nextInt();
		long k = Long.parseLong(s.next());
		int[][] dp = new int[32][32];
		// i represents an i length string, j represents at most j ones
		for(int i=0; i <dp.length; i++){
			dp[0][i] = 1;
		}
		for(int i=0; i <dp.length; i++){
			dp[i][0] = 1;
		}
		for(int i=1; i<dp.length; i++){
			for(int j=1; j<=i; j++){
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
			for(int j=i+1; j<dp.length; j++){
				dp[i][j] = dp[i][i];
			}
		}
		//Binary Search Time
		long low = 1;
		String answer = "";
		int numones = 0;
		int length = 0;
		while(answer.length()<n){
			if(low + dp[n-answer.length()-1][l-numones] >k){
				answer = answer + "0";
			}else if(low + dp[n-answer.length()-1][l-numones] <=k){
				low += dp[n-answer.length()-1][l-numones];
				answer = answer + "1";
				numones++;
			}
		}
		out.println(answer);
		out.close();
	}
}
