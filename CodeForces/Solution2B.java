import java.io.*;
import java.util.*;

public class Solution2B {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] path = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				path[i][j] = s.nextInt();
			}
		}
		int[][] twos = new int[n][n];
		int[][] fives = new int[n][n];
		String[][] d = new String[n][n];
		twos[0][0] = two(path[0][0]);
		fives[0][0] = five(path[0][0]);
		d[0][0] = "";
		for(int i=1; i<n; i++){
			twos[0][i] = twos[0][i-1] + two(path[0][i]);
			fives[0][i] = fives[0][i-1] + five(path[0][i]);
			d[0][i] = d[0][i-1] + "R";
			twos[i][0] = twos[i-1][0] + two(path[i][0]);
			fives[i][0] = fives[i-1][0] + five(path[i][0]);
			d[i][0] = d[i-1][0]+ "D";
		}
		
		for(int i=1; i<n; i++){
			for(int j=1; j<n; j++){
				int a= Math.min(twos[i-1][j], fives[i-1][j]); // Down
				int b = Math.min(twos[i][j-1], fives[i][j-1]); // Left
				if(a==b){
					if(Math.max(twos[i-1][j], fives[i-1][j]) <Math.max(twos[i][j-1], fives[i][j-1])){
						twos[i][j] = twos[i-1][j] + two(path[i][j]);
						fives[i][j] = fives[i-1][j] + five(path[i][j]);
						d[i][j] = d[i-1][j] + "D";
					}else{
						twos[i][j] = twos[i][j-1] + two(path[i][j]);
						fives[i][j] = fives[i][j-1] + five(path[i][j]);
						d[i][j] = d[i][j-1] + "R";
					}
				}
				else if(a<b){
					twos[i][j] = twos[i-1][j] + two(path[i][j]);
					fives[i][j] = fives[i-1][j] + five(path[i][j]);
					d[i][j] = d[i-1][j] + "D";
				}else{
					twos[i][j] = twos[i][j-1] + two(path[i][j]);
					fives[i][j] = fives[i][j-1] + five(path[i][j]);
					d[i][j] = d[i][j-1] + "R";
				}
			}
		}
		System.out.println(Math.min(twos[n-1][n-1], fives[n-1][n-1]));
		System.out.println(d[n-1][n-1]);                         
	}
	public static int two(int n){
		int temp =0;
		while(n%2==0){
			temp++;
			n=n/2;
		}
		return temp;
	}
	public static int five(int n){
		int temp =0;
		while(n%5==0){
			temp++;
			n=n/5;
		}
		return temp; 
	}
}

