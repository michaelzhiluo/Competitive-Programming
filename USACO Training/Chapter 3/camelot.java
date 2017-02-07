/*
ID: michael274
LANG: JAVA
TASK: camelot
*/

import java.io.*;
import java.util.*;

class camelot {
	static int[] moves = {2, -2, 1, -1};
	static boolean[][] visited;
	static ArrayList<int[]> knights;
	static int rows;
	static int cols;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("camelot.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
		rows = s.nextInt();
		cols = s.nextInt();
		int c = (int)s.next().charAt(0) - 65;
		int r = s.nextInt()-1;
		int[] king = {r, c};
		knights = new ArrayList<int[]>();
		while(s.hasNext()){
			c = (int)s.next().charAt(0) - 65;
			r = s.nextInt()-1;
			knights.add(new int[]{r, c});
		}
		int[][][] bfsonknights = new int[knights.size()][rows][cols];
		for(int i=0; i<bfsonknights.length; i++){
			for(int j=0; j<rows; j++){
				for(int k=0; k<cols; k++){
					bfsonknights[i][j][k] = -1;
				}
			}
			bfs(bfsonknights[i], knights.get(i)[0], knights.get(i)[1]);
		}

		ArrayList<int[]> kingmoves = new ArrayList<int[]>();
		for(int i=-2; i<=2; i++){
			r = king[0] + i;
			for(int j=-2; j<=2; j++){
				c = king[1] + j;
				if(r>=0 && r<rows && c>=0 && c<cols){
					kingmoves.add(new int[]{r,c});
				}
			}
		}
		int[][][] kingknight = new int[kingmoves.size()][rows][cols]; 
		for(int i=0; i<kingmoves.size(); i++){
			for(int j=0; j<rows; j++){
				for(int k=0; k<cols; k++){
					kingknight[i][j][k] = -1;
				}
			}
			bfs(kingknight[i], kingmoves.get(i)[0], kingmoves.get(i)[1]);
		}
		int minmoves = Integer.MAX_VALUE;
		for(int i=0; i<rows; i++){
			foo:
			for(int j=0; j<cols; j++){
				int original = Math.max(Math.abs(i - king[0]), Math.abs(j - king[1]));
				for(int k=0; k<kingmoves.size(); k++){
					for(int l=0; l<knights.size(); l++){
						if(bfsonknights[l][kingmoves.get(k)[0]][kingmoves.get(k)[1]] ==-1 || kingknight[k][i][j] ==-1){
							continue;
						}
						int extramoves = Math.max(Math.abs(kingmoves.get(k)[0] - king[0]), Math.abs(kingmoves.get(k)[1] - king[1])) + bfsonknights[l][kingmoves.get(k)[0]][kingmoves.get(k)[1]] + kingknight[k][i][j] - bfsonknights[l][i][j];
						if(extramoves < original){
							original = extramoves;
						}
					}
				}
				int sum = original;
				for(int k=0; k<knights.size(); k++){
					if(bfsonknights[k][i][j] == -1){continue foo;}
					sum+=bfsonknights[k][i][j];
				}
				if(sum<minmoves){
					minmoves = sum;
				}
			}
		}
		out.println(minmoves);
		out.close();                                
	}

	public static void bfs(int[][] board, int i1, int i2){
		LinkedList<int[]> queue = new LinkedList<int[]>();
		visited = new boolean[rows][cols];
		board[i1][i2] = 0;
		visited[i1][i2] =true;
		queue.add(new int[]{i1, i2});
		while(!queue.isEmpty()){
			int[] temp = queue.poll();
			for(int i=0; i<=1; i++){
				for(int j=2; j<=3; j++){
					int a = temp[0] + moves[i];
					int b = temp[1] + moves[j];
					if(a>=0 && a<rows && b>=0 && b<cols && !visited[a][b]){
						visited[a][b] = true;
						board[a][b] = board[temp[0]][temp[1]] +1;
						queue.add(new int[]{a, b});
					}
					a = temp[0] + moves[j];
					b = temp[1] + moves[i];
					if(a>=0 && a<rows && b>=0 && b<cols && !visited[a][b]){
						visited[a][b] = true;
						board[a][b] = board[temp[0]][temp[1]] +1;
						queue.add(new int[]{a, b});
					}
				}
			}
		}
	}
}
