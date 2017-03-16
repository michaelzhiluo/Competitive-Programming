import java.io.*;
import java.util.*;

public class Solution753A {
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		double y = (-1.0 + Math.sqrt(1+4*(2*x)))/2;
		int k = (int)(y);
		int diff = x - k*(k+1)/2;
		System.out.println(k);
		for(int i=1; i<=k ;i++){
			if(i==k){
				System.out.println(i+diff);
			}
			else{
				System.out.print(i + " ");
			}
		}
	}
}

