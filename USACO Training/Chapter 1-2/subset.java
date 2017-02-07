/*
ID: michael274
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.*;

class subset {
	static long[][] memoization;
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		//Scanner s = new Scanner(new FileReader("subset.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		int n = s.nextInt();
		if( n%4==1 || n%4==2){
			out.println("0"); out.close(); System.exit(0);
		}
		memoization = new long[n+1][n*(n+1)/4+1];
		for(int max=1; max<=n; max++){
			for(int sum=1; sum<=n*(n+1)/4; sum++){
				memoization[max][sum] += memoization[max-1][sum];
				if(max==sum){
					memoization[max][sum]++;
				}
				else if(sum>max){
					memoization[max][sum] +=memoization[max-1][sum-max];
				}
			}
		}
		
		out.println(memoization[n][n*(n+1)/4]/2);
		out.close();                                  
	}
}
