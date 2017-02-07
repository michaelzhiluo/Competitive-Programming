/*
ID: michael274
LANG: JAVA
TASK: zerosum
*/	
import java.io.*;
import java.util.*;

class zerosum {
	static int n;
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("zerosum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		n = s.nextInt();
		String[][] operators = new String[(int)(Math.pow(3, n-1))][n-1];
		for(int i=0; i<operators.length; i++){
			int temp = Integer.parseInt(Integer.toString(i, 3)); // Convert i to base 3
			for(int j=n-2; j>=0; j--){
				switch(temp%10){
				case 0: operators[i][j] = " "; break;
				case 1:operators[i][j] = "+"; break;
				case 2:operators[i][j] = "-"; break;
				}
				temp/=10;
			}
			
		}
		for(int i=0; i<operators.length; i++){
			String sequence = "1";
			for(int j=0; j<n-1; j++){
				sequence += operators[i][j] + (j+2);
			}
			if(evaluate(sequence)==0){
				out.println(sequence);
			}
		}
		out.close();                                  
	}
	
	public static int evaluate(String lol){
		lol=lol.replaceAll("\\s","");
		lol=lol.replaceAll("\\+"," + ");
		lol=lol.replaceAll("-"," - ");
		StringTokenizer temp = new StringTokenizer(lol);
		int first = Integer.parseInt(temp.nextToken());
		while(temp.hasMoreTokens()){
			String gg = temp.nextToken();
			if(gg.equals("+")){
				first+=Integer.parseInt(temp.nextToken());
			}else if(gg.equals("-")){
				first-=Integer.parseInt(temp.nextToken());
			}
		}
		return first;
		
	}
	
	
	
	
}
