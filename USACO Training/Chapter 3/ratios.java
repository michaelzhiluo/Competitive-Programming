/*
ID: michael274
LANG: JAVA
TASK: ratios
*/

import java.io.*;
import java.util.*;

class ratios {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("ratios.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
		int[] b = {s.nextInt(), s.nextInt(), s.nextInt()};
		int[] a1 = {s.nextInt(), s.nextInt(), s.nextInt()};
		int[] a2 = {s.nextInt(), s.nextInt(), s.nextInt()};
		int[] a3 = {s.nextInt(), s.nextInt(), s.nextInt()};

		// Cramer's rule
		int dA = determinant(new int[][] {{a1[0], a2[0], a3[0]}, {a1[1], a2[1], a3[1]}, {a1[2], a2[2], a3[2]}});

		// Linearly depdedent iff det(A)=0 -> can't be solved so no solution
		if(dA ==0){out.println("NONE"); out.close(); System.exit(0);}
		int dA1 = determinant(new int[][]{{b[0], a2[0], a3[0]}, {b[1], a2[1], a3[1]}, {b[2], a2[2], a3[2]}});
		int dA2 = determinant(new int[][] {{a1[0], b[0], a3[0]}, {a1[1], b[1], a3[1]}, {a1[2], b[2], a3[2]}});
		int dA3 = determinant(new int[][] {{a1[0], a2[0], b[0]}, {a1[1], a2[1], b[1]}, {a1[2], a2[2], b[2]}});

		int n1 = dA1/gcd(dA1, dA);
		int d1 = dA/gcd(dA1, dA);
		int n2 = dA2/gcd(dA2, dA);
		int d2 = dA/gcd(dA2, dA);
		int n3 = dA3/gcd(dA3, dA);
		int d3 = dA/gcd(dA3, dA);

		int temp = d2*d3/gcd(d2, d3);
		int lcm = d1*temp/gcd(d1, temp);
		n1*= lcm/d1;
		n2 *= lcm/d2;
		n3 *= lcm/d3;
		if(n1<0 || n2 <0 || n3 <0){
			out.println("NONE");
		}else{
			out.println(n1 + " "  + n2 + " " + n3 + " " + lcm);
		}

		out.close();                                  
	}
	// 3x3 determinant
	public static int determinant(int[][] m){
		return m[0][0]*m[1][1]*m[2][2] + m[0][1]*m[1][2]*m[2][0] + m[0][2]*m[1][0]*m[2][1] - (m[0][2]*m[1][1]*m[2][0] + m[0][1]*m[1][0]*m[2][2] + m[0][0]*m[1][2]*m[2][1]);
	}

	 public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
}
