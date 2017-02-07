/*
ID: michael274
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

class hamming {
	static int N,B,D;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		N = s.nextInt();
		B = s.nextInt();
		D = s.nextInt();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(0);
		for(int i=0; i<N-1; i++){
			for(int j=0; j< (1<<B); j++){
				boolean temp = true;
				for(int k=0; k<answer.size(); k++){
					if(hammingdist(j, answer.get(k))<D){
						temp = false;
						break;
					}
				}
				if(temp){
					answer.add(j); break;
				}
			}
		}
		
		for(int i = 0; i < answer.size();i++){
			if(i % 10 == 9 || i == answer.size()-1){
				out.println(answer.get(i));
			}
			else out.print(answer.get(i)+" ");
		}
		out.close();                                
	}
	
	static int hammingdist(int a, int b){
		int count =0;
		for(int i=0; i<B; i++){
			if((a&1) != (b&1)){
				count++;
			}
			a>>=1;
			b>>=1;
		}
		return count;
	}
}
