import java.io.*;
import java.util.*;

class ManicMoving{
	static int[][] distance, next;
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("pie_progress.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		//Scanner s = new Scanner(new FileReader("ProgressPie.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ProgressPie.out")));
		int lol = s.nextInt();
		gg:
		for(int l =1; l<=lol; l++){
			int n = s.nextInt();
			int m = s.nextInt();
			int kk = s.nextInt();
			// Floyd Warshall is a noob algo
			distance = new int[n+1][n+1];
			next = new int[n+1][n+1];
			for(int i=0; i<distance.length; i++){
				for(int j=0; j<distance.length; j++){
					distance[i][j] = 1000000000;
				}
				distance[i][i] =0;
			} 
			for(int i=0; i<m; i++){
				int from = s.nextInt();
				int to = s.nextInt();
				if(distance[from][to]!= 1000000000){
					distance[from][to] = s.nextInt();
				}else{
					distance[from][to] = s.nextInt();
					distance[to][from] = distance[from][to];
				}
			}
			for(int k=1; k<n+1; k++){
				for(int i=1; i<n+1; i++){
					for(int j=1; j<n+1; j++){
						if(distance[i][j] > distance[i][k] + distance[k][j]){
							distance[i][j] = distance[i][k] + distance[k][j];
						} 
					}
				}
			}

			int[][] moves = new int[kk][2];
			for(int i=0; i<kk; i++){
				moves[i][0] = s.nextInt();
				moves[i][1] = s.nextInt();
			}
			for(int i=0; i<kk; i++){
				if(distance[moves[i][0]][moves[i][1]] >1000000){
					out.println(-1); continue gg;
				}
			}

			// pick up i people, j people gone 
			int[][][] dp = new int[kk+1][kk+1][2];
			for(int i=0; i<dp.length; i++){
				for(int j=0; j<dp.length; j++){
					dp[i][j][0] = 1000000;
				}
			}
			dp[0][0][0] = 0;
			dp[1][0][0] = 0;
			dp[1][0][1] = 1;
			dp[1][1][0] = dp[1][0][0] + distance[moves[0][0]][moves[0][1]];
			dp[1][1][1] = moves[0][1];
			for(int i=2; i<dp.length; i++){
				dp[i][0][0] = dp[i-1][0][0] + distance[moves[i-2][0]][moves[i-1][0]];
				dp[i][0][1] = moves[i-1][0];
			}
			for(int i=2; i<kk+1; i++){
				for(int j=1; j<=i; j++){
					if(j==1){
						int a = dp[i-1][j][0] + distance[dp[i-1][j][1]][moves[i-1][0]];
						int b = dp[i][0][0] + distance[dp[i][0][1]][moves[0][1]];
						dp[i][j][0] = Math.min(a, b);
						dp[i][j][1] = (a<b) ? moves[i-1][0] : moves[0][1];
						continue;
					}
					if(i== j){
						dp[i][j][0] = dp[i][j-1][0] + distance[dp[i][j-1][1]][moves[j-1][1]];
						dp[i][j][1] = moves[j-1][1];
						continue;
					}
					int a = dp[i-1][j][0] + distance[dp[i-1][j][1]][moves[i-1][0]];
					int b = dp[i][j-1][0] + distance[dp[i][j-1][1]][moves[j-1][1]];
					dp[i][j][0] = Math.min(a,b);
					dp[i][j][1] = (a<b) ? moves[i-1][0] : moves[j-1][1];
				}
			}

			for(int i=0; i<kk+1; i++){
				for(int j=0; j<kk+1; j++){
					System.out.print(dp[i][j][0] + " ");
				}
				System.out.println();
			}

			for(int i=0; i<kk+1; i++){
				for(int j=0; j<kk+1; j++){
					System.out.print(dp[i][j][1] + " ");
				}
				System.out.println();
			}
			System.out.println();
			out.println(dp[kk][kk][0] + distance[1][moves[0][0]]);

		}
		out.close();                                
	}
}
