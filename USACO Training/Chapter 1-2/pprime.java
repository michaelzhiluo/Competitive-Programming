/*
ID: michael274
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.*;

class pprime {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		int a = s.nextInt();
		int b = s.nextInt();
		int[] pali = new int[11110];
		int temp=0;
		//all one and two digit palindromes
		for(int i=1; i<=9; i+=2){
			pali[temp]=i;
			pali[temp+1]=11*i;
			temp+=2;
		}
		// all three and four digit palindromes
		for (int d1 = 1; d1 <= 9; d1+=2) {	/* only odd; evens aren't so prime */
			for (int d2 = 0; d2 <= 9; d2++) {
				pali[temp] = 100*d1 + 10*d2 + d1;
				pali[temp+1] = 1000*d1 + 100*d2 + 10*d2+ d1;
				temp+=2;
			}
		}
		// all five and six digit palindromes
		for (int d1 = 1; d1 <= 9; d1+=2) {	/* only odd; evens aren't so prime */
			for (int d2 = 0; d2 <= 9; d2++) {
				for (int d3 = 0; d3 <= 9; d3++) {
				    pali[temp] = 10000*d1 + 1000*d2 +100*d3 + 10*d2 + d1;
				    pali[temp+1] = 100000*d1 + 10000*d2 + 1000*d3 + 100*d3 + 10*d2+ d1;
				    temp+=2;
				}
			}
		}
		// all seven and eight digit palindromes
		for (int d1 = 1; d1 <= 9; d1+=2) {	/* only odd; evens aren't so prime */
			for (int d2 = 0; d2 <= 9; d2++) {
				for (int d3 = 0; d3 <= 9; d3++) {
					for(int d4 = 0 ; d4<=9; d4++){
						pali[temp] = 1000000*d1+ 100000*d2 + 10000*d3 + 1000*d4 + 100*d3 + 10*d2 + d1;
					    pali[temp+1] = 10000000*d1 + 1000000*d2 + 100000*d3 + 10000*d4 + 1000*d4 + 100*d3 + 10*d2 + d1;
					    temp+=2;
					}
				}
			}
		}
		ArrayList<Integer> works = new ArrayList<Integer>();
		for(int i=0; i<pali.length; i++){
			int temp1 = pali[i];
			if(temp1>=a && temp1<=b && isprime(temp1)){
				works.add(temp1);
			}
		}
		Collections.sort(works);
		for(int gg: works){
			out.println(gg);
		}
		out.close();
	}
	// O(sqrt(n)/6)
	public static boolean isprime(int n){
		if(n==1){
			return false;
		}
		else if(n<4){
			return true;
		}
		else if(n%2==0){
			return false;
		}
		else if(n<9){
			return true;
		}
		else if(n%3==0){
			return false;
		}
		else{
			int a = (int)Math.sqrt(n);
			int b=5;
			while(b<=a){
				if(n%b==0){
					return false;
				}
				if(n%(b+2)==0){
					return false;
				}
				b+=6;
			}
		}
		return true;
	}
}
