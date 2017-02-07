import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution474D {
	public static void main(String [] args) throws FileNotFoundException{
		Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int k = s.nextInt();
		int[][] gg = new int[t][2];
		int max =0;
		while(t>0){
			gg[gg.length-t][0] = s.nextInt();
			gg[gg.length-t][1] = s.nextInt();
			t-=1;
		}
		int[] dp = new int[100001];
		for(int i=1; i<k ;i++){
			dp[i] = i;
		} dp[k] = k+1;
		for(int i=k+1; i<dp.length; i++){
			dp[i] = (dp[i-1] - dp[i-2] + dp[i-k] - dp[i-k-1] + dp[i-1])%1000000007;
			if(dp[i] <0){
				dp[i]+=1000000007;
			}
		}
		
		for(int i=0; i<gg.length; i++){
			int troll = dp[gg[i][1]]-dp[gg[i][0]-1];
			if(troll<0){
				System.out.println(troll+1000000007);
			}else{
				System.out.println(troll);
			}
		}
		
	}
}
