import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution4A {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long watermelon_weight = s.nextInt();
		if(watermelon_weight <=2){
			System.out.println("NO"); System.exit(0);
		}
		if(watermelon_weight%2==1){
			System.out.println("NO");
		}else{
			System.out.println("YES");
		}
	}
}
