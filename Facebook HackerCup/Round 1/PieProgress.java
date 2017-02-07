import java.io.*;
import java.util.*;

class PieProgress {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("pie_progress.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		//Scanner s = new Scanner(new FileReader("ProgressPie.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ProgressPie.out")));
		int numdays= s.nextInt();
		for(int day=1;day<=numdays; day++){
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] pies = new int[n][m];
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					pies[i][j] = s.nextInt();
				}
				Arrays.sort(pies[i]);
			}

			for(int i=0; i<n; i++){
				pies[i][0] +=1;
				for(int j=1; j<m; j++){
					pies[i][j] += pies[i][j-1] + 2*j+1;
				}
			}

			// nth day, exactly n pies
			int[][] dp = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					dp[i][j] = 1000000000;
				}
			}
			// x amount of pies on the 0th day
			for(int i=0; i<m; i++){
				if(i<n){
					dp[0][i] = pies[0][i];
				}else{
					break;
				}
			}

			// Recursive Relationship: dp[i][j] -> Math.min(dp[i-1][j], dp[i-1][j-1] + pies[i][0], dp[i-1][j-2] + pies[i]][1] 
			for(int i=1; i<n; i++){
				// j+1 pies
				for(int j=0; j<n; j++){
					if(j==0){
						dp[i][0] = Math.min(dp[i-1][0], pies[i][0]);
					}else{
						// k+1, j-k
						int min = Integer.MAX_VALUE;
						for(int k=0; k<=j+1; k++){
							if(j-k <m){
								if(k==0){
									min = Math.min(min, pies[i][j-k]); 
								}else if(k==j+1){
									min = Math.min(min, dp[i-1][k-1]);
								}else{
									min = Math.min(dp[i-1][k-1] + pies[i][j-k], min);
								}
							}
						}
						dp[i][j] = min;
					}
				}
			}
			out.println("Case #" + day + ": " + dp[n-1][n-1]);
		}
		out.close();                                
	}
}
