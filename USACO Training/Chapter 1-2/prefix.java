/*
ID: michael274
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

class prefix {
	static String[] prefix; 
	public static void main (String [] args) throws IOException {
		//Scanner s = new Scanner(new FileReader("/Users/michaelluo/Documents/workspace/USACO/input.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/michaelluo/Documents/workspace/USACO/output.txt")));
		Scanner s = new Scanner(new FileReader("prefix.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		ArrayList<String> prefixx = new ArrayList<String>();
		while(s.hasNext()){
			String temp = s.next();
			if(temp.equals(".")){break;}
			prefixx.add(temp);
		}
		prefix = new String[prefixx.size()];
		prefix = prefixx.toArray(prefix);
		StringBuilder gg = new StringBuilder();
		while(s.hasNext()){
			gg.append(s.next());
		}
		out.println(solve(gg.toString()));
		out.close();                                  
	}
	public static int solve(String sequence){
		boolean[] asdf = new boolean[sequence.length()+1];
		for(String p: prefix){
			if(p.equals(sequence.substring(0, p.length()))){
				asdf[p.length()] = true;
			}
		}
		
		for(int i=1; i<asdf.length; i++){
			if(asdf[i]){
				for(String p: prefix){
					if(i+p.length()>sequence.length()){continue;}
					if(p.equals(sequence.substring(i, i+p.length()))){
						asdf[i+p.length()] = true;
					}
				}	
			}
		}
		for(int i=asdf.length-1; i>0; i-- ){
			if(asdf[i]){return i;}
		}
		return 0;
		
	}

}
