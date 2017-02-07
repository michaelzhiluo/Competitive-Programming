/*
ID: michael274
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;

class sprime {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		int length = s.nextInt();
		ArrayList<Integer> onedigits = new ArrayList<Integer>();
		onedigits.add(2); onedigits.add(3); onedigits.add(5); onedigits.add(7);
		for(int i=1; i<length; i++){
			onedigits = primes(onedigits);
		}
		Collections.sort(onedigits);
		for(Integer a: onedigits){
			out.println(a);
		}
		out.close();                                  
	}
	
	public static ArrayList<Integer> primes(ArrayList<Integer> a){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int length = ("" + a.get(0)).length();
		for(int i=1; i<=9; i++){
			for(int j=0; j<a.size(); j++){
				int temp1 = 10*a.get(j)+i;
				if(isprime(temp1)){
					temp.add(temp1);
				}
			}
		}
		return temp;
	}
	
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
