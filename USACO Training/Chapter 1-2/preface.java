/*
ID: michael274
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

class preface {
	static HashMap<Character, Integer> numerals = new HashMap<Character, Integer>();
	static String[][] gg = { {"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", "N/A"}};
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		int n = s.nextInt();
		String[] nums = new String[n+1];
		for(int i=1; i<nums.length; i++){
			String temp = "";
			for(int j=0; j<("" + i).length(); j++){
				temp=roman(i, j) + temp;
			}
			nums[i] = temp;
		}
		int[] troll = new int[7];
		for(int i=1; i<nums.length; i++){
			String mrpeng = nums[i];
			for(int j=0; j<mrpeng.length(); j++){
				switch(mrpeng.charAt(j)){
				case 'I': troll[0]++; break;
				case 'V': troll[1]++; break;
				case 'X': troll[2]++; break;
				case 'L': troll[3]++; break;
				case 'C': troll[4]++; break;
				case 'D': troll[5]++; break;
				case 'M': troll[6]++; break;
				}
			}
		}
		
		for(int i=0; i<troll.length; i++){
			if(troll[i] ==0){
				break;
			}
			out.println(gg[i/2][i%2] + " " + troll[i]);
		}
		
		out.close();                                  
	}
	
	public static String roman(int i, int j){
		String lol = "" + i;
		int length = lol.length();
		switch(lol.charAt(length-j-1)){
		case '0': return "";
		case '1': return gg[j][0]; 
		case '2': return gg[j][0] + gg[j][0];
		case '3': return gg[j][0] + gg[j][0] + gg[j][0];
		case '4': return gg[j][0] + gg[j][1];
		case '5': return gg[j][1];
		case '6': return gg[j][1] + gg[j][0];
		case '7': return gg[j][1] + gg[j][0] + gg[j][0];
		case '8': return gg[j][1] + gg[j][0] + gg[j][0] + gg[j][0];
		case '9': return gg[j][0] + gg[j+1][0];
		}
		return "";
	}
}
