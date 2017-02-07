import java.io.*;
import java.util.*;

public class Solution580A {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if(n==0){System.out.println(0);System.exit(0);}
		int[] lol = new int[n];
		lol[0] = s.nextInt(); int max=1;
		int truemax = 1;
		for(int i=1; i<n; i++){
			lol[i] = s.nextInt();
			if(lol[i]>=lol[i-1]){
				max+=1;
			}else{
				max =1;
			}
			if(max >truemax){
				truemax = max;
			}
		}
		System.out.println(truemax);
	}
}
