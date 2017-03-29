/*
ID: michael274
LANG: JAVA
TASK: buylow
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;
class buylow {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("buylow.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buylow.out")));
		int days = s.nextInt();
		int[] stocks = new int[days+2];
		for(int i=1; i<=days; i++){
			stocks[i] = s.nextInt();
		}
		BigInteger[] dp = new BigInteger[days+2];
		int[] maxlength = new int[days+2];
		for(int i=1; i<=days; i++){
			dp[i] = BigInteger.ONE;
			maxlength[i] = 1;
		}
		int max =0;
		for(int i=2; i<dp.length; i++){
			HashSet<Integer> temp = new HashSet<Integer>();
			for(int j=i-1; j>=1; j--){
				if(stocks[i]<stocks[j]){
					if(maxlength[j]+1 == maxlength[i] && !temp.contains(stocks[j])){
						dp[i] = dp[i].add(dp[j]);
					}else if(maxlength[j]+1 > maxlength[i] ){
						maxlength[i] = maxlength[j]+1;
						dp[i] = dp[j];
						if(maxlength[i] >= maxlength[max]){
							max = i;
						}
					}
					temp.add(stocks[j]);
				}
			}
		}
		out.println(maxlength[max]-1 + " " + dp[max]);
		out.close();                                
	}
}
