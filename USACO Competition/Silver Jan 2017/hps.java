import java.io.*;
import java.util.*;

class hps {

	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int n = s.nextInt();
		int nump =0;
		int numh =0;
		int nums =0;
		int[] forward = new int[n];
		int[] backward = new int[n];
		char[] seq = new char[n];
		for(int i=0; i<n; i++){
			char c = s.next().charAt(0);
			seq[i] = c;
			if(c== 'P'){
				nump++;
			}else if(c=='H'){
				numh++;
			}else{
				nums++;
			}
			forward[i] = Math.max(nump, Math.max(numh, nums));
		}		
		nump =0;
		numh =0;
		nums =0;
		for(int i=n-1; i>=0; i--){
			char c= seq[i];
			if(c== 'P'){
				nump++;
			}else if(c=='H'){
				numh++;
			}else{
				nums++;
			}
			backward[n-1-i] = Math.max(nump, Math.max(numh, nums));
		}
		int max =forward[n-1];
		for(int i=0; i<=n-2; i++){
			int temp = forward[i] + backward[n-2-i];
			if(temp > max){
				max = temp;
			} 
		}
		out.println(max);
		out.close();                                
	}
}
