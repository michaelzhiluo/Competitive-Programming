/*
ID: michael274
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

class frac1 {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		ArrayList<Fraction> f = new ArrayList<Fraction>();
		int n = s.nextInt();
		for(int i=1; i<=n; i++){
			for(int j=0 ; j<=i; j++){
				if(gcd(i, j) == 1){
					f.add(new Fraction(j, i));
				}
			}
		}
		Collections.sort(f, new Comparator<Fraction>(){public int compare(Fraction a, Fraction b) {
		return a.num*b.denom - a.denom*b.num;}});
		for(Fraction gg: f){
			out.println(gg);
		}
		out.close();                                  
	}
	
	public static int gcd(int a, int b){
		if(b>a){
			return gcd(b, a);
		}
		if(b==0){
			return a;
		}
		return gcd(a-b, b);
	}
}

class Fraction{
	public int num;
	public int denom;
	public Fraction(int i, int j){
		num = i;
		denom = j;
	}

	public String toString(){
		return this.num + "/" + this.denom;
	}
}


