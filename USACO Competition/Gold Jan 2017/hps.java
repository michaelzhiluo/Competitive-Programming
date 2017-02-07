import java.io.*;
import java.util.*;

class hps {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(new FileReader("hps.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int n = s.nextInt();
		int k = s.nextInt();
		if(k>n){
			k=n;
		}
		int[] cow = new int[n];
		for(int i=0; i<cow.length; i++){
			switch(s.next().charAt(0)){
 				case 'P': cow[i] = 0; break;
 				case 'H': cow[i] =1; break;
 				case 'S': cow[i] = 2; break;
 			}
 		}
 		// i -> <= number of swithces, j -> number of characters, k -> the most recent partition is mostly k
  		int[][][] dp = new int[k+1][n][3];
  		for(int i=0; i<=k; i++){
  			switch(cow[0]){
  				case 0: dp[i][0][0] = 1; break;
  				case 1: dp[i][0][1] = 1; break;
  				case 2: dp[i][0][2] = 1; break;
  			}
  		}
 		for(int i=1; i<n; i++){
 			switch(cow[i]){
 				case 0: dp[0][i][0] = dp[0][i-1][0] +1; 
 				dp[0][i][1] = dp[0][i-1][1]; 
 				dp[0][i][2] = dp[0][i-1][2]; 
 				break;
 				case 1: dp[0][i][1] = dp[0][i-1][1] +1; 
 				dp[0][i][0] = dp[0][i-1][0]; 
 				dp[0][i][2] = dp[0][i-1][2]; 
 				break;
 				case 2: dp[0][i][2] = dp[0][i-1][2] +1; 
 				dp[0][i][1] = dp[0][i-1][1]; 
 				dp[0][i][0] = dp[0][i-1][0]; 
 				break;
 			}
 		}

 		for(int i=1; i<=k; i++){
 			for(int j=1; j<n; j++){
 				int min = Math.max(dp[i-1][j-1][0], Math.max(dp[i-1][j-1][1], dp[i-1][j-1][2]));
 				switch(cow[j]){
 					case 0: dp[i][j][0] = Math.max(dp[i][j-1][0] + 1, min+1);
 					dp[i][j][1] = Math.max(dp[i][j-1][1], min);
 					dp[i][j][2] = Math.max(dp[i][j-1][2], min);
 					break;
 					case 1: dp[i][j][1] = Math.max(dp[i][j-1][1] + 1, min+1);
 					dp[i][j][0] = Math.max(dp[i][j-1][0], min);
 					dp[i][j][2] = Math.max(dp[i][j-1][2], min);
 					break;
 					case 2: dp[i][j][2] = Math.max(dp[i][j-1][2] + 1, min+1);
 					dp[i][j][1] = Math.max(dp[i][j-1][1], min);
 					dp[i][j][0] = Math.max(dp[i][j-1][0], min);
 					break;
 				}
 			}
 		}
 		out.println(Math.max(dp[k][n-1][0], Math.max(dp[k][n-1][1], dp[k][n-1][2])));
		out.close();                                
	}
}
