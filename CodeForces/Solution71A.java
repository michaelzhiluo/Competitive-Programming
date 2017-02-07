import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution71A {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = s.nextInt();
		String[] hello = new String[n];
		for(int i=0; i<n; i++){
			hello[i] = s.next();
		}
		for(int i=0; i<n; i++){
			if(hello[i].length()>10){
				System.out.println(hello[i].charAt(0) + "" + (hello[i].length()-2)  + hello[i].charAt(hello[i].length()-1));
			}
			else{
				System.out.println(hello[i]);
			}
		}
	}
}
