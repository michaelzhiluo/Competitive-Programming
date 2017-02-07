import java.io.*;
import java.util.*;

class cowdance {
	static int[] cowtimes;
	static int numcows;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("cowdance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		numcows = s.nextInt();
		int maxtime = s.nextInt();
		cowtimes = new int[numcows];
		for(int i=0; i<numcows; i++){
			cowtimes[i] = s.nextInt();
		}

		// Might have to do Binary Search 
		for(int i=1; i<=numcows; i++){
			if(computetime(i) <= maxtime){
				out.println(i);
				break;
			}
		}
		out.close();                                
	}

	public static int computetime(int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for(int i=0; i<k; i++){
			queue.add(cowtimes[i]);
		}
		for(int i=k ;i<numcows; i++){
			queue.add(queue.poll() + cowtimes[i]);
		}
		int max = 0;
		for(int i: queue){
			if(i > max){
				max =i;
			}
		}
		return max;
	}
}
