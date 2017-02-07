/*
ID: michael274
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;

class sort3 {
	public static void main (String [] args) throws IOException {
		int numswaps =0;
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int[] seq = new int[s.nextInt()];
		for(int i=0; i<seq.length; i++){
			seq[i] = s.nextInt();
		}
		int numones=0, numtwos =0, numthrees=0;
		for(int i=0; i<seq.length; i++){
			if(seq[i] == 1){numones++;}
			else if(seq[i] == 2){numtwos++;}
		}
		numthrees = seq.length - numones - numtwos;
		for(int i=0; i<numones; i++){
			if(seq[i] == 2){
				for(int j=numones; j<seq.length; j++){
					if(seq[j] ==1 && j<numones + numtwos){
						int temp = seq[i];
						seq[i] = 1;
						seq[j] = temp;
						numswaps++;
						break;
					}
				}
			}
			else if(seq[i] == 3){
				for(int j=numones; j<seq.length; j++){
					if(seq[j] ==1 && j>=numones + numtwos){
						int temp = seq[i];
						seq[i] = 1;
						seq[j] = temp;
						numswaps++;
						break;
					}
				}
			}
		}
		for(int i=0; i<numones; i++){
			if(seq[i]!=1){
				for(int j=numones; j<seq.length; j++){
					if(seq[j] ==1){
						int temp = seq[i];
						seq[i] = 1;
						seq[j] = temp;
						numswaps++;
						break;
					}
				}
			}
		}
		
		for(int i=numones; i<numones+numtwos; i++){
			if(seq[i] ==3){
				numswaps++;
			}
		}
		out.println(numswaps);
		out.close();                                  
	}
}

