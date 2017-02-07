/*
ID: michael274
LANG: JAVA
TASK: nuggets
*/

import java.io.*;
import java.util.*;

class nuggets {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("nuggets.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nuggets.out")));
		int[] n = new int[s.nextInt()];
		int min = 9000000;
		boolean[] seq = new boolean[65025];
		for(int i=0; i<n.length; i++){
			n[i] = s.nextInt();
			if(n[i]<min){
				min = n[i];
			}
			seq[n[i]] = true;
		}
		boolean firsttime = false;
		int largest =0;
		for(int i=1; i<seq.length; i++){	
			for(int j=0; j<n.length; j++){
				if(i-n[j]>=0 && seq[i-n[j]]){
					seq[i] = true;
					break;
				}
			}
			if(!seq[i]){
				System.out.println(largest);
				largest =i;
			}
		}
		// unbounded
		if(largest >=65020){
			largest =0;
		}
		out.println(largest);
		out.close();                                
	}
}
