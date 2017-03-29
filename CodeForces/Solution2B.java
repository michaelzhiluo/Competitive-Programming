import java.io.*;
import java.util.*;

public class Solution2B {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] dptwo = new int[n][n];
		int[][] dpfive = new int[n][n];
	}




	public static int numtwos(int n){
		int counter =0;
		while(n%2==0){
			counter++;
			n/=2;
		}
		return counter;
	}

	public static int numfives(int n){
		int counter =0;
		while(n%5==0){
			counter++;
			n/=5;
		}
		return counter;
	}
}

