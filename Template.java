/*
ID: michael274
LANG: JAVA
TASK: Template
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Template {
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(new FileReader("C:/Users/Michael Luo/Documents/Competitive Programming/input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Michael Luo/Documents/Competitive Programming/output.txt")));
		//Scanner s = new Scanner(new FileReader("Template.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Template.out")));
		BigInteger temp = new BigInteger("0");
		temp.add(new BigInteger("8"));
		System.out.println(temp);
        out.close();                                
	}		
}
