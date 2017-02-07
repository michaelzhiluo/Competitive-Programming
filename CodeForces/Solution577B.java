import java.io.*;
import java.util.*;

public class Solution577B {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] lol = new int[n];
		int hi = 0;
		for(int i=0; i<n; i++){
			int gg = s.nextInt();
			if(gg%m!=0){
				lol[hi] = gg%m;
				hi++;
			}else{
				System.out.println("YES"); System.exit(0);
			}
		}
 		boolean[][] dp = new boolean[m][2];
 		dp[0][0] = true; dp[lol[0]][0] = true;
 		int counter =0;
		for(int i=1; i<hi; i++){
			for(int j=0; j<m; j++){
				if(dp[j][(i+1)%2]){
					dp[j][i%2] = true;
					int temp1 = (j + lol[i])%m;
					if(temp1 ==0){
						counter++;
					}
					dp[temp1][i%2] = true;
				}
			}
			if(counter >0){
				System.out.println("YES");
				System.exit(0);
			}
		}
		System.out.println("NO");
	}
}