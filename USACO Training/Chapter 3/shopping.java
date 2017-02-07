/*
ID: michael274
LANG: JAVA
TASK: shopping
*/

import java.io.*;
import java.util.*;

class shopping {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("shopping.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
		int numoffers = s.nextInt();
		ArrayList<Integer>[] offers = new ArrayList[numoffers];
		int off[][] = new int[numoffers][5];
		for(int i=0; i<offers.length; i++){
			offers[i] = new ArrayList<Integer>();
		}
		int[] offercost  = new int[numoffers];
		for(int i=0; i<offers.length; i++){
			int temp = 2*s.nextInt() + 1;
			for(int j=0; j<temp-1; j++){
				offers[i].add(s.nextInt());
			}
			offercost[i] = s.nextInt();
		}
		HashMap<Integer, Integer> productcodes = new HashMap<Integer, Integer>();
		int numitems = s.nextInt();
		int[][] items = new int[5][2];
		int[][][][][] dp = new int[6][6][6][6][6];
		for(int i=0; i<numitems; i++){
			productcodes.put(s.nextInt(), i);
			items[i][0] = s.nextInt();
			items[i][1] = s.nextInt();
		}
		for(int i=0; i<numoffers; i++){
			for(int j=0; j<offers[i].size(); j+=2){
				off[i][productcodes.get(offers[i].get(j))] = offers[i].get(j+1);
			}
		}

		dp[1][0][0][0][0] = items[0][1];
		dp[0][1][0][0][0] = items[1][1];
		dp[0][0][1][0][0] = items[2][1];
		dp[0][0][0][1][0] = items[3][1];
		dp[0][0][0][0][1] = items[4][1];
		for(int i=0; i<off.length; i++){
			dp[off[i][0]][off[i][1]][off[i][2]][off[i][3]][off[i][4]] = offercost[i]; 
		}
		for(int a=0; a<=items[0][0]; a++){
			for(int b=0; b<=items[1][0]; b++){
				for(int c =0; c<=items[2][0]; c++){
					for(int d=0; d<=items[3][0]; d++){
						for(int e=0; e<=items[4][0]; e++){
							int min = 10000000;
							if(a>=1){
								min = Math.min(min, items[0][1] + dp[a-1][b][c][d][e]);
							}
							if(b>=1){
								min = Math.min(min, items[1][1] + dp[a][b-1][c][d][e]);
							}
							if(c>=1){
								min = Math.min(min, items[2][1] + dp[a][b][c-1][d][e]);
							}
							if(d>=1){
								min = Math.min(min, items[3][1] + dp[a][b][c][d-1][e]);
							}
							if(e>=1){
								min = Math.min(min, items[4][1] + dp[a][b][c][d][e-1]);
							}
							for(int i=0; i<off.length; i++){
								if(a>=off[i][0] && b>=off[i][1] && c>=off[i][2] && d>=off[i][3] && e>=off[i][4]){
									min = Math.min(min, offercost[i] + dp[a-off[i][0]][b-off[i][1]][c-off[i][2]][d-off[i][3]][e-off[i][4]]);
								}
							}
							if(min ==10000000){
								dp[a][b][c][d][e] =0;	
							}else{
								dp[a][b][c][d][e] = min;
							}
						}
					}
				}
			}
		}

		out.println(dp[items[0][0]][items[1][0]][items[2][0]][items[3][0]][items[4][0]]);
		out.close();                                
	}
}
