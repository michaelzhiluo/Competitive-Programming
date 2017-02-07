import java.io.*;
import java.util.*;

class bphoto {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(new FileReader("bphoto.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
		int n = s.nextInt();
		int[] height = new int[n];
		for(int i=0; i<height.length; i++){
			height[i] = s.nextInt();
		}
		int[][] lr = new int[n][2];
		int total =0;
		for(int i=0; i<height.length; i++){
			int temp = height[i];
			for(int j=i+1; j<height.length; j++){
				if(height[j]>temp){
					lr[i][1]++;
				}else{
					lr[j][0]++;
				}
			}
			if(lr[i][0] > 2*lr[i][1] || lr[i][1]> 2*lr[i][0]){
				total++;			
			}
		}
		out.println(total);
		out.close();                              
	}
}
