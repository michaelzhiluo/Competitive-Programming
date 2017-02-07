/*
ID: michael274
LANG: JAVA
TASK: fracdec
*/

import java.io.*;
import java.util.*;

class fracdec {
	static int num, denom;
	static int[] sequence;
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		//Scanner s = new Scanner(new FileReader("fracdec.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		num = s.nextInt(); denom = s.nextInt();
		sequence = new int[100000];
		sequence = fillsequence(sequence);
		for(int gg: sequence){
			System.out.print(gg + " ");
		}
		
		out.close();                                  
	}
	
	public static int[] fillsequence(int[] s){
		int a=0, b=num;
		for(int i=0; i<s.length; i++){
			a = b*10/denom;
			b = (b*10)-a*denom;
			s[i] =a; 
		}
		return s;
	}
}
