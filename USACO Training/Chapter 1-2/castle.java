/*
ID: michael274
LANG: JAVA
TASK: castle
*/

import java.io.*;
import java.util.*;

class castle {
	static boolean[][] spaces;
	static boolean[][][] open;
	static int maxrooms =0, numrooms = 0, counter =1, wmaxrooms =0;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		int m = s.nextInt();
		int n = s.nextInt();
		
		// false = unexplored, true = explored
		spaces = new boolean[n][m];
		// 0 is west, 1 is north, 2 is east, 3 is south
		// true means there is a wall
		open = new boolean[4][n][m];
		for(int i=0; i<spaces.length; i++){
			for(int j=0; j<spaces[0].length; j++){
				switch(s.nextInt()){
					case 1: open[0][i][j] = true; break;
					case 2: open[1][i][j] = true; break;
					case 4: open[2][i][j] = true; break;
					case 8: open[3][i][j] = true; break;
					case 3: open[0][i][j] = true; open[1][i][j] = true; break;
					case 5: open[0][i][j] = true; open[2][i][j] = true; break;
					case 9: open[0][i][j] = true; open[3][i][j] = true; break;
					case 6: open[1][i][j] = true; open[2][i][j] = true; break;
					case 10: open[1][i][j] = true; open[3][i][j] = true; break;
					case 12: open[2][i][j] = true; open[3][i][j] = true; break;
					case 7: open[0][i][j] = true; open[1][i][j] = true; open[2][i][j] = true; break;
					case 13: open[0][i][j] = true; open[2][i][j] = true; open[3][i][j] = true; break;
					case 11: open[0][i][j] = true; open[1][i][j] = true; open[3][i][j] = true; break;
					case 14: open[1][i][j] = true; open[2][i][j] = true; open[3][i][j] = true; break;
					case 15: open[0][i][j] = true; open[1][i][j] = true; open[2][i][j] = true; open[3][i][j] = true; break;
				} 
			}
		}
		
		for(int i=0; i<spaces.length; i++){
			for(int j=0; j<spaces[0].length; j++){
				if(!spaces[i][j]){
					counter=1;
					numrooms++;
					floodfill(i, j);
					if(counter>maxrooms){
						maxrooms =counter;
					}
				}
			}
		}
		out.println(numrooms); out.println(maxrooms);
		
		for(int i=0; i<spaces.length; i++){
			for(int j=0; j<spaces[0].length; j++){
				spaces[i][j] = false;
			}
		}
		int x=0, y=0;
		char c = 'E';
		// E
		for(int j=spaces[0].length-2; j>=0; j--){
			for(int i=0; i<spaces.length; i++){
				if(open[2][i][j]){
					counter =1;
					open[2][i][j] = false;
					floodfill(i, j);
					if(counter >= wmaxrooms){
						x =i;
						y = j;
						wmaxrooms = counter;
					}
					spaces = new boolean[n][m];
					open[2][i][j] = true;
				}
				
			}
		}
		// N
		for(int i=1; i<spaces.length; i++){
			for(int j=spaces[0].length-1; j>=0; j--){
				if(open[1][i][j]){
					counter =1;
					open[1][i][j] = false;
					floodfill(i, j);
					if(counter > wmaxrooms || (counter == wmaxrooms && i>=x && j <=y)){
						x = i;
						y =j;
						c = 'N';
						wmaxrooms = counter;
					}
					spaces = new boolean[n][m];
					open[1][i][j] = true;
				}
			}
		}
				
		out.println(wmaxrooms);
		out.println((x+1) + " " + (y+1) + " "+ c);
		out.close(); 
	}
	
	public static void everything(){
		for(int i=0; i<spaces.length; i++){
			for(int j=0; j<spaces[0].length; j++){
				spaces[i][j] = false;
			}
		}
	}
	public static void floodfill(int i, int j){
		spaces[i][j] = true;
		if(!open[0][i][j] && !spaces[i][j-1]){
			counter++;
			floodfill(i, j-1);
		}
		if(!open[1][i][j] && !spaces[i-1][j]){
			counter++;
			floodfill(i-1, j);
		}
		if(!open[2][i][j] && !spaces[i][j+1]){
			counter++;
			floodfill(i, j+1);
		}
		if(!open[3][i][j] && !spaces[i+1][j]){
			counter++;
			floodfill(i+1, j);
		}
	}
	
	
}
