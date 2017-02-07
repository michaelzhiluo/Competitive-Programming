/*
ID: michael274
LANG: JAVA
TASK: fence9
*/

import java.io.*;
import java.util.*;

class fence9 {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("fence9.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence9.out")));

		// Pick's Theorem (Area = Interior Points + (Boundrary Points /2) - 1) 
		int n=s.nextInt(), m = s.nextInt(), p = s.nextInt();
		out.println((p*m +2 - gcd(n, m) - gcd(Math.abs(n-p), m) -p)/2);
		out.close();                                
	}

	public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

}
