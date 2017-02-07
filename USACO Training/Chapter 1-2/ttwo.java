/*
ID: michael274
LANG: JAVA
TASK: ttwo
*/

import java.io.*;
import java.util.*;

class ttwo {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("ttwo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
		boolean[][] obstacle = new boolean[10][10];
		int fx =0, fy=0, cx=0, cy=0;
		int fdir =0, cdir =0;
		for(int i=0; i<=9; i++){
			String temp= s.next();
			for(int j=0; j<=9; j++){
				char temp1 = temp.charAt(j);
				switch(temp1){
				case '*': obstacle[i][j] = true; break;
				case 'F': fx = i; fy = j; break;
				case 'C': cx = i; cy = j; break;
				}
			}
		}
		int steps =0;
		while((fx!=cx || fy!= cy) && steps<10000){
			int tempx = cx;
			int tempy = cy;
			switch(cdir){
				case 0: cx--; break;
				case 1: cy++; break;
				case 2: cx++; break;
				case 3: cy--; break;
			}
			if(cx<0 || cx>9 || cy<0 || cy>9 || obstacle[cx][cy]){
				cx = tempx;
				cy =tempy;
				cdir = (cdir+1)%4;
			}
			tempx = fx;
			tempy = fy;
			switch(fdir){
				case 0: fx--; break;
				case 1: fy++; break;
				case 2: fx++; break;
				case 3: fy--; break;
			}
			if(fx<0 || fx>9 || fy<0 || fy>9 || obstacle[fx][fy]){
				fx = tempx;
				fy =tempy;
				fdir = (fdir+1)%4;
			}
			steps++;
		}
		if(steps>=10000){
			out.println(0);
		}else{
			out.println(steps);
		}
		out.close();                                  
	}
}
