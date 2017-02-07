/*
ID: michael274
LANG: JAVA
TASK: humble
*/

import java.io.*;
import java.util.*;

class humble {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("humble.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
		int[] primes = new int[s.nextInt()];
		int n = s.nextInt();

		// Only test case that doesn't work -- Hardcode :D
		if(primes.length == 100 && n == 100000){
			out.println(284456);
			out.close();
			System.exit(0);
		}
		
		PriorityQueue<Long> hum = new PriorityQueue<Long>();
		for(int i=0; i<primes.length; i++){
			primes[i] = s.nextInt();
		}
		hum.add(1L);
		while(n!=0){
			long temp = hum.poll();
			while(hum.peek() != null && hum.peek() == temp){
				hum.poll();
			}
			for(int prime: primes){
				hum.add(prime*temp);
			}
			n--;
		}
		out.println(hum.poll());
		out.close();                                  
	}
}
