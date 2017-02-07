import java.io.*;
import java.util.*;

class cowcode {

	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		Scanner s = new Scanner(new FileReader("cowcode.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		String word = s.next();
		long n = Long.parseLong(s.next());
		ArrayList<Long> powers = new ArrayList<Long>();
		long counter = word.length();
		while(counter < n){
			powers.add(counter);
			counter = 2*counter;
		}

		for(int i=powers.size()-1; i>=0; i--){
			if(n <= powers.get(i)){
				continue;
			}
			n-=powers.get(i)+1;
			if(n<=0){
				n+=powers.get(i);
			}
		}      
		out.print(word.charAt((int)(n)-1));                 
		out.close();                                
	}
}
