import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution1A {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long n = s.nextInt();
		long m = s.nextInt();
		long a = s.nextInt();
		long c=0, d=0;
		if(n%a ==0){
			c = n/a;
		}else{
			c = n/a + 1;
		}
		if(m%a==0){
			d = m/a;
		}else{
			d = m/a+1;
		}
		System.out.println(c*d);
	}
}
