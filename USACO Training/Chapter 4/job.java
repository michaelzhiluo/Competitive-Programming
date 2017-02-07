/*
ID: michael274
LANG: JAVA
TASK: job
*/

import java.io.*;
import java.util.*;

class job{
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(new FileReader("job.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("job.out")));
		int numjobs = s.nextInt();
		int m1 = s.nextInt();
		int m2 = s.nextInt();
		int[] A = new int[m1];
		int[] B = new int[m2];
		for(int i=0; i<m1; i++){
			A[i] = s.nextInt();
		}
		for(int i=0; i<m2; i++){
			B[i] = s.nextInt();
		}
		// For A Machine
		int counter=1;
		int answerA;
		while(true){
			int total =0;
			for(int i=0; i<m1; i++){
				total+=counter/A[i];
			}
			if(total >= numjobs){
				answerA= counter;
				break;
			}
			counter++;
		}

		// For B Machine
		
		out.close();                                
	}
}
