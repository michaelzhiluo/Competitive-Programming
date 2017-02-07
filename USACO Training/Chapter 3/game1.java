/*
ID: michael274
LANG: JAVA
TASK: game1
*/

import java.io.*;
import java.util.*;

class game1 {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("game1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
		int n = s.nextInt();
		int[] game = new int[n];
		int[][] d1 = new int[n][n];
		int[][] d2 = new int[n][n];
		int sum =0;
		for(int i=0; i<game.length; i++){
			game[i] = s.nextInt();
			sum+=game[i];
		}
		for(int i=0; i<n; i++){
			d1[i][i] = game[i];
			d2[i][i] = game[i];
		}
		for(int i=0; i<n-1; i++){
			d1[i][i+1] = game[i+1]>game[i] ? game[i+1] : game[i];
			d2[i][i+1] = game[i+1] > game[i] ? game[i] : game[i+1];
		}

		for(int i=2; i<n; i++){
			for(int j=0; j<n-i; j++){
				d1[j][j+i] = Math.max(d2[j+1][j+i] + game[j], d2[j][j+i-1] + game[j+i]);
				d2[j][j+i] = Math.min(d1[j+1][j+i], d1[j][j+i-1]);
			}
		}
		out.println(d1[0][n-1] + " " + (sum - d1[0][n-1]));
		out.close();                                
	}
}
