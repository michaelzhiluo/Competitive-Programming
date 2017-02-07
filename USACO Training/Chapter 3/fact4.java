/*
ID: michael274
LANG: JAVA
TASK: fact4
*/

import java.io.*;
import java.util.*;

class fact4 {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("fact4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
		int n = s.nextInt();
		int numzeroes = n/5 + n/25 + n/125 + n/625 + n/3125;
		int result = 1;
		int counter1 =0;
		while(n>0){
			if(n%5 ==0){
				int temp = n;
				while(temp%5 ==0){
					temp /=5;
				}
				result = (result*temp)%10;
			}
			else if(n%2==0 && counter1 < numzeroes){
				result = (result*(n/2))%10;
				counter1++;
			}else{
				result = (result*n)%10;
			}
			n--;
		}
		out.println(result);
		out.close();                                  
	}
}
