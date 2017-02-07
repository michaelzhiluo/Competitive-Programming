/*
ID: michael274
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.*;

class numtri {
	static int tri[][];
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		int rows = s.nextInt();
		tri = new int[rows][rows];
		for(int i=0; i<tri.length; i++){
			for(int j=0; j<=i; j++){
				tri[i][j]=s.nextInt();
			}
		}
		for(int i=rows-2; i>=0; i--){
			for(int j=0; j<=i; j++){
				tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);
			}
		}
		out.println(tri[0][0]);
		out.close();                                  
	}
}
