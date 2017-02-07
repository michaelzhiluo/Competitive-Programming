/*
ID: michael274
LANG: JAVA
TASK: buylow
*/

import java.io.*;
import java.util.*;

class buylow {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(new FileReader("buylow.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buylow.out")));
		int num = s.nextInt();
		int[] stocks = new int[num+1];
		int[][] dp = new int[num+1][2];
		for(int i=1; i<=num; i++){
			stocks[i] = s.nextInt();
		}
		if(num <=1){
			out.println(1 + " " + 1); out.close(); System.exit(0);
		}
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		int truemax = 1;
		for(int i=3; i<=num; i++){
			int maxlength= 1;
			for(int j=1; j<i; j++){
				if(stocks[i] < stocks[j] && dp[j][0]+1 > maxlength){
					maxlength = dp[j][0] + 1;
				}
			}
			dp[i][0] = maxlength;
			int counter =0;
			for(int j=1; j<=i; j++){
				if(stocks[i] < stocks[j] && dp[j][0] ==  maxlength-1){
					dp[i][1] += dp[j][1];
				}
			}
			if(dp[i][0] > truemax){
				truemax = dp[i][0];
			}
			if(maxlength == 1){
				dp[i][1] = 1;
			}
		}
		int counter =0;
		HashSet<Integer> temp = new HashSet<Integer>();
		for(int i=num; i>=1; i--){
			if(dp[i][0] == truemax && !temp.contains(stocks[i])){
				counter+=dp[i][1];
				temp.add(stocks[i]);
			}
			System.out.println(dp[i][0] + " " +  dp[i][1]);
		}
		out.println(truemax + " " + counter);
		out.close();                                
	}
}
